import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class SinavSistemi extends JFrame {

	private static final long serialVersionUID = 1L;
	public JLabel q1,q2;
    public JButton ok;
    public JRadioButton a1,a2,a3,a4,b1,b2,b3,b4;
    public JPanel pnl1,pnl2,pnlchoices1,pnlchoices2;
    public String soru,birinci,ikinci,ucuncu,dorduncu;
    public ButtonGroup grp1,grp2,grp3,grp4,grp5;
    public String dogru;
    public int score=0;
    public Connection con;
	public Statement st;
	public ResultSet rs;
	private List<JRadioButton> correctButtons;
	public Container container;
	
    public SinavSistemi ()

    {
    	super("Sýnav");
    	addWindowListener(new WindowAdapter() {
    		@Override
    		public void windowOpened(WindowEvent arg0) {
    			con = Dbconnect.conect();
    		}
    	});
    	
    	
        container = getContentPane();

        container.setLayout(new GridLayout(11,1));
        correctButtons = new ArrayList<JRadioButton>();        
        
        
        
		        try
		        {
		            Class.forName("com.mysql.jdbc.Driver").newInstance();
		            System.out.print("sürücü yüklendi");
		            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/etest", "root", "1234");
		            st = con.createStatement();
		            
		            String sql = "Select * from sorular where konuadi = '"+ SinavOl.konu+"'";
		            rs = st.executeQuery(sql);
		                
		            //int id_col = rs.getInt("sid");
		            //String id = Integer.toString(id_col);
		            while ( rs.next()) {
		                String soru = rs.getString("soru");
		                String birinci = rs.getString("birincisik");
		                String ikinci = rs.getString("ikincisik");
		                String ucuncu = rs.getString("ucuncusik");
		                String dorduncu = rs.getString("dorduncusik");
		                String dogru = rs.getString("dogrusik");

		                // Calls to q1.setText, a1.setText, etc. moved from here.

		                pnl1 = new JPanel();
		                pnl1.setLayout(new GridLayout(1,1));

		                q1 = new JLabel();
		                pnl1.add(q1);
		                pnlchoices1 = new JPanel();
		                pnlchoices1.setLayout(new GridLayout(2,2));  
		                a1 = new JRadioButton();
		                a2 = new JRadioButton();
		                a3 = new JRadioButton();
		                a4 = new JRadioButton();

		                pnlchoices1.add(a1);
		                pnlchoices1.add(a2);
		                pnlchoices1.add(a3);
		                pnlchoices1.add(a4);

		                container.add(pnl1);

		                container.add(pnlchoices1);
		                grp1 = new ButtonGroup();
		                grp1.add(a1);
		                grp1.add(a2);
		                grp1.add(a3);
		                grp1.add(a4);

		                // Calls to q1.setText etc moved here.
		                q1.setText(soru);
		                a1.setText(birinci);
		                a2.setText(ikinci);
		                a3.setText(ucuncu);
		                a4.setText(dorduncu);

		                // Figure out which button is for the correct answer
		                // and add it to our list of correct buttons.
		                if (dogru.equals(birinci)) {
		                    correctButtons.add(a1);
		                } else if (dogru.equals(ikinci)) {
		                    correctButtons.add(a2);
		                } else if (dogru.equals(ucuncu)) {
		                    correctButtons.add(a3);
		                } else if (dogru.equals(dorduncu)) {
		                    correctButtons.add(a4);
		                } else {
		                    // If we get here, the correct answer is not one of the
		                    // options.  I don't know how you want to handle this.
		                }
		            }
		            
		           }
		        
		        catch (Exception s)
		        {
		            System.out.print(s.getMessage());
		        } 


        ok = new JButton("Sýnav Bitir");

        ok.setBackground(Color.GRAY);

        container.add(ok);
     

        setSize(500,500);

        setVisible(true);


        ButtonHandler btnHandler = new ButtonHandler();

        ok.addActionListener(btnHandler);
        
       
    }
    /*public void DoConnect( ) {
		
		try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.print("sürücü yüklendi");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/etest", "root", "1234");
            st = con.createStatement();
            //rs = st.executeQuery("select * from person");
            
            
            st = con.createStatement();
            String sql = "Select * from sorular";
            rs = st.executeQuery(sql);
            
           rs.next() ;
            //int id_col = rs.getInt("sid");
            //String id = Integer.toString(id_col);
            
            String soru = rs.getString("soru");
            String birinci = rs.getString("birincisik");
            String ikinci = rs.getString("ikincisik");
            String ucuncu = rs.getString("ucuncusik");
            String dorduncu = rs.getString("dorduncusik");
            
            q1.setText(soru);
			a1.setText(birinci);
			a2.setText(ikinci);
			a3.setText(ucuncu);
			a4.setText(dorduncu);
           }
        
        catch (Exception s)
        {
            System.out.print(s.getMessage());
        } 

	}
    
    */

    public class ButtonHandler implements ActionListener{

    	      public void actionPerformed(ActionEvent event){

    	         if (event.getSource()==ok)

    	         {
    	        	 
    	             for (JRadioButton correctButton : correctButtons) {
    	                 if (correctButton.isSelected()) {
    	                     score++;
    	                 }
    	             }
    	             
    	             
    	             try
                     {
                         
                         st = con.createStatement();
                         String rs="UPDATE ogrencigirisbilgileri SET dogrucevaplar='" + score + "' where ogrenci_id= '" + GirisEkrani.ogrenci_id +"'  "  ;
                         st.executeUpdate(rs); 
                         
                     }
                     catch (Exception s)
                     {
                         System.out.print(s.getMessage());
                     }
   
    	             
    	            JOptionPane.showMessageDialog(null,"Dogru Cevap Sayýsý: " +score,"",JOptionPane.INFORMATION_MESSAGE);
    	         
    	            dispose();
 
    	         }

    	      }

    	   }
    	}