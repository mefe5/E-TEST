import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class OgretmenSayfasi extends JFrame
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frmOgretmen;
    JPanel pnl, pnl_ogretmen;
    JTextField txt_listele, txt_arama;
    JButton btn_soruEkle;
    private JLabel lbl_OgretmenSayfasi;
    private JLabel lbl_kullaniciAdi;
    private JLabel lbl_olarakgirisyaptiniz;
    
    
    
    public OgretmenSayfasi()
    {
        frmOgretmen=new JFrame("Ogretmen");
        frmOgretmen.setTitle("E-TEST");
        frmOgretmen.setBounds(100, 100, 500, 500);
        frmOgretmen.setVisible(true);
        frmOgretmen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ogretmenPaneliOlustur();
        frmOgretmen.getContentPane().add(pnl_ogretmen);
        
        JButton btn_konuEkle = new JButton("Konu Ekle");
        btn_konuEkle.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		KonuEkle se = new KonuEkle();
                se.setVisible(false);

        		
        	}
        });
        
        btn_konuEkle.setBounds(10, 119, 137, 30);
        pnl_ogretmen.add(btn_konuEkle);
        
        lbl_OgretmenSayfasi = new JLabel("\u00D6\u011Fretmen Sayfas\u0131");
        lbl_OgretmenSayfasi.setFont(new Font("Arial", Font.BOLD, 15));
        lbl_OgretmenSayfasi.setBounds(10, 11, 125, 37);
        pnl_ogretmen.add(lbl_OgretmenSayfasi);
        
        lbl_kullaniciAdi = new JLabel(GirisEkrani.ogretmen_isim);
        lbl_kullaniciAdi.setFont(new Font("Arial", Font.BOLD, 11));
        lbl_kullaniciAdi.setBounds(281, 23, 70, 14);
        pnl_ogretmen.add(lbl_kullaniciAdi);
        
        lbl_olarakgirisyaptiniz = new JLabel("olarak giri\u015F yapt\u0131n\u0131z");
        lbl_olarakgirisyaptiniz.setFont(new Font("Arial", Font.PLAIN, 11));
        lbl_olarakgirisyaptiniz.setBounds(350, 23, 124, 14);
        pnl_ogretmen.add(lbl_olarakgirisyaptiniz);

       
    }

    public void ogretmenPaneliOlustur()
    {
        pnl_ogretmen =new JPanel();
        pnl_ogretmen.setBackground(Color.lightGray);
        pnl_ogretmen.setBounds(100, 100, 500, 500);
        pnl_ogretmen.setLayout(null);
        btn_soruEkle    = new JButton("Soru Ekle");
        btn_soruEkle.setBounds(10, 73, 137, 30);
        pnl_ogretmen.add(btn_soruEkle);

        
        
        
        
        btn_soruEkle.addActionListener(new ActionListener()
        {
        	
            public void actionPerformed(ActionEvent event)
            {                
                    SoruEkle se = new SoruEkle();
                    se.setVisible(false);
            }
        }
        );
    }    
}