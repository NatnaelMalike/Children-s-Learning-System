import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Amharic_Alphabets extends JFrame implements ActionListener {
  
  JButton[] amhButtons= new JButton[34];
  JButton[] childButtons = new JButton[7];  JPanel amhPanel = new JPanel();
  JPanel childPanel = new JPanel();
  JPanel cPanel = new JPanel();
  GridLayout amhGrid = new GridLayout(3,11);
  GridLayout childGrid = new GridLayout(1,7);
  HashMap <Object, String> amharicAlphabetsMap = new HashMap<>();
  HashMap <Object, Integer> amharicChildAlphabetsMap = new HashMap<>();
  HashMap <Object, String> childAudio = new HashMap<>();
  String [] fir_amh = {"ሀ","ለ","ሐ","መ","ሠ","ረ","ሰ","ሸ","ቀ","በ","ቨ","ተ","ቸ","ኀ","ነ","ኘ",
              "አ","ከ","ኸ","ወ","ዐ","ዘ","ዠ","የ","ደ","ጀ","ገ","ጠ","ጨ","ጰ","ጸ","ፀ","ፈ","ፐ"};
  String [][] all_Childs = {{"ሀ","ሁ","ሂ","ሃ","ሄ","ህ","ሆ"},{"ለ","ሉ","ሊ","ላ","ሌ","ል","ሎ"}};
  String audioName;	

  public void child(int parent){
    childPanel.removeAll();
    for (int i = 0; i < 7; i++) {
      childButtons[i] = new JButton(all_Childs[parent][i]);
      childPanel.add(childButtons[i]);
      childButtons[i].setFont(new Font("Abyssinica SIL",Font.PLAIN,53));
      childButtons[i].addActionListener(this);
      childAudio.put(childButtons[i],"Amharic Alphabets/"+ String.valueOf(parent + 1) +"/"+ String.valueOf(i + 1) + ".wav" );
     }
  }

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
        amharicAlphabetsMap.put(amhButtons[i],"Amharic Alphabets/"+ String.valueOf(i + 1) + ".wav");
        amharicChildAlphabetsMap.put(amhButtons[i],i);
        amhPanel.add(amhButtons[i]);
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
        new AudioPlayer(audioName);
      }
    }

    for (Object key : amharicChildAlphabetsMap.keySet()) {
      if (e.getSource() == key) {
        child(amharicChildAlphabetsMap.get(key));
      }
    }
    
    for (Object key : childAudio.keySet()) {
      if(e.getSource() == key){
        String childAudioName = childAudio.get(key);
        new AudioPlayer(childAudioName);
      }
      
    }
    
  }
}
