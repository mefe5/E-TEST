package deneme;


import javax.swing.*;  

//Java Extension Package  
import java.awt.*;  
import java.awt.event.*;  
import java.sql.*;  

public class scanDatabase extends JFrame {  
 

	private static final long serialVersionUID = 1L;
//Initializing Program Components  
private JTextField inputs[];  
private JButton scan[];  
private String butLabel[] = {"First","Last","Next","Prev"};  
private JLabel labels[];  
private String fldLabel[] = {"ID","First Name: ","Middle Name: ","Family Name: ","Age: "};  
private JPanel p1,p2;  
 
Connection con =null;  
Statement st=null;  
ResultSet rs=null;  
String db;  


//Setting up GUI  
  public scanDatabase() {  
     
   //Setting up the Title of the Window  
   super("Scan Database");
 


   //Set Size of the Window (WIDTH, HEIGHT)  
   setSize(305,160);  

   //Exit Property of the Window  
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
  
//Constructing Program Components  
   inputs = new JTextField[5];  
   labels = new JLabel[5];  
   scan = new JButton[4];  
   p1 = new JPanel();  
   p1.setLayout(new GridLayout(5,2));  
   p2 = new JPanel();  
   p2.setLayout(new GridLayout(1,1));  

   //Setting up the container ready for the components to be added.  
   Container pane = getContentPane();  
   setContentPane(pane);  
     
   //Creating a connection to MS Access and fetching errors using "try-catch" to check if it is successfully connected or not.  
   try {  
	  Class.forName("com.mysql.jdbc.Driver").newInstance();
       System.out.print("sürücü yüklendi");
       con = DriverManager.getConnection("jdbc:mysql://localhost:3306/etest", "root", "");
       st = con.createStatement();
       rs = st.executeQuery("select * from person");      
	    rs.first();
con.close();
           
 } catch (Exception e) {  
  JOptionPane.showMessageDialog(null,"Failed to Connect to Database","Error Connection", JOptionPane.ERROR_MESSAGE);  
  System.exit(0);  
 }  
     
   //Constructing JLabel and JTextField using "for loop" in their desired order  
   for(int count=0; count<inputs.length && count<labels.length; count++) {  
    labels[count] = new JLabel(fldLabel[count]);  
    inputs[count] = new JTextField(30);  
    //Adding the JLabel and the JTextFied in JPanel 1  
    p1.add(labels[count]);  
    p1.add(inputs[count]);  
   }  
     
   //Constructing JButton using "for loop"  
   for(int count=0; count<scan.length; count++) {  
    scan[count] = new JButton(butLabel[count]);  
    //Adding the JButton in JPanel 2  
    p2.add(scan[count]);  
   }  
     
//Implemeting Even-Listener on JButton first  
scan[0].addActionListener(  
new ActionListener() {  
   
 //Handle JButton event if it is clicked  
 public void actionPerformed(ActionEvent event) {  
  try {  
     
   rs=st.executeQuery("select * from person");  
   if (rs.first())  
    displayRes();  
      
  }catch (Exception e ) {  
   System.out.println("Fail to Connect to the Database");  
  }  
 }  
}  
);  
  
//Implemeting Even-Listener on JButton last  
scan[1].addActionListener(  
new ActionListener() {  
   
 //Handle JButton event if it is clicked  
 public void actionPerformed(ActionEvent event) {  
  try {  
     
   rs=st.executeQuery("select * from person");  
   if (rs.last())  
    displayRes();  
      
  }catch (Exception e ) {  
   System.out.println("Fail to Connect to the Database");  
  }  
 }  
}  
);  
  
//Implemeting Even-Listener on JButton next  
scan[2].addActionListener(  
new ActionListener() {  
   
 //Handle JButton event if it is clicked  
 public void actionPerformed(ActionEvent event) {  
  try {  
     
   if(rs!=null || (!rs.next()))  
    rs.next();  
    displayRes();  
      
  }catch (Exception e ) {  
   System.out.println("You have reached the last Data.");  
  }  
 }  
}  
);  
  
//Implemeting Even-Listener on JButton last  
scan[3].addActionListener(  
new ActionListener() {  
   
 //Handle JButton event if it is clicked  
 public void actionPerformed(ActionEvent event) {  
  try {  
     
   if(rs!=null)  
    rs.previous();  
    displayRes();  
      
  }catch (Exception e ) {  
   System.out.println("You have reached the first Data.");  
  }  
 }  
}  
);  
  
//Adding JPanel 1 and 2 to the container  
pane.add(p1, BorderLayout.NORTH);  
pane.add(p2, BorderLayout.SOUTH);  
  
   /**Set all the Components Visible. 
    * If it is set to "false", the components in the container will not be visible. 
    */  
   setVisible(true);  
   setResizable(false);  
  }  
    
  //Creating a method used to retrieve data from database and display in JTextField  
  public void displayRes() throws Exception {  
   inputs[0].setText(rs.getString(1));  
   inputs[1].setText(rs.getString(2));  
   inputs[2].setText(rs.getString(3));  
   inputs[3].setText(rs.getString(4));  
   inputs[4].setText(rs.getString(5));  
  }  
    
//Main Method  
  public static void main (String[] args) {  
   scanDatabase sd = new scanDatabase();  
}  
}  

