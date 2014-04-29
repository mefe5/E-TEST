package deneme;

import java.awt.*;
import java.awt.event.*;
class RadioButtonItemEvent extends Frame implements ItemListener
{
Checkbox r1,r2;
CheckboxGroup cg;

    public RadioButtonItemEvent()
    {
        createAndShowGUI();
    }
    
    private void createAndShowGUI()
    {
        // Set frame properties
        setTitle("Checkbox with ItemListener demo");
        setLayout(new FlowLayout());
        
        // Create simple Checkboxes
        r1=new Checkbox("Male");
        r2=new Checkbox("Female");
        
        // Add ItemListeners for r1,r2
        r1.addItemListener(this);
        r2.addItemListener(this);
        
        // Create CheckboxGroup
        cg=new CheckboxGroup();
    
        // Add r1,r2 to CheckboxGroup
        r1.setCheckboxGroup(cg);
        r2.setCheckboxGroup(cg);
        
        // Add radio buttons
        add(r1);
        add(r2);
        
        setSize(400,400);
        setVisible(true);
    }
    
    public void itemStateChanged(ItemEvent ie)
    {
        setTitle(ie.getItem()+" is selected.");
    }
    
    public static void main(String args[])
    {
        new RadioButtonItemEvent();
    }
}
