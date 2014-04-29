import java.awt.*;
import java.sql.*;
import java.awt.event.*;

import javax.swing.*;

public class GirisEkrani extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	JFrame frmEtest;
    JPanel pnl, pnl_ogretmen, pnl_ogrenci;
    JButton btn_ogretmenGirisi, btn_ogrenciGirisi;
    JPasswordField txt_ogretmenSifre;
    JTextField txt_ogretmenKullaniciAdi;
    JLabel lbl_ogretmenKullaniciAdi, lbl_ogretmenSifre, lbl_panelAdi, lbl_ogrenciPaneliAdi, lbl_ogretmenPaneliAdi;
    Connection conn = null;
    Connection conn2 = null;
    ResultSet rs = null;
    ResultSet rs2 = null;
    Statement komut = null;
    Statement komut2 = null;
    public static String ogretmen_isim, ogrenci_isim;
    public static int ogrenci_id;
    public JTextField txt_ogrenciKullaniciAdi;
    private JPasswordField txt_ogrenciSifre;
    
    
    
    public GirisEkrani() {
        frmEtest = new JFrame("Teknik Servis");
        
        frmEtest.addWindowListener(new WindowAdapter() {
        	@Override
        	public void windowOpened(WindowEvent arg0) {
        	conn = Dbconnect.conect();
        	}
        });
        frmEtest.setTitle("E-TEST");
        frmEtest.setBounds(100, 100, 566, 302);
        frmEtest.setVisible(true);
        frmEtest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelOlustur();
        ogretmenPaneliOlustur();
        ogrenciPaneliOlustur();
        frmEtest.getContentPane().add(pnl);

    }

    public void panelOlustur() {
        pnl = new JPanel();
        pnl.setLayout(null);
        lbl_panelAdi = new JLabel("Giriþ Ekraný");
        lbl_panelAdi.setBounds(10, 2, 100, 20);
        lbl_panelAdi.setFont(new Font("arial", Font.BOLD, 15));
        pnl.add(lbl_panelAdi);
    }

    public void ogretmenPaneliOlustur() {
        pnl_ogretmen = new JPanel();
        pnl_ogretmen.setBackground(Color.lightGray);
        pnl_ogretmen.setBounds(10, 25, 250, 200);
        pnl_ogretmen.setLayout(null);
        //pnl_yetkili.setPreferredSize(new Dimension(230,200));

        lbl_ogretmenKullaniciAdi = new JLabel("Kullanici Adi:");
        lbl_ogretmenKullaniciAdi.setBounds(10, 50, 118, 20);
        txt_ogretmenKullaniciAdi = new JTextField("", 8);
        txt_ogretmenKullaniciAdi.setBounds(130, 50, 100, 20);
        lbl_ogretmenSifre = new JLabel("Þifre: ");
        lbl_ogretmenSifre.setBounds(10, 75, 118, 20);
        txt_ogretmenSifre = new JPasswordField("", 8);
        txt_ogretmenSifre.setBounds(130, 75, 100, 20);
        btn_ogretmenGirisi = new JButton("Giriþ");
        btn_ogretmenGirisi.setBounds(170, 100, 60, 30);
        lbl_ogretmenPaneliAdi = new JLabel("Öðretmen Giriþi");
        lbl_ogretmenPaneliAdi.setFont(new Font("sherif", Font.BOLD, 13));
        lbl_ogretmenPaneliAdi.setBounds(10, 2, 100, 20);

        pnl_ogretmen.add(lbl_ogretmenPaneliAdi);
        pnl_ogretmen.add(lbl_ogretmenKullaniciAdi);
        pnl_ogretmen.add(txt_ogretmenKullaniciAdi);
        pnl_ogretmen.add(lbl_ogretmenSifre);
        pnl_ogretmen.add(txt_ogretmenSifre);
        pnl_ogretmen.add(btn_ogretmenGirisi);
        pnl.add(pnl_ogretmen);

        btn_ogretmenGirisi.addActionListener(
                new ActionListener() {
                    @SuppressWarnings("deprecation")
					public void actionPerformed(ActionEvent event) 
                    {
                        try
                        {
                            komut = conn.createStatement();
                            rs = komut.executeQuery("select * from ogretmengirisbilgileri");
		                            while (rs.next()) {
		                                if(txt_ogretmenKullaniciAdi.getText().equals(rs.getString("ogretmenkullaniciadi")) && txt_ogretmenSifre.getText().equals(rs.getString("ogretmensifre")))
		                                {
		                                	
		                                		ogretmen_isim = txt_ogretmenKullaniciAdi.getText();
		                                        OgretmenSayfasi frame = new OgretmenSayfasi();
		                                        frame.setVisible(false);
		                                }
//		                                    else
//		                                    {
//		                                        JOptionPane.showMessageDialog(null, "Yanlýs kullanýcý adý veya þifre, Bilgilerinizi kontrol ederek tekrar deneyiniz");
//		                                    }
		                                }
  

                        }
                        catch (Exception s)
                        {
                            System.out.print(s.getMessage());
                        }
                    }
                });

        
        
        
    }

    public void ogrenciPaneliOlustur()
    {

        pnl_ogrenci = new JPanel();
        pnl_ogrenci.setBackground(Color.lightGray);
        pnl_ogrenci.setBounds(270, 25, 250, 200);
        pnl_ogrenci.setLayout(null);

        btn_ogrenciGirisi = new JButton("Giriþ");
        btn_ogrenciGirisi.setBounds(110, 121, 80, 40);
        lbl_ogrenciPaneliAdi = new JLabel("Öðrenci Giriþi");
        lbl_ogrenciPaneliAdi.setFont(new Font("sherif", Font.BOLD, 13));
        lbl_ogrenciPaneliAdi.setBounds(10, 2, 100, 20);

        pnl_ogrenci.add(btn_ogrenciGirisi);
        pnl_ogrenci.add(lbl_ogrenciPaneliAdi);
        pnl.add(pnl_ogrenci);
        
        txt_ogrenciKullaniciAdi = new JTextField();
        txt_ogrenciKullaniciAdi.setBounds(104, 49, 98, 20);
        pnl_ogrenci.add(txt_ogrenciKullaniciAdi);
        txt_ogrenciKullaniciAdi.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
        lblNewLabel.setBounds(10, 52, 86, 14);
        pnl_ogrenci.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("\u015Eifre");
        lblNewLabel_1.setBounds(10, 77, 84, 14);
        pnl_ogrenci.add(lblNewLabel_1);
        
        txt_ogrenciSifre = new JPasswordField("", 8);
        txt_ogrenciSifre.setBounds(102, 80, 100, 20);
        pnl_ogrenci.add(txt_ogrenciSifre);
        
        
        btn_ogrenciGirisi.addActionListener(
                new ActionListener()
        {
            @SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent event)
            {                
            	try
                {
                    komut2 = conn.createStatement();
                    rs2 = komut2.executeQuery("select * from ogrencigirisbilgileri");
                            while (rs2.next()) {
                                if(txt_ogrenciKullaniciAdi.getText().equals(rs2.getString("ogrencikullaniciadi")) && txt_ogrenciSifre.getText().equals(rs2.getString("ogrencisifre")))
                                {
                                	
                                		ogrenci_isim = txt_ogrenciKullaniciAdi.getText();
                                		ogrenci_id = rs2.getInt("ogrenci_id");
                                        OgrenciSayfasi frame = new OgrenciSayfasi();
                                        frame.setVisible(false);
                                }
                                }


                }
                catch (Exception s)
                {
                    System.out.print(s.getMessage());
                } 
            }
        });


    }
}