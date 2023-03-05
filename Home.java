import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Home extends JFrame implements ActionListener {
    Image image;
    ImageIcon icon;
    Toolkit tk=Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
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
        btnPanel.setBounds((int)(screenSize.width * 0.42),(int)(screenSize.height * 0.25),(int)(screenSize.width * 0.2),(int)(screenSize.height * 0.8));
        for (int i = 0; i < 2; i++) {
            image = tk.getImage("images/English page Btns/" +String.valueOf(i + 1) +".jpg");
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
