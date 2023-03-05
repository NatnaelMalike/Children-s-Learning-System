import javax.swing.*;



import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
public class AmharicNumbers extends JFrame implements ActionListener {
    Toolkit tk=Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    JButton [] numButtons = new JButton[21];
    JPanel numBtnPanel = new JPanel();
    GridLayout numBtnGrid = new GridLayout(3,10);
    Image image;
    ImageIcon icon;
    HashMap <Object, String> numbersAudio = new HashMap<>();
    String audioName;

    public AmharicNumbers(){
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent e){
            dispose();
            new Amharic_page();
          }
        });
        setLayout(null);
        numBtnGrid.setVgap((int)(screenSize.height * 0.01));
        numBtnGrid.setHgap((int)(screenSize.height * 0.01));
        numBtnPanel.setLayout(numBtnGrid);
        numBtnPanel.setBounds((int)(screenSize.width * 0.05),(int)(screenSize.height * 0.05),(int)(screenSize.width * 0.9),(int)(screenSize.height * 0.8));
        
        for (int i = 0; i < numButtons.length; i++) {
            image = tk.getImage("images/Amharic Numbers/" +String.valueOf(i + 1) +".png");
            icon = new ImageIcon(image);
            numButtons[i] = new JButton("", icon);
            numButtons[i].addActionListener(this);
            numButtons[i].setFocusable(false);
            numButtons[i].setOpaque(false);
            numButtons[i].setContentAreaFilled(false);
            numBtnPanel.add(numButtons[i]);
            numbersAudio.put(numButtons[i],"Amharic Numbers/"+String.valueOf(i + 1)+".wav");
        }
        add(numBtnPanel);
        setSize(screenSize.width,screenSize.height);
        setVisible(true);
    }
    public static void main(String[] args) {
       new AmharicNumbers(); 
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for (Object key : numbersAudio.keySet()) {
            if (e.getSource() == key) {
              audioName = numbersAudio.get(key);
              new AudioPlayer(audioName);
            }
          }
    }
}
