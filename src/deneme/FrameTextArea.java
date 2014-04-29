package deneme;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
 
public class FrameTextArea extends JFrame {
 

	private static final long serialVersionUID = 1L;
	private StyleContext context = new StyleContext();
    private StyledDocument document = new DefaultStyledDocument(context);
    private javax.swing.text.Style style = context.getStyle(StyleContext.DEFAULT_STYLE);
    private final JTextPane textArea = new JTextPane(document);
    private final JScrollPane TextAreaScroll = new JScrollPane(textArea, 
 
JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    private JButton jButton = new JButton("Clear");
 
    public FrameTextArea() {
 
        setSize(400, 200);
        setTitle("Text Pane");
        StyleConstants.setAlignment(style, StyleConstants.ALIGN_LEFT);
        StyleConstants.setFontSize(style, 10);
        StyleConstants.setSpaceAbove(style, 1);
        StyleConstants.setSpaceBelow(style, 1);
        setLayout(new FlowLayout());
        jButton.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
                try {
                    document.remove(0, document.getLength());
                } catch (BadLocationException ex) {
                    Logger.getLogger(FrameTextArea.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
 
 
        add(jButton);
        add(TextAreaScroll);
        StyleConstants.setForeground(style, Color.red);
        try {
            StyleConstants.setForeground(style, Color.red);
            document.insertString(document.getLength(), "\n" + new Date() + ": " + "Red Text", style);
            StyleConstants.setForeground(style, Color.PINK);
            document.insertString(document.getLength(), "\n" + new Date() + ": " + "PINK Text", style);
 
            StyleConstants.setForeground(style, Color.black);
            document.insertString(document.getLength(), "\n" + "<a href=\"codemiles.com\" >L</a>", style);
        } catch (BadLocationException ex) {
            Logger.getLogger(FrameTextArea.class.getName()).log(Level.SEVERE, null, ex);
        }
 
 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
 
    public static void main(String[] args) {
       FrameTextArea frameTextArea= new FrameTextArea();
       frameTextArea.setVisible(false);
    }
}