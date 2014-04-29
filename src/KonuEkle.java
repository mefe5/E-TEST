import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class KonuEkle extends JFrame
{
	private static final long serialVersionUID = 1L;
	JFrame frmKonu;
    JPanel pnl, pnl_konu_genel;
	public JTextField txt_konuGirisi;
    JLabel lbl_konuAdi, lbl_KonuEklemeEkrani;
    JButton btn_konuCikis, btn_duzenle, btn_yeniKonu;
    public static Connection con = null;
    public static ResultSet rs = null;
    public static Statement st = null;
    static Vector<Vector<String>> data=new Vector<Vector<String>>();
    protected static DefaultTableModel model;
    private static JTable table;
    public int id;
    public String konu_adi,id_col;
	protected int kid;
    
    public KonuEkle()
    {
    	pnl_konu_genel =new JPanel();
        pnl_konu_genel.setBackground(Color.lightGray);
        pnl_konu_genel.setLayout(null);
        
       frmKonu=new JFrame("Konu Ekle");
       frmKonu.addWindowListener(new WindowAdapter() {
	       	@Override
	       	public void windowOpened(WindowEvent arg0) {
	       		
	       		con=Dbconnect.conect();
	       	}
	       });
       frmKonu.setTitle("E-TEST");
       frmKonu.setBounds(100, 100, 500, 500);
       frmKonu.setVisible(true);
       frmKonu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frmKonu.getContentPane().setLayout(new BorderLayout(0, 0));
       frmKonu.getContentPane().add(pnl_konu_genel);
       
       konuPaneli();
       konuTablo();
    }  
    
    public void konuPaneli()
    {
    
       JPanel panel_konu_ekleme = new JPanel();
       panel_konu_ekleme.setBounds(10, 0, 464, 302);
       pnl_konu_genel.add(panel_konu_ekleme);
       panel_konu_ekleme.setLayout(null);
       btn_yeniKonu       =new JButton("Kaydet");
       btn_yeniKonu.setBounds(65, 234, 67, 30);
       panel_konu_ekleme.add(btn_yeniKonu);
       btn_duzenle =new JButton("Güncelle");
       btn_duzenle.setBounds(142, 234, 90, 30);
       panel_konu_ekleme.add(btn_duzenle);
       btn_konuCikis    = new JButton("Çýkýþ");
       btn_konuCikis.setBounds(245, 234, 90, 30);
       panel_konu_ekleme.add(btn_konuCikis);
       txt_konuGirisi   = new JTextField();
       txt_konuGirisi.setBounds(65, 59, 270, 71);
       panel_konu_ekleme.add(txt_konuGirisi);
       

       lbl_konuAdi   = new JLabel("Konu Ad\u0131");
       lbl_konuAdi.setBounds(10, 65, 150, 59);
       panel_konu_ekleme.add(lbl_konuAdi);
       lbl_KonuEklemeEkrani = new JLabel("Konu Ekleme Ekran\u0131");
       lbl_KonuEklemeEkrani.setBounds(10, 11, 300, 20);
       panel_konu_ekleme.add(lbl_KonuEklemeEkrani);
       lbl_KonuEklemeEkrani.setFont(new Font("arial", Font.BOLD, 15));
       
			       btn_yeniKonu.addActionListener(new ActionListener()
			       {
			           public void actionPerformed(ActionEvent e)
			           {
			
			               try
			               {
			            	   
			            	    
			                   st = con.createStatement();
			                   String sorgu="insert into konular "
			                       + "(konuadi)"
			                       + "VALUES ('" +txt_konuGirisi.getText()+ "')";
			                   st.executeUpdate(sorgu); 
			                   JOptionPane.showMessageDialog(KonuEkle.this, "Konu Eklendi");
			
			                   Vector <String> d=new Vector<String>();
			           	    
			           	    d.add(txt_konuGirisi.getText());
			           	    
			           	    d.add("\n\n\n\n\n\n\n");
			           	    data.add(d);
			
			                   model.addRow(new Object[]{txt_konuGirisi.getText()});
			                   table.addNotify();    
			                   
			                   
			                   
			                   
			                   
			                   
			               }
			               catch (Exception s)
			               {
			                   System.out.print(s.getMessage());
			               }
			           }
			       }
			       );
       
		       btn_duzenle.addActionListener(new ActionListener() {
		          	public void actionPerformed(ActionEvent arg0) {
		          		
		          		System.out.println(id);
		          		try{
		          			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/etest", "root", "1234");
		          	        Statement komut = con.createStatement();
		          	        String sorgu = "UPDATE konular SET konuadi= '"
		          	            + txt_konuGirisi.getText() + "' WHERE kid ='"+id+"' ";
		          	        komut.executeUpdate(sorgu);
		          	        System.out.println("Konu güncellendi");

		          			
		          	        
		          	        
		          	        
		          		}
		          		catch(Exception s)
		          		{
		          			System.out.print(s.getMessage());
		          		}
		          		
		          	}
		          });
       
               btn_konuCikis.addActionListener(new ActionListener()
               {
                   public void actionPerformed(ActionEvent e)
                   {                
                       frmKonu.dispose();
                       
                   }
               }
  
               
                );
       

    }  

    
    public void konuTablo(){
    	  
    	 JScrollPane scrollPane = new JScrollPane(table);
          scrollPane.setBounds(10, 313, 464, 103);
          pnl_konu_genel.add(scrollPane);

    	  Vector<String> headers=new Vector<String>();
    	 
    	   headers.add("konu");
    	   
    	   DefaultTableModel model = new DefaultTableModel(data, headers);
    	   
    	   getData();	
    	   
     	  table = new JTable(model);
     	  
		     	 
		     	  
     	 scrollPane.setViewportView(table);
           table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
           
           header_size();
           
           scrollPane.setHorizontalScrollBarPolicy(
    	   JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
           scrollPane.setVerticalScrollBarPolicy(
    	   JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
           pack();
           setResizable(false);
           setVisible(true);	   
	           		 table.addMouseListener(new MouseAdapter() {
	 		     	  	@Override
	 		     	  	public void mouseClicked(MouseEvent e) {
	 		     	  	 String selectedData = null;
	
	 		             int[] selectedRow = table.getSelectedRows();
	 		             int[] selectedColumns = table.getSelectedColumns();
	
	 		             for (int i = 0; i < selectedRow.length; i++) {
	 		               for (int j = 0; j < selectedColumns.length; j++) {
	 		                 selectedData = (String) table.getValueAt(selectedRow[i], selectedColumns[j]);
	 		               }
	 		             }
	 		             System.out.println("Seçilen: " + selectedData);
	 		             txt_konuGirisi.setText(selectedData);
	 		     	  		
	 		             
	 		             
	 		            String str="select * from konular";
	 		     	  Connection con;
	 		     	  ResultSet rs;
	 		     	  Statement st;
	 		             
	 		             
	 		            try 
	 			    	  {
	 			    	   con=DriverManager.getConnection("jdbc:mysql://" + "localhost:3306/etest","root","1234");
	 			    	   st= con.createStatement();
	 			    	   rs=st.executeQuery(str);
	 			    	   
	 			    	   while(rs.next())
	 			    	   {
	 			    	    if(selectedData.equals(rs.getString("konuadi")))
	 			    	    {
	 			    	    	id = rs.getInt("kid");
	 			    	   
	 			    	    	konu_adi = rs.getString("konuadi");
	 			    	    	
	 			    	    }
	 			    	 
	 			    	   }
	 		     	  	}
	 		            catch(SQLException ex) 
	 			    	  {
	 		    		   
	 		    		   ex.printStackTrace();
	 		            	
	 		            }
	 		          

	 		            }
	 		     	  });
			
    	 }
   
    	 
    	public static void header_size() {
    	        TableColumn column = table.getColumnModel().getColumn(0);
    	        column.setPreferredWidth(100);

    	        column = table.getColumnModel().getColumn(0);
    	        column.setPreferredWidth(350);
    	     }
    	 

    	 private static void getData()
    	 {
    	  // Enter Your MySQL Database Table name in below Select Query.
    	  String str="select * from konular";
    	  Connection con;
    	  ResultSet rs;
    	  Statement st;
    	  
	    	  try 
	    	  {
	    	   con=DriverManager.getConnection("jdbc:mysql://" + "localhost:3306/etest","root","1234");
	    	   st= con.createStatement();
	    	   rs=st.executeQuery(str);
	    	   
	    	   while(rs.next())
	    	   {
	    	    Vector <String> d=new Vector<String>();
	    	  
	    	    d.add(rs.getString("konuadi"));
	    	    
	    	    d.add("\n\n\n\n\n\n\n");
	    	    data.add(d);
	    	 
	    	   }
	    	  }
	    	  catch (SQLException e) 
	    	  {
	    		   
	    		   e.printStackTrace();
	    	  }
    	 }
    	 

}