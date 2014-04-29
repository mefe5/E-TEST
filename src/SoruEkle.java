import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class SoruEkle extends JFrame
{

	private static final long serialVersionUID = 1L;
	JFrame frmSoru;
    JPanel pnl, pnl_soru;
    JTextField txt_listele, txt_arama;
	static JTextField txt_soruGirisi;
	JTextField txt_birinciSik;
	JTextField txt_ikinciSik;
	JTextField txt_ucuncuSik;
	JTextField txt_dorduncuSik;
	JTextField txt_dogruSik;
    JLabel lbl_soru, lbl_birincisik, lbl_ikinciSik, lbl_ucuncuSik, lbl_dorduncuSik, lbl_dogruSik, lbl_SoruEklemeEkrani;
    JButton btn_soruCikis, btn_duzenle, btn_yeniSoru;
    JLabel lbl_KonuBasligi;
    Connection conn = null;
    ResultSet rs = null;
    Statement komut = null;
    
    
    public SoruEkle()
    {
        frmSoru=new JFrame("Soru Ekle");
        
        frmSoru.addWindowListener(new WindowAdapter() {
        	@Override
        	public void windowOpened(WindowEvent arg0) {
        		
        		conn=Dbconnect.conect();
        	}
        });
        
        
        frmSoru.setTitle("E-TEST");
        frmSoru.setBounds(100, 100, 500, 500);
        frmSoru.setVisible(true);
        frmSoru.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lbl_SoruEklemeEkrani = new JLabel("Soru Ekleme Ekran\u0131");
        lbl_SoruEklemeEkrani.setFont(new Font("arial", Font.BOLD, 15));
        lbl_SoruEklemeEkrani.setBounds(10, 2, 300, 20);
        frmSoru.getContentPane().add(lbl_SoruEklemeEkrani);
        soruPaneli();
        frmSoru.getContentPane().add(pnl_soru);


       
    }

    public void soruPaneli()
    {
        pnl_soru =new JPanel();
        pnl_soru.setBackground(Color.lightGray);
        pnl_soru.setBounds(100, 100, 500, 500);
        pnl_soru.setLayout(null);
        

        lbl_soru   = new JLabel("Soru");
        lbl_soru.  setBounds(10, 35, 200, 20);
        txt_soruGirisi   = new JTextField();
        txt_soruGirisi.  setBounds(170, 23, 270, 30);
        lbl_birincisik          =new JLabel("Birinci \u015E\u0131k");
        lbl_birincisik.         setBounds(10, 95, 200, 20);
        txt_birinciSik          =new JTextField();
        txt_birinciSik.         setBounds(170, 95, 270, 20);
        lbl_ikinciSik    = new JLabel("\u0130kinci \u015E\u0131k");
        lbl_ikinciSik.   setBounds(10, 120, 200, 20);
        txt_ikinciSik    = new JTextField();
        txt_ikinciSik.   setBounds(170, 120, 270, 20);
        lbl_ucuncuSik   = new JLabel("\u00DC\u00E7\u00FCnc\u00FC \u015E\u0131k");
        lbl_ucuncuSik.  setBounds(10, 145, 200, 20);
        txt_ucuncuSik   = new JTextField();
        txt_ucuncuSik.  setBounds(170, 145, 270, 20);
        lbl_dorduncuSik  = new JLabel("D\u00F6rd\u00FCnc\u00FC \u015E\u0131k");
        lbl_dorduncuSik. setBounds(10, 170, 200, 20);
        txt_dorduncuSik  = new JTextField();
        txt_dorduncuSik. setBounds(170, 170, 270, 20);
        lbl_dogruSik          = new JLabel("Do\u011Fru \u015E\u0131k");
        lbl_dogruSik.         setBounds(10, 201, 200, 20);
        txt_dogruSik          = new JTextField();
        txt_dogruSik.         setBounds(170, 201, 270, 20);
        btn_yeniSoru       =new JButton("Kaydet");
        btn_yeniSoru.      setBounds(170, 270, 90, 30);
        btn_duzenle         =new JButton("Güncelle");
        btn_duzenle.        setBounds(260, 270, 90, 30);
        btn_soruCikis    = new JButton("Çýkýþ");
        btn_soruCikis.   setBounds(350, 270, 90, 30);
        lbl_KonuBasligi = new JLabel("Konu Basligi");
        lbl_KonuBasligi.setBounds(10, 235, 83, 14);
        
        
        
        

        
        
      
        pnl_soru.add(lbl_soru);
        pnl_soru.add(txt_soruGirisi);
        pnl_soru.add(lbl_birincisik);
        pnl_soru.add(txt_birinciSik);
        pnl_soru.add(lbl_ikinciSik);
        pnl_soru.add(txt_ikinciSik);
        pnl_soru.add(lbl_ucuncuSik);
        pnl_soru.add(txt_ucuncuSik);
        pnl_soru.add(lbl_dorduncuSik);
        pnl_soru.add(txt_dorduncuSik);
        pnl_soru.add(lbl_dogruSik);
        pnl_soru.add(txt_dogruSik);
        pnl_soru.add(btn_yeniSoru);
        pnl_soru.add(btn_duzenle);
        pnl_soru.add(btn_soruCikis);
        pnl_soru.add(lbl_KonuBasligi);
        final JComboBox<String> comboBox = new JComboBox<String>();
        comboBox.setBounds(170, 239, 251, 20);
        pnl_soru.add(comboBox);
        
        
            try
            {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                System.out.print("sürücü yüklendi");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/etest", "root", "1234");
                Statement komut = conn.createStatement();
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
           
        
       /* btn_duzenle.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    System.out.print("sürücü yüklendi");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/etest", "root", "1234");
                    Statement komut = conn.createStatement();
                    String sorgu = "update tb_bilgiler set sifre = '" + txt_birinciSik.getText() + "', cihazModeli= '"
                        + txt_ikinciSik.getText()+ "', cihazArizasi= '"+ txt_ucuncuSik.getText() + "', verilisTarihi= '"
                        //+ txt_dorduncuSik.getText() + "', garantiKapsami= '"+ cb_yGarantiKapsami.getSelectedIndex()
                        //+ "', Durumu = '" + cb_yDurumu.getSelectedIndex()+ "', adres= '"+ txt_dogruSik.getText()
                        + "' where kullanici_adi= '" + txt_soruGirisi.getText() + "'" ;
                    komut.executeUpdate(sorgu);  
                }
                catch (Exception s)
                {
                    System.out.print(s.getMessage());
                }
            }
        }
        );
        */

        btn_yeniSoru.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                try
                {
                    
                    komut = conn.createStatement();
                    String sorgu="insert into sorular "
                        + "(soru, birincisik, ikincisik, ucuncusik, dorduncusik, dogrusik, konuadi)"
                        + "VALUES ('" +txt_soruGirisi.getText()+ "','"
                        + txt_birinciSik.getText() + "','"
                        + txt_ikinciSik.getText()+ "','"
                        + txt_ucuncuSik.getText() + "','"
                        + txt_dorduncuSik.getText()+ "','"                   
                        + txt_dogruSik.getText() + "','"
                        + comboBox.getSelectedItem().toString() + "')";
                    komut.executeUpdate(sorgu); 
                    JOptionPane.showMessageDialog(SoruEkle.this, "Soru Eklendi");
                    String name = comboBox.getSelectedItem().toString();
                    System.out.println(name);
                    
                }
                catch (Exception s)
                {
                    System.out.print(s.getMessage());
                }
            }
        }
        );


        btn_soruCikis.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {                
                frmSoru.dispose();
                
            }
        }
         );
    }    
}