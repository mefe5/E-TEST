package deneme;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class TestSayfasi implements ActionListener  {
   ButtonGroup myGroup = null;
   JLabel myLebal = null;
   public static TestSayfasi myTest;
   private static String name;
   public static void main(String[] a) {
      

    	   TestSayfasi myTest = new TestSayfasi();
    	      myTest.createFrame();      
   }

   public void createFrame() {
	   JFrame f = new JFrame("My Radio Buttons");
	      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      Container c = f.getContentPane();
	      c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));
	      myGroup = new ButtonGroup();
	      JPanel p = new JPanel();
	      p.setLayout(new GridLayout(3,1));
      try
      {
          
          String connectionString = "jdbc:mysql://localhost:3306/etest";
          Class.forName("com.mysql.jdbc.Driver");
          Connection baglanti = (Connection) DriverManager.getConnection(connectionString,"root","");
          try {

              String SQL = "SELECT birincisik FROM sorular ORDER BY sid DESC";
              Statement durum = (Statement) baglanti.createStatement();
              ResultSet rs = (ResultSet) durum.executeQuery(SQL);
              Vector<String> data = new Vector<String>();
             
              while (rs.next()) {
                 System.out.println(rs.getString("birincisik"));
                 data.add(rs.getString("birincisik"));
                 addOption(p,myGroup,rs.getString("birincisik"));
              }
           }
           catch (Exception e) {
              e.printStackTrace();
           }
      }
      catch (Exception e)
      {
           e.printStackTrace();
      }
     
      addOption(p,myGroup,"Green");
      addOption(p,myGroup,"Blue");
      c.add(p);
      JButton b = new JButton("Select");
      b.addActionListener(this);
      c.add(b);
      myLebal = new JLabel("Please select",SwingConstants.CENTER);
      c.add(myLebal);
      f.pack();
      f.setLocationRelativeTo(null);
      f.setVisible(true);
   }
   public void addOption(JPanel p, ButtonGroup g, String t) {
      JRadioButton b = new JRadioButton(t);
      b.setActionCommand(t);
      p.add(b);
      g.add(b);
   }
   public void actionPerformed(ActionEvent e) {
      ButtonModel b = myGroup.getSelection();
      String t = "Not selected";
      if (b!=null) t = b.getActionCommand();
      myLebal.setText(t);
   }

}