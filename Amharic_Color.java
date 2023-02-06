import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
public class Amharic_Color extends JFrame implements ActionListener {
    Toolkit tk=Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    JButton [] colorButtons = new JButton[21];
    JPanel colorBtnPanel = new JPanel();
    GridLayout colorBtnGrid = new GridLayout(3,10);
    Image image;
    ImageIcon icon;
    HashMap <Object, String> colorsAudio = new HashMap<>();
    String audioName;
    String [] colorNames ={"አረንጓዴ","ቢጫ","ብርቱካንማ","ቡኒ","ግራጫ","ሐምራዊ"," ነጭ","ቀይ","ሰማያዊ","ጥቁር","ወይነጠጅ",""}

    public Amharic_Color(){
        setLayout(null);
        colorBtnPanel.setLayout(colorBtnGrid);
        colorBtnPanel.setBounds((int)(screenSize.width * 0.05),(int)(screenSize.height * 0.05),(int)(screenSize.width * 0.9),(int)(screenSize.height * 0.8));
        
        for (int i = 0; i < colorButtons.length; i++) {
            image = tk.getImage("images/Amharic Numbers/" +String.valueOf(i + 1) +".png");
            icon = new ImageIcon(image);
            colorButtons[i] = new JButton("", icon);
            colorButtons[i].addActionListener(this);
            colorBtnPanel.add(colorButtons[i]);
            colorsAudio.put(colorButtons[i],"Amharic Numbers/"+String.valueOf(i + 1)+".wav");
        }
        add(colorBtnPanel);
        setSize(screenSize.width,screenSize.height);
        setVisible(true);
    }
    public static void main(String[] args) {
       new AmharicNumbers(); 
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for (Object key : colorsAudio.keySet()) {
            if (e.getSource() == key) {
              audioName = colorsAudio.get(key);
              new AudioPlayer(audioName);
            }
          }
        
    }
}
