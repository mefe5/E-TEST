package deneme;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class JRadioButtonItemListener {
  public static void main(String args[]) {
    JFrame frame = new JFrame("Grouping Example");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel(new GridLayout(0, 1));

    ButtonGroup group = new ButtonGroup();
    JRadioButton aRadioButton = new JRadioButton("A");
    JRadioButton bRadioButton = new JRadioButton("B");

    
    
    ItemListener itemListener = new ItemListener() {
      String lastSelected;
      public void itemStateChanged(ItemEvent itemEvent) {
        AbstractButton aButton = (AbstractButton)itemEvent.getSource();
        int state = itemEvent.getStateChange();
        String label = aButton.getText();
        String msgStart;
        if (state == ItemEvent.SELECTED) {
          if (label.equals(lastSelected)) {
            msgStart = "Reselected -> ";
          }  else {
           msgStart = "Selected -> ";
          }
          lastSelected = label;
        }  else {
          msgStart = "Deselected -> ";
        }
        System.out.println(msgStart + label);
      }
    };

    
    
    
    
    panel.add(aRadioButton);
    group.add(aRadioButton);
    panel.add(bRadioButton);
    group.add(bRadioButton);

    aRadioButton.addItemListener(itemListener);
    bRadioButton.addItemListener(itemListener);

    frame.add(panel);
    frame.setSize(300, 200);
    frame.setVisible(true);
  }
  
}