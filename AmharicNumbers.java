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
        setLayout(null);
        numBtnPanel.setLayout(numBtnGrid);
        numBtnPanel.setBounds((int)(screenSize.width * 0.05),(int)(screenSize.height * 0.05),(int)(screenSize.width * 0.9),(int)(screenSize.height * 0.8));
        
        for (int i = 0; i < numButtons.length; i++) {
            image = tk.getImage("images/Amharic Numbers/" +String.valueOf(i + 1) +".png");
            icon = new ImageIcon(image);
            numButtons[i] = new JButton("", icon);
            numButtons[i].addActionListener(this);
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
