package deneme;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class RSAccounts extends JFrame {

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

	
    public RSAccounts ()

    {
    	
    	
        Container container = getContentPane();

        container.setLayout(new GridLayout(11,1));
        
        	
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

		     
		        try
		        {
		            Class.forName("com.mysql.jdbc.Driver").newInstance();
		            System.out.print("sürücü yüklendi");
		            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/etest", "root", "1234");
		            st = con.createStatement();
		            
		            String sql = "Select * from sorular";
		            rs = st.executeQuery(sql);
		            
		         
		            //int id_col = rs.getInt("sid");
		            //String id = Integer.toString(id_col);
		            while ( rs.next()) {
		            	
		            soru = rs.getString("soru");
		            birinci = rs.getString("birincisik");
		            ikinci = rs.getString("ikincisik");
		            ucuncu = rs.getString("ucuncusik");
		            dorduncu = rs.getString("dorduncusik");
		            dogru = rs.getString("dogrusik");
		            
		           
		            
		            q1.setText(soru);
					a1.setText(birinci);
					a2.setText(ikinci);
					a3.setText(ucuncu);
					a4.setText(dorduncu);
					
					 pnl1 = new JPanel();
				        pnl1.setLayout(new GridLayout(1,1));
				        
				        
				        q1 = new JLabel();
				        pnl1.add(q1);

				        pnlchoices1 = new JPanel();

				        pnlchoices1.setLayout(new GridLayout(2,2));  

				        
				    

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
				        
				        RadioButtonHandler handler = new RadioButtonHandler();

				        a1.addItemListener(handler);

				        a2.addItemListener(handler);

				        a3.addItemListener(handler);

				        a4.addItemListener(handler);
		        }
		            System.out.println(soru);
		           }
		        
		        catch (Exception s)
		        {
		            System.out.print(s.getMessage());
		        } 


		        
		        
		      	        
        pnl2 = new JPanel();

        pnl2.setLayout(new GridLayout(1,1));

        q2 = new JLabel(" Hangisi en büyüktür?");

        pnl2.add(q2);

        pnlchoices2 = new JPanel();

        pnlchoices2.setLayout(new GridLayout(2,2));    

        b1 = new JRadioButton(" 1");

        b2 = new JRadioButton(" 2");

        b3 = new JRadioButton(" 3");

        b4 = new JRadioButton("4");

        pnlchoices2.add(b1);

        pnlchoices2.add(b2);

        pnlchoices2.add(b3);

        pnlchoices2.add(b4);

         

        container.add(pnl2);

        container.add(pnlchoices2);

        ok = new JButton("Sýnav Bitir");

        ok.setBackground(Color.RED);

        container.add(ok);
        
       

        setSize(500,500);

        setVisible(true);

        

        RadioButtonHandler handler2 = new RadioButtonHandler();

        b1.addItemListener(handler2);

        b2.addItemListener(handler2);

        b3.addItemListener(handler2);

        b4.addItemListener(handler2);
        
        grp2 = new ButtonGroup();

        grp2.add(b1);

        grp2.add(b2);

        grp2.add(b3);

        grp2.add(b4);


         

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
    

        public static void main(String[]args)

    {

        RSAccounts application = new RSAccounts();

        application.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

     

    public class RadioButtonHandler implements ItemListener {

        public void itemStateChanged(ItemEvent event)

        {
        	System.out.println("merhaba benim adým name");
        	if(a1.getText().toString().equals(dogru.toString())){
        		score++;
            	
        	}
    	   
    	   
       }

    }

    public class ButtonHandler implements ActionListener{

    	      public void actionPerformed(ActionEvent event){

    	         if (event.getSource()==ok)

    	         {
    	        	
    	            JOptionPane.showMessageDialog(null,"Dogru Cevap Sayýsý: " +score,"",JOptionPane.INFORMATION_MESSAGE);

    	            //dispose();
 
    	         }

    	      }

    	   }
    	}