import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SinavOl extends JFrame {

	private JPanel contentPane;
	java.sql.Connection con = null;
    java.sql.ResultSet rs = null;
    java.sql.Statement komut = null;
    public static String konu;


	public SinavOl() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(20, 23, 197, 36);
		panel.add(comboBox);
		
		JButton btn_sinavBasla = new JButton("Sinava Basla");
		btn_sinavBasla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				konu = comboBox.getSelectedItem().toString();
				SinavSistemi ss = new SinavSistemi();
                ss.setVisible(true);
				
				
			}
		});
		btn_sinavBasla.setBounds(230, 23, 104, 36);
		panel.add(btn_sinavBasla);
		
	       try
           {
               Class.forName("com.mysql.jdbc.Driver").newInstance();
               System.out.print("sürücü yüklendi");
               con = DriverManager.getConnection("jdbc:mysql://localhost:3306/etest", "root", "1234");
               komut = con.createStatement();
               ResultSet rs = komut.executeQuery("select * from konular" );   
 
               while (rs.next())
               {
               	comboBox.addItem(rs.getString("konuadi"));
               }
               
           }
           catch (Exception s)
           {
               System.out.print(s.getMessage());
           }
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SinavOl frame = new SinavOl();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
