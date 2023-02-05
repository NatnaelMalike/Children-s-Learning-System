import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class English_page extends JFrame {
    private JFrame english_page;
    private JButton Aphabets;
    private JButton Color;
    private JButton Number;
    private JButton Back;
    private  JLabel background,small_images,small_images2;

    English_page(){
        english_page = new JFrame();
        setTitle("Learn Alphabets,Colors,Numbers In English");
        setSize(1200,700);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Aphabets= new JButton("Alphabet");
        Aphabets.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        Aphabets.setBackground(new Color(206, 53, 53));
        Aphabets.setBounds(540,200,130,60);
        Aphabets.setFocusable(false);

        Color= new JButton("Color");
        Color.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        Color.setBackground(new Color(206, 53, 53));
        Color.setBounds(540,300,130,60);
        Color.setFocusable(false);

        Number= new JButton("Numbers");
        Number.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        Number.setBackground(new Color(206, 53, 53));
        Number.setBounds(540,400,130,60);
        Number.setFocusable(false);

        Back = new JButton("Back");
        Back.setFont(new Font("Sans Serif",Font.PLAIN,20));
        Back.setBackground( new Color(145, 70, 18));
        Back.setBounds(540,500,130,60);
        
        Back.setFocusable(false);
        Back.setForeground(new Color(255, 255, 255));

        ImageIcon image = new ImageIcon("images/eng.jpg");
        background = new JLabel("",image,JLabel.CENTER);
        background.setBounds(0,0,1200,700);

        ImageIcon small = new ImageIcon(("images/backgr3.jpg"));
        small_images = new JLabel("",small,JLabel.LEFT);
        small_images.setBounds(153,56,200,200);

        ImageIcon small_2 = new ImageIcon(("images/image4.jpg"));
        small_images2 = new JLabel("",small_2,JLabel.LEFT);
        small_images2.setBounds(850,556,200,100);


        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               english_page.setVisible(false);
               try {
                new Home().setVisible(true);
            } catch (FontFormatException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            }
        });
        Aphabets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                english_page.dispose();
                new Alphabets();
            }
        });


        add(Aphabets);
        add(Color);
        add(Number);
        add(Back);
        add(small_images);
        add(small_images2);
        add(background);
        setVisible(true);
    }


    public static void main(String[] args) {
        new English_page();
    }

}
