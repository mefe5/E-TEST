package deneme;

import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  
  
public class Quiz implements ActionListener {  
      
    int score = 0;   
    JButton button;  
    JLabel result = new JLabel("Click button for result");
    public JRadioButton Q1A4;
          
    public static void main (String[] args) {  
        Quiz maths = new Quiz();  
        maths.go();  
    }  
          
    public void go() {    
        JFrame frame = new JFrame("The Quiz");  
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);  
        frame.setSize(300, 300);  
        frame.setVisible(true);  
          
        JPanel Q1 = new JPanel();  
        Q1.setLayout(new BoxLayout(Q1, BoxLayout.Y_AXIS));  
        JLabel Q1L = new JLabel("What is 4 x 5?");  
        JRadioButton Q1A1 = new JRadioButton("5");  
        JRadioButton Q1A2 = new JRadioButton("10");  
        JRadioButton Q1A3 = new JRadioButton("15");  
        JRadioButton Q1A4 = new JRadioButton("20");  
        ButtonGroup Q1G = new ButtonGroup();   
        Q1G.add(Q1A1);  
        Q1G.add(Q1A2);  
        Q1G.add(Q1A3);  
        Q1G.add(Q1A4);  
        button = new JButton("Next");  
        JLabel spacing = new JLabel("---");  
          
                  
        Q1.add(Q1L);  
        Q1.add(Q1A1);  
        Q1.add(Q1A2);  
        Q1.add(Q1A3);  
        Q1.add(Q1A4);  
        Q1.add(button);  
        Q1.add(spacing);  
        Q1.add(result);  
          
        button.addActionListener(this);   
          
        frame.getContentPane().add(BorderLayout.CENTER, Q1);  
    }  
          
        public void actionPerformed(ActionEvent event) {  
            if (Q1A4.isSelected()) {  
                score = score + 1;  
                result.setText("Correct Answer!");   
            } else {  
                result.setText("No that's not right :/");  
            }  
            }  
                  
            }  
