import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Amharic_page extends JFrame {
    private JFrame english_page;
    private JButton Aphabets;
    private JButton Color;
    private JButton Number;
    private JButton Back;
    private  JLabel background;

    Amharic_page(){
        english_page = new JFrame();
        setTitle("Learn Alphabets,Colors,Numbers In Amharic");
        setSize(1200,700);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Aphabets= new JButton("Alphabet");
        Aphabets.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        Aphabets.setBackground(new Color(36, 126, 40));
        Aphabets.setBounds(540,200,130,60);
        Aphabets.setForeground(new Color(239, 215, 78,244));
        Aphabets.setFocusable(false);

        Color= new JButton("Color");
        Color.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        Color.setBackground(new Color(36, 126, 40));
        Color.setBounds(540,300,130,60);
        Color.setForeground(new Color(239, 215, 78,244));
        Color.setFocusable(false);

        Number= new JButton("Numbers");
        Number.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        Number.setBackground(new Color(31, 117, 39));
        Number.setBounds(540,400,130,60);
        Number.setForeground(new Color(239, 215, 78,244));
        Number.setFocusable(false);

        Back = new JButton("Back");
        Back.setFont(new Font("Sans Serif",Font.PLAIN,20));
        Back.setBackground( new Color(186, 31, 220));
        Back.setBounds(540,500,130,60);
       
        Back.setFocusable(false);
        Back.setForeground(new Color(255, 255, 255));

        ImageIcon image = new ImageIcon("images/ee.jpg");
        background = new JLabel("",image,JLabel.CENTER);
        background.setBounds(0,0,1200,700);

        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                english_page.setVisible(false);
                try {
                    new Home().setVisible(true);
                } catch (FontFormatException | IOException e1) {
                    
                    e1.printStackTrace();
                }
            }
        });


        add(Aphabets);
        add(Color);
        add(Number);
        add(Back);
        add(background);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Amharic_page();
    }

}
