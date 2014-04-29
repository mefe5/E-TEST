package deneme;

import java.awt.BorderLayout;

import java.awt.Component;

import java.awt.Container;

import java.awt.event.ItemEvent;

import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.JRadioButton;

import javax.swing.WindowConstants;

public class JradioButtonExample extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JRadioButton s, m, l;

    private JButton jbutton;

    public JradioButtonExample(String str) {

  super(str);

  this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

  Container cPane = this.getContentPane();

  ButtonGroup buttonGroup = new ButtonGroup();

  s = new JRadioButton("Small");

  m = new JRadioButton("Medium");

  l = new JRadioButton("Large");

  buttonGroup.add(s);

  buttonGroup.add(m);

  buttonGroup.add(l);

  jbutton = new JButton("Click me!");

  jbutton.setBounds(100, 100, 100, 100);

  JPanel jPaneCent = new JPanel();

  jPaneCent.setLayout(null);

  jPaneCent.add(jbutton);

  cPane.add(jPaneCent, BorderLayout.CENTER);

  JPanel jPanelNor = new JPanel();

  jPanelNor.add(s);

  jPanelNor.add(m);

  jPanelNor.add(l);

  cPane.add(jPanelNor, BorderLayout.NORTH);

  ChangeSize chsize = new ChangeSize(jbutton);

  s.addItemListener(chsize);

  m.addItemListener(chsize);

  l.addItemListener(chsize);

    }

    public static void main(String[] args) {

  JFrame jFrame = new JradioButtonExample("JRadioButton example");

  jFrame.setSize(300, 200);

  jFrame.setVisible(true);

    }

}

class ChangeSize implements ItemListener {

    private Component component;

    public ChangeSize(Component comp) {

  component = comp;

    }

    @Override

    public void itemStateChanged(ItemEvent event) {

  String s = (String) event.getItem();

  if (s.equals("Small")) {

component.setSize(60, 10);

  } else if (s.equals("Medium")) {

component.setSize(90, 70);

  } else if (s.equals("Large")) {

component.setSize(260,105);

  }

    }

}