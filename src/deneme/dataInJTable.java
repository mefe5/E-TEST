package deneme;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


public class dataInJTable extends JFrame{


 //This Vector Of A String Vector will be used to hold data from 
 // database table to display in JTable.
 static Vector<Vector<String>> data=new Vector<Vector<String>>();
 
 static JTable table;
 
 public dataInJTable()
 {
  super("JTabe with MySql Database");
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
  JPanel topPanel=new JPanel();
 
  JLabel label1=new JLabel("MySQL Database Name  :   test");
  label1.setPreferredSize(new Dimension(200,30));
  
  JLabel label2=new JLabel("MySQL Table Name     :  One");
  label2.setPreferredSize(new Dimension(200,30));
  
  topPanel.add(label1);
  topPanel.add(label2);
  
  getContentPane().add(topPanel,BorderLayout.NORTH);
  
  
  Vector<String> headers=new Vector<String>();
   headers.add("konu");
   


  getData();
  
  //this is the model which contain actual body of JTable
  DefaultTableModel model = new DefaultTableModel(data, headers);
  table=new JTable(model);
  table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
  
  
  header_size();
  
  JScrollPane scroll = new JScrollPane(table);
  
  scroll.setHorizontalScrollBarPolicy(
    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
  scroll.setVerticalScrollBarPolicy(
    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
  
  getContentPane().add(scroll,BorderLayout.SOUTH);
  pack();
  setResizable(false);
  setVisible(true);
 }
 
 
 /**
  * Setting the particular Column Size in JTable
  */
 public static void header_size() {
        TableColumn column = table.getColumnModel().getColumn(0);
        column.setPreferredWidth(100);


        column = table.getColumnModel().getColumn(0);
        column.setPreferredWidth(350);


     }
 
 
 /**
  * Fetching Data From MySql Database 
  * and storing in a Vector of a Vector
  * to Display in JTable
  */
 private static void getData()
 {
  // Enter Your MySQL Database Table name in below Select Query.
  String str="select * from konular";
  Connection con;
  ResultSet rs;
  Statement st;
  
  try {
   con=DriverManager.getConnection("jdbc:mysql://" + "localhost:3306/etest","root","1234");
   st= con.createStatement();
   rs=st.executeQuery(str);
   
   while(rs.next())
   {
    Vector <String> d=new Vector<String>();
    
    d.add(rs.getString("konuadi"));
    
    d.add("\n\n\n\n\n\n\n");
    data.add(d);
   }
   
  } catch (SQLException e) {
   
   e.printStackTrace();
  }
 }
 
 
 
 public static void main(String[] args) {
  
  new dataInJTable();
 }


}