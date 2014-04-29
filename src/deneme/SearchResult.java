package deneme;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import com.mysql.jdbc.Statement;

public class SearchResult implements ActionListener{
public JFrame frame, frame1;
public JTextField textbox;
public JLabel label;
public JButton button;
public JPanel panel;
static JTable table;
public Connection con;
public Statement st;
public ResultSet rs;
public DefaultTableModel model;

String[] columnNames = {"Ogrenci No", "Ogrenci Ýsmi", "Ogrenci Sifre", "Dogru Cevap"};

public void createUI()
{
frame = new JFrame("Database Search Result");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.getContentPane().setLayout(null);
textbox = new JTextField();
textbox.setBounds(120,30,150,20); 
label = new JLabel("Enter your roll no");
label.setBounds(10, 30, 100, 20);
button = new JButton("search");
button.setBounds(120,130,150,20);
button.addActionListener(this);

frame.getContentPane().add(textbox);
frame.getContentPane().add(label);
frame.getContentPane().add(button);
frame.setVisible(true);
frame.setSize(500, 400); 
} 

public void actionPerformed(ActionEvent ae)
{
button = (JButton)ae.getSource();
System.out.println("Showing Table Data.......");
showTableData(); 
} 

public void showTableData()
{

frame1 = new JFrame("Database Search Result");
frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame1.getContentPane().setLayout(new BorderLayout()); 
//TableModel tm = new TableModel();
DefaultTableModel model = new DefaultTableModel();
model.setColumnIdentifiers(columnNames);
//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames()); 
//table = new JTable(model);
table = new JTable();
table.setModel(model); 
table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
table.setFillsViewportHeight(true);
JScrollPane scroll = new JScrollPane(table);
scroll.setHorizontalScrollBarPolicy(
JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
scroll.setVerticalScrollBarPolicy(
JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
String textvalue = textbox.getText();
String roll= "";
String name= "";
String cl = "";
String sec = "";
try
{ 
	Class.forName("com.mysql.jdbc.Driver").newInstance();
    System.out.print("sürücü yüklendi");
    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/etest", "root", "1234");
String sql = "select * from ogrencigirisbilgileri where ogrenci_id = "+textvalue;
PreparedStatement ps = con.prepareStatement(sql);
ResultSet rs = ps.executeQuery();
int i =0;
if(rs.next())
{
roll = rs.getString("ogrenci_id");
name = rs.getString("ogrencikullaniciadi");
cl = rs.getString("ogrencisifre");
sec = rs.getString("dogrucevaplar"); 
model.addRow(new Object[]{roll, name, cl, sec});
i++; 
}
if(i <1)
{
JOptionPane.showMessageDialog(null, "No Record Found","Error",
JOptionPane.ERROR_MESSAGE);
}
if(i ==1)
{
System.out.println(i+" Record Found");
}
else
{
System.out.println(i+" Records Found");
}
}
catch(Exception ex)
{
JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
JOptionPane.ERROR_MESSAGE);
}
frame1.getContentPane().add(scroll);
frame1.setVisible(true);
frame1.setSize(400,300);
}

public static void main(String args[])
{
SearchResult sr = new SearchResult();
sr.createUI(); 
}
}
