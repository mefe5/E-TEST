import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class OgrenciSayfasi extends JFrame
{

	private static final long serialVersionUID = 1L;
	JFrame frmOgrenci;
    JPanel pnl, pnl_ogrenci;
    JTextField txt_listele, txt_arama;
    JButton btn_Sinav;
    
    
    
    public OgrenciSayfasi()
    {
        frmOgrenci=new JFrame("ogrenci");
        frmOgrenci.setTitle("E-TEST");
        frmOgrenci.setBounds(100, 100, 500, 500);
        frmOgrenci.setVisible(true);
        frmOgrenci.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ogretmenPaneliOlustur();
        frmOgrenci.getContentPane().add(pnl_ogrenci);
        
        JLabel lbl_OgrenciSayfasi = new JLabel("\u00D6\u011Frenci Sayfasi");
        lbl_OgrenciSayfasi.setFont(new Font("Arial", Font.BOLD, 15));
        lbl_OgrenciSayfasi.setBounds(10, 21, 116, 25);
        pnl_ogrenci.add(lbl_OgrenciSayfasi);
        
        JLabel lbl_olarakgirisyaptiniz = new JLabel("olarak giri\u015F yapt\u0131n\u0131z.");
        lbl_olarakgirisyaptiniz.setBounds(358, 21, 116, 25);
        pnl_ogrenci.add(lbl_olarakgirisyaptiniz);
        
        JLabel lbl_kullaniciAdi = new JLabel(GirisEkrani.ogrenci_isim);
        lbl_kullaniciAdi.setFont(new Font("Tahoma", Font.BOLD, 11));
        lbl_kullaniciAdi.setBounds(302, 21, 46, 25);
        pnl_ogrenci.add(lbl_kullaniciAdi);

       
    }

    public void ogretmenPaneliOlustur()
    {
        pnl_ogrenci =new JPanel();
        pnl_ogrenci.setBackground(Color.lightGray);
        pnl_ogrenci.setBounds(100, 100, 500, 500);
        pnl_ogrenci.setLayout(null);
        btn_Sinav       =new JButton("S\u0131nav");
        btn_Sinav.setBounds(10, 66, 137, 30);
        pnl_ogrenci.add(btn_Sinav);
   
        
        btn_Sinav.addActionListener(new ActionListener()
        {
        	
            public void actionPerformed(ActionEvent event)
            {                
                    SinavOl so = new SinavOl();
                    so.setVisible(true);
            }
        }
        );
    }    
}