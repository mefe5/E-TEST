package deneme;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

public class GetSelectedValueFromJList extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private JList list;

    private JButton button;

    public GetSelectedValueFromJList() {

        // set flow layout for the frame

        this.getContentPane().setLayout(new FlowLayout());

        Object[] data = { "Value 1", "Value 2", "Value 3", "Value 4", "Value 5" };

        list = new JList(data);

        button = new JButton("Check");

        button.addActionListener(this);


        // add list to frame31
        add(list);

        add(button);

 

    }

 

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Check")) {

            int index = list.getSelectedIndex();

            System.out.println("Index Selected: " + index);

            String s = (String) list.getSelectedValue();

            System.out.println("Value Selected: " + s);

        }

    }

    private static void createAndShowGUI() {

  JFrame frame = new GetSelectedValueFromJList();

  frame.pack();

  frame.setVisible(true);

  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {


  javax.swing.SwingUtilities.invokeLater(new Runnable() {

public void run() {

    createAndShowGUI();

}

  });

    }

}


/*
pnl.add(pnl_ogrenci);
{
	this.getContentPane().setLayout(new FlowLayout());
	
	 Class.forName("com.mysql.jdbc.Driver").newInstance();
     System.out.print("sürücü yüklendi");
     Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/etest", "root", "");
     Statement komut = conn.createStatement();
     ResultSet rs = komut.executeQuery("select sifre from ogretmengirisbilgileri");
     
     while (rs.next()) {
    	 Object[] data = {rs};
    	 list = new JList(data);
     	list.setBounds(10, 32, 90, 130);
        }
         }
	
*/

/*      try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.print("sürücü yüklendi");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/etest", "root", "");
            Statement komut = conn.createStatement();
            ResultSet rs = komut.executeQuery("select dogrusik from sorular");    //bilgileri çek
            
            while (rs.next()) {
           	 Object[] data = { rs };
            	list = new JList(data);
            	list.setBounds(10, 32, 90, 130);
                }
            conn.close();
        }
        catch (Exception s)
        {
            System.out.print(s.getMessage());
        }*/









