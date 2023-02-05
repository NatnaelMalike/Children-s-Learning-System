
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.awt.event.*;

public class Home extends JFrame  {
    private JButton amharic_button;
    private JButton english_button;
    private JButton Back;
    private JButton Quiz;
    private JLabel Top, Bottom;

    JFrame home = new JFrame();

    public Home() throws FontFormatException, IOException{
        JLabel baackJLabel;
        setSize(1200,700);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon image = new ImageIcon("images/f.eps");
        baackJLabel = new JLabel("",image,JLabel.CENTER);
        baackJLabel.setBounds(0,0,1200,700);

        Font font = Font.createFont(Font.TRUETYPE_FONT, new File("Font/AbyssinicaSIL-R.ttf"));
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        amharic_button = new JButton(" ለአማርኛ ");
        amharic_button.setFont(new Font("Abyssinica SIL",Font.PLAIN,23));
        amharic_button.setBackground(Color.yellow.brighter());
        amharic_button.setBounds(340,200,130,60);
        amharic_button.setFocusable(false);
        amharic_button.setForeground(Color.darkGray);


        english_button = new JButton("English");
        english_button.setFont(new Font("Sans Serif",Font.PLAIN,20));
        english_button.setBackground(Color.yellow.brighter());
        english_button.setBounds(740,200,130,60);
        english_button.setFocusable(false);
        

        Back = new JButton("Exit");
        Back.setFont(new Font("Sans Serif",Font.PLAIN,20));
        Back.setBackground( new Color(34, 103, 37));
        Back.setBounds(740,400,130,60);
       Back.setFocusable(false);
        Back.setForeground(Color.WHITE);

        Quiz = new JButton("Quiz");
        Quiz.setFont(new Font("Sans Serif",Font.PLAIN,20));
        Quiz.setBackground(Color.yellow.brighter());
        Quiz.setBounds(340,400,130,60);
        Quiz.setFocusable(false);
        


        Top = new JLabel();
        Top.setText("Ethio-Lijoch Digital Learning System");
        Top.setBounds(250,50,900,100);
        Top.setFont(new Font("Sans Serif", Font.BOLD, 45));
        Top.setForeground(new Color(255, 255, 255, 244));

        amharic_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                home.dispose();
                new Amharic_page();
            }
        });

        english_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                home.dispose();
                new English_page();
            }
        });

        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        Quiz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                home.dispose();
                new Quiz();
            }
        });


      add(Top);
      add(baackJLabel);
      add(amharic_button);
      add(english_button);
      add(Quiz);
      add(Back);
      setVisible(true);
}

public static void main(String[] args) throws FontFormatException, IOException {
    new Home();
}
}