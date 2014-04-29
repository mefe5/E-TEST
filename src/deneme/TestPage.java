package deneme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Testpage extends JFrame implements ActionListener
{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public static String usr;
JMenuBar mbr;
JMenu File,Help;
JPanel p1,p2;
JLabel l1,l2,l3,l4,l5,l6,l7,l8;
JButton b1,b3;
JRadioButton opt1,opt2,opt3,opt4;
ButtonGroup bgp;
Color c1,c2;
Font f1,f2;
public Testpage()
{
mbr=new JMenuBar();
setJMenuBar(mbr);
File=new JMenu("File");
Help=new JMenu("Help");
p1=new JPanel();
p2=new JPanel();
l1=new JLabel("                    Tech-Quiz");
l2=new JLabel("Q: ");
l3=new JLabel("1.) ");
l4=new JLabel("2.) ");
l5=new JLabel("3.) ");
l6=new JLabel("4.) ");
l7=new JLabel("                                                                                                                               dEaD_SiN");
l8=new JLabel("qq");
b1=new JButton("Next Ques");
b3=new JButton("Im too Scared");
c1=new Color(23,54,93);
c2=new Color(255,192,0);
  opt1 = new JRadioButton("opt1");
  opt2 = new JRadioButton("opt2");
  opt3 = new JRadioButton("opt3");
  opt4 = new JRadioButton("opt4");

bgp = new ButtonGroup();
 
bgp.add(opt1);
 bgp.add(opt2);
 bgp.add(opt3);
 bgp.add(opt4);
f1=new Font("Broadway",Font.BOLD,72);
f2=new Font("Comic Sans Ms",Font.BOLD,20);
//b1.addActionListener(this);
b3.addActionListener(this);
	
	p1.setLayout(new BorderLayout());
	
	l1.setBounds(250,250,300,300);
	l1.setFont(f1);
	l1.setForeground(c2);
	l2.setBounds(50,15,1300,300);
	l2.setFont(f2);
	l2.setForeground(c2);	
	l8.setBounds(100,15,1300,300);
	l8.setFont(f2);
	l8.setForeground(c2);		
	l3.setBounds(50,100,1300,300);
	l3.setFont(f2);
	l3.setForeground(c2);
	l4.setBounds(50,150,1300,300);
	l4.setFont(f2);
	l4.setForeground(c2);
	b1.setBounds(900,280,200,35);
	
	b3.setBounds(900,380,200,35);
	l5.setBounds(50,200,1300,300);
	l5.setFont(f2);
	l5.setForeground(c2);
	l6.setBounds(50,250,1300,300);
	l6.setFont(f2);
	l6.setForeground(c2);
	l7.setBounds(1,250,1300,300);
	l7.setFont(f2);
	l7.setForeground(Color.black);
	l7.setBackground(c2);
      opt1.setBounds(150,235,100,30);
      opt2.setBounds(150,285,100,30);
      opt3.setBounds(150,335,100,30);
      opt4.setBounds(150,385,100,30);
	opt1.setBackground(c1);
	opt1.setForeground(c2);
	opt2.setBackground(c1);
	opt2.setForeground(c2);	
	opt3.setBackground(c1);
	opt3.setForeground(c2);	
	opt4.setBackground(c1);
	opt4.setForeground(c2);
	mbr.add(File);
	mbr.add(Help);
	p2.setLayout(null);
	p2.setBackground(c1);
	p2.add(l2);
	p2.add(l3);
	p2.add(l4);
	p2.add(b1);
	p2.add(l5);
	p2.add(l6);
	p2.add(l8);
	p2.add(b3);
	p2.add(opt1);
	p2.add(opt2);
	p2.add(opt3);
	p2.add(opt4);	
	p1.add(l1,BorderLayout.NORTH);
	p1.add(p2,BorderLayout.CENTER);
	p1.add(l7,BorderLayout.SOUTH);
	p1.setBackground(c1);	
	add(p1);
	
addWindowListener(new WindowAdapter(){
public void windowClosing(WindowEvent evt){
System.exit(0);
}
});
setVisible(true);
setSize(1280,700);
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b3)
{
System.exit(0);
}
/*
else if(ae.getSource()==b1)
{
login o1=new login();
setVisible(false);
}
*/
}
public static void main(String x[])
{
new Testpage();
String dataSourceName = "techquiz";
String dbURL = "jdbc:odbc:" + dataSourceName;
try { 
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con = DriverManager.getConnection(dbURL, "",""); 
System.out.println("hello");
Statement s = con.createStatement();
s.execute("SELECT Question FROM Ques WHERE id=2 ");
ResultSet rs = s.getResultSet();
if (rs != null) // if rs == null, then there is no ResultSet to view
while ( rs.next() ) // this will step through our data row-by-row
{

System.out.println("Data from column_name: " + rs.getString(1) );
System.out.println(rs.getString(1) );
//usr=rs.getString(1).toUpperCase();
//System.out.println(usr);
}
}
catch (Exception err) {
System.out.println( "Error: " + err );
}
}
}