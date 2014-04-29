package deneme;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JRadioButton;

public class Workers extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JRadioButton radiobtnBirinci;
	public JRadioButton radiobtnIkinci;
	public JRadioButton radiobtnUcuncu;
	public JRadioButton radiobtnDorduncu;
	public JLabel labelSoru;
	public Connection con;
	public Statement st;
	public ResultSet rs;
	public String soru,birinci,ikinci,ucuncu,dorduncu,dogru;
	public int score=0;
	public RadioButtonHandler handler;
	

	public Workers() {
		DoConnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_soru = new JPanel();
		contentPane.add(panel_soru, BorderLayout.CENTER);
		panel_soru.setLayout(null);
		JPanel panel_siklar = new JPanel();
		
		panel_siklar.setBounds(32, 57, 331, 150);
		panel_soru.add(panel_siklar);
		panel_siklar.setLayout(null);
		
		labelSoru = new JLabel("");
		labelSoru.setBounds(32, 14, 46, 14);
		panel_soru.add(labelSoru);
		
		JButton btnNext = new JButton("Next button");
		btnNext.setBounds(208, 218, 89, 23);
		panel_soru.add(btnNext);
		
		
		final JRadioButton radiobtnBirinci = new JRadioButton("");
		radiobtnBirinci.setBounds(6, 7, 21, 21);
		panel_siklar.add(radiobtnBirinci);
		
		final JRadioButton radiobtnIkinci = new JRadioButton("");
		radiobtnIkinci.setBounds(6, 39, 109, 23);
		panel_siklar.add(radiobtnIkinci);
		
		final JRadioButton radiobtnUcuncu = new JRadioButton("");
		radiobtnUcuncu.setBounds(6, 72, 109, 23);
		panel_siklar.add(radiobtnUcuncu);
		
		final JRadioButton radiobtnDorduncu= new JRadioButton("");
		radiobtnDorduncu.setBounds(6, 98, 109, 23);
		panel_siklar.add(radiobtnDorduncu);
		
		ButtonGroup group = new ButtonGroup();
		group.add(radiobtnBirinci);
		group.add(radiobtnIkinci);
		group.add(radiobtnUcuncu);
		group.add(radiobtnDorduncu);

		handler = new RadioButtonHandler();
        radiobtnBirinci.addItemListener(handler);
        radiobtnIkinci.addItemListener(handler);
        radiobtnUcuncu.addItemListener(handler);
        radiobtnDorduncu.addItemListener(handler);
		
       
	
		
btnNext.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

					try {
						if ( rs.next( ) ) {
							
							//int id_col = rs.getInt("sid");
							//String id = Integer.toString(id_col);
							soru = rs.getString("soru");
							birinci = rs.getString("birincisik");
							ikinci = rs.getString("ikincisik");
							ucuncu = rs.getString("ucuncusik");
							dorduncu = rs.getString("dorduncusik");
							dogru = rs.getString("dogrusik");
							
							labelSoru.setText(soru);
							radiobtnBirinci.setText(birinci);
							radiobtnIkinci.setText(ikinci);
							radiobtnUcuncu.setText(ucuncu);
							radiobtnDorduncu.setText(dorduncu);
				
							
						}
						else {
						rs.previous( );
						//JOptionPane.showMessageDialog(Workers.this, "Dosya Sonu");
						JOptionPane.showMessageDialog(null,"Dogru Cevap Sayýsý: " +score,"",JOptionPane.INFORMATION_MESSAGE);
						}
						}
						catch (Exception s) {
							System.out.print(s.getMessage());
						}			
				
	
			}
		});
	}
	
	 public class RadioButtonHandler implements ItemListener {

 	    public void itemStateChanged(ItemEvent event)

 	    {
 	    	System.out.println("merhaba benim adým name");
 	    	if(event.getSource()==radiobtnIkinci){
 	    		score++;
 	        	
 	    	}   
 	   }      
 		
 	}
	
	
	public void DoConnect( ) {
		
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
            soru = rs.getString("soru");
            birinci = rs.getString("birincisik");
            ikinci = rs.getString("ikincisik");
            ucuncu = rs.getString("ucuncusik");
            dorduncu = rs.getString("dorduncusik");
            dogru = rs.getString("dogrusik");
            
            
            labelSoru.setText(soru);
			radiobtnBirinci.setText(birinci);
			radiobtnIkinci.setText(ikinci);
			radiobtnUcuncu.setText(ucuncu);
			radiobtnDorduncu.setText(dorduncu);  
 
			rs.next();
			
			
        }
        catch (Exception s)
        {
            System.out.print(s.getMessage());
        } 

	}
	
	
	 public static void main(String[]args)

	    {
			 Workers frame = new Workers();
				frame.setVisible(true);

	    }
}
