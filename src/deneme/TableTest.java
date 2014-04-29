package deneme;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.AbstractTableModel;

class TableTest extends JFrame
{

private static Connection con = null;
private static String URL = "jdbc:postgresql://192.xxx.x.xxx:5432";
private static String driver = "org.postgresql.Driver";
private static String user = "xxxx";
private static String pass = "xxxx";

/**
* Main application entry point
* @param args
* @throws SQLException
*/
public static void main(String[] args) throws SQLException 
{

// a Postgresql statement
Statement stmt;
// a Postgresql query
String query;
// the results from a Postgresql query
ResultSet rs;

// 2 dimension array to hold table contents
// it holds temp values for now
Object rowData[][] = {{"Row1-Column1", "Row1-Column2", "Row1-Column3", "Row1-Column4"}};
// array to hold column names
Object columnNames[] = {"IP", "Interface", "Status", "Speed"};

// create a table model and table based on it
DefaultTableModel mTableModel = new DefaultTableModel(rowData, columnNames);
JTable table = new JTable(mTableModel);

// try and connect to the database 
try {
Class.forName(driver).newInstance();
con = DriverManager.getConnection(URL, user, pass);
} catch (Exception e) {
System.err.println("Exception: " + e.getMessage());
}

// run the desired query
query = "SELECT * FROM twee ORDER BY ip ASC;";
//make a statement with the server
stmt = con.createStatement();
//execute the query and return the result
rs = stmt.executeQuery(query);

// create the gui
JFrame frame = new JFrame();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
JScrollPane scrollPane = new JScrollPane(table);
frame.add(scrollPane, BorderLayout.CENTER);
frame.setSize(500, 300);
frame.setVisible(true);

// remove the temp row
mTableModel.removeRow(0);

// create a temporary object array to hold the result for each row
Object[] rows;
// for each row returned
while (rs.next()) {
// add the values to the temporary row
rows = new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
// add the temp row to the table
mTableModel.addRow(rows);

}

}

private TableTest() 
{
}
}