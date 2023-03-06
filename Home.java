import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Home extends JFrame implements ActionListener {
    Image image;
    ImageIcon icon;
    Toolkit tk=Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    JLabel label = new JLabel("Welcome To Our Digital Learning Application");
    JButton [] btns = new JButton[2];
    JPanel btnPanel = new JPanel(); 
    GridLayout grid = new GridLayout(3,1);
    Image backgnd = tk.getImage("images/School 02.jpg");
        ImageIcon iconback = new ImageIcon(backgnd);
        JLabel background = new JLabel(iconback);
   public Home(){
        setLayout(null);
        grid.setVgap((int)(screenSize.height * 0.1));
        btnPanel.setLayout(grid);
        btnPanel.setOpaque(false);
        label.setBounds((int)(screenSize.width * 0.15),(int)(screenSize.height * 0.01),(int)(screenSize.width * 1),(int)(screenSize.height * 0.2));
        label.setFont(new Font("Monospaced",Font.BOLD,53));
        btnPanel.setBounds((int)(screenSize.width * 0.42),(int)(screenSize.height * 0.25),(int)(screenSize.width * 0.2),(int)(screenSize.width * 0.5));
        for (int i = 0; i < 2; i++) {
            image = tk.getImage("images/home btn/" +String.valueOf(i + 1) +".jpg");
            icon = new ImageIcon(image);
            btns[i] = new JButton("", icon);
            btns[i].setContentAreaFilled(false);
            btns[i].setBorder(BorderFactory.createLineBorder(Color.ORANGE,20,true));
            btnPanel.add(btns[i]);
            btns[i].addActionListener(this); 
        }
        setTitle("Learn Languages");
        setSize(1200,700);
        setResizable(false);
        add(btnPanel);
        add(label);
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
        new Home();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btns[0]) {
            dispose();
            new Amharic_page();
        }else if(e.getSource() == btns[1]){
            dispose();
            new English_Page();
        }
    
}
}
