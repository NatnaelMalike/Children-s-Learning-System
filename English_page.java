import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class English_Page extends JFrame implements ActionListener {
    Image image;
    ImageIcon icon;
    Toolkit tk=Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    JButton [] btns = new JButton[4];
    String []btnName = {"Alphabet","Colors","Numbers","Back"};
    JPanel btnPanel = new JPanel(); 
    GridLayout grid = new GridLayout(2,2);
    Image backgnd = tk.getImage("images/pages.jpg");
        ImageIcon iconback = new ImageIcon(backgnd);
        JLabel background = new JLabel(iconback);
    English_Page(){
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent e){
            dispose();
            new Home();
          }
        });
        setLayout(null);
        grid.setHgap((int)(screenSize.height * 0.1));
        grid.setVgap((int)(screenSize.height * 0.1));
        btnPanel.setLayout(grid);
        btnPanel.setOpaque(false);
        btnPanel.setBounds((int)(screenSize.width * 0.3),(int)(screenSize.height * 0.15),(int)(screenSize.width * 0.4),(int)(screenSize.height * 0.6));
        for (int i = 0; i < btnName.length; i++) {
            image = tk.getImage("images/English page Btns/" +String.valueOf(i + 1) +".jpg");
            icon = new ImageIcon(image);
            btns[i] = new JButton("", icon);
            btns[i].setContentAreaFilled(false);
            btns[i].setFont(new Font(Font.SANS_SERIF,Font.BOLD,(int)(screenSize.width * 0.03)));
            btns[i].setBorder(BorderFactory.createLineBorder(Color.ORANGE,20,true));
            btnPanel.add(btns[i]);
            btns[i].addActionListener(this); 
        }
        setTitle("Learn English Language");
        setSize(1200,700);
        setResizable(false);
        add(btnPanel);
        setSize(screenSize.width,screenSize.width);
        setVisible(true);
        background.setBounds(0,0,screenSize.width,screenSize.height);
        add(background);
        try {
            setUndecorated(true);
          } catch (Exception e) {
            
          }
    }
    public static void main(String[] args) {
        new English_Page();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btns[0]) {
            dispose();
            new EnglishAlphabets();
        }else if(e.getSource() == btns[1]){
            dispose();
            new English_Color();
        }else if(e.getSource() == btns[2]){
            dispose();
            new EnglishNumber();
        }
        else if(e.getSource() == btns[3]){
            dispose();
            new QuizEnglish();
        }
        
    }

}
