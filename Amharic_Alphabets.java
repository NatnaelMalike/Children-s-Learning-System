import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Amharic_Alphabets extends JFrame implements ActionListener {
  
  JButton[] amhButtons= new JButton[34];
  JButton[] childButtons = new JButton[7];
  JPanel amhPanel = new JPanel();
  JPanel childPanel = new JPanel();
  JPanel cPanel = new JPanel();
  GridLayout amhGrid = new GridLayout(3,11);
  GridLayout childGrid = new GridLayout(1,7);
  HashMap <Object, String> amharicAlphabetsMap = new HashMap<>();
  String [] fir_amh = {"ሀ","ለ","ሐ","መ","ሠ","ረ","ሰ","ሸ","ቀ","በ","ቨ","ተ","ቸ","ኀ","ነ","ኘ",
              "አ","ከ","ኸ","ወ","ዐ","ዘ","ዠ","የ","ደ","ጀ","ገ","ጠ","ጨ","ጰ","ጸ","ፀ","ፈ","ፐ"};
  String [] ha_child = {"ሀ","ሁ","ሂ","ሃ","ሄ","ህ","ሆ"};
  String [] le_child = {"ለ","ሉ","ሊ","ላ","ሌ","ል","ሎ"};
  String audioName;						


  public Amharic_Alphabets(){
    Font font;
    try {
      font = Font.createFont(Font.TRUETYPE_FONT, new File("Font/AbyssinicaSIL-R.ttf"));
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    ge.registerFont(font);
    } catch (FontFormatException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    amhPanel.setLayout(amhGrid);
    amhPanel.setBounds(400,450,1000,300);
    childPanel.setLayout(childGrid);
    childPanel.setBounds(550,250,600,100);
    cPanel.setLayout(childGrid);
    childPanel.setBounds(550,250,600,100);
    
    add(amhPanel);
    add(childPanel);
   setLayout(null);
   setSize(1800,1000);
   
   for (int i = 0; i < amhButtons.length; i++) {
    amhButtons[i] = new JButton(fir_amh[i]);
    amhButtons[i].addActionListener(this);
    amhButtons[i].setFont(new Font("Abyssinica SIL",Font.PLAIN,43));
    amhPanel.add(amhButtons[i]);
    amharicAlphabetsMap.put(amhButtons[i],"Amharic Alphabets/"+ String.valueOf(i + 1) + ".wav");
   }
   for (int i = 0; i < 7; i++) {
    childButtons[i] = new JButton();
    childPanel.add(childButtons[i]);
    childButtons[i].setBorderPainted(false);
    childButtons[i].setContentAreaFilled(false);
    childButtons[i].setFont(new Font("Abyssinica SIL",Font.PLAIN,53));
   }
   setVisible(true);
  }
  public static void main(String[] args) {
    new Amharic_Alphabets();
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    for (Object key : amharicAlphabetsMap.keySet()) {
      if (e.getSource() == key) {
        audioName = amharicAlphabetsMap.get(key);
      }
    }
    new AudioPlayer(audioName);

    for (int i = 0; i < 7; i++) {
      childButtons[i].setBorderPainted(true);
      childButtons[i].setContentAreaFilled(true);
    }
   
   if(e.getSource() == amhButtons[0]){
      for (int i = 0; i < 7; i++) {
        childButtons[i].setText(ha_child[i]);
      }
   }else if(e.getSource() == amhButtons[1]){
    
    for (int i = 0; i < 7; i++) {
      childButtons[i].setText(le_child[i]);
     
    }
   }
    
  }
}
