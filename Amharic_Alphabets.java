import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
public class Amharic_Alphabets extends JFrame implements ActionListener {
  Toolkit tk=Toolkit.getDefaultToolkit();
  Dimension screenSize = tk.getScreenSize(); 
  JButton[] amhButtons= new JButton[34];
  JButton[] childButtons = new JButton[7];
  JPanel amhPanel = new JPanel();
  JPanel childPanel = new JPanel();
  JPanel cPanel = new JPanel();
  GridLayout amhGrid = new GridLayout(3,11);
  GridLayout childGrid = new GridLayout(1,7);
  Image image = tk.getImage("images/School 02.jpg");
  ImageIcon icon = new ImageIcon(image);
  JLabel label = new JLabel(icon);
  HashMap <Object, String> amharicAlphabetsMap = new HashMap<>();
  HashMap <Object, Integer> amharicChildAlphabetsMap = new HashMap<>();
  HashMap <Object, String> childAudio = new HashMap<>();
  String [] fir_amh = {"ሀ","ለ","ሐ","መ","ሠ","ረ","ሰ","ሸ","ቀ","በ","ቨ","ተ","ቸ","ኀ","ነ","ኘ",
              "አ","ከ","ኸ","ወ","ዐ","ዘ","ዠ","የ","ደ","ጀ","ገ","ጠ","ጨ","ጰ","ጸ","ፀ","ፈ","ፐ"};   
  String [][] all_Childs = {{"ሀ","ሁ","ሂ","ሃ","ሄ","ህ","ሆ"},{"ለ","ሉ","ሊ","ላ","ሌ","ል","ሎ"},{"ሐ","ሑ","ሒ","ሓ","ሔ","ሕ","ሖ"},
                            {"መ", "ሙ","ሚ","ማ","ሜ","ም","ሞ"},{"ሠ","ሡ","ሢ","ሣ","ሤ","ሥ","ሦ"},{"ረ","ሩ","ሪ","ራ","ሬ","ር","ሮ"},{"ሰ","ሱ","ሲ","ሳ","ሴ","ስ","ሶ"},
                            {"ሸ","ሹ","ሺ","ሻ","ሼ","ሽ","ሾ"},{"ቀ","ቁ","ቂ","ቃ","ቄ","ቅ","ቆ"},{"በ","ቡ","ቢ","ባ","ቤ","ብ","ቦ"},{"ቨ","ቩ","ቪ","ቫ","ቬ","ቭ","ቮ"},{"ተ","ቱ","ቲ","ታ","ቴ","ት","ቶ"},
                            {"ቸ","ቹ","ቺ","ቻ","ቼ","ች","ቾ"},{"ኀ","ኁ","ኂ","ኃ","ኄ","ኅ","ኆ"},{"ነ","ኑ","ኒ","ና","ኔ","ን","ኖ"},{"ኘ","ኙ","ኚ","ኛ","ኜ","ኝ","ኞ"},{"አ","ኡ","ኢ","ኣ","ኤ","እ","ኦ"},
                            {"ከ","ኩ","ኪ","ካ","ኬ","ክ","ኮ"},{"ኸ","ኹ","ኺ","ኻ","ኼ","ኽ","ኾ"},{"ወ","ዉ","ዊ","ዋ","ዌ","ው","ዎ"},{"ዐ","ዑ","ዒ","ዓ","ዔ","ዕ","ዖ"},{"ዘ","ዙ","ዚ","ዛ","ዜ","ዝ","ዞ"},
                            {"ዠ","ዡ","ዢ","ዣ","ዤ","ዥ","ዦ"},{"የ","ዩ","ዪ","ያ","ዬ","ይ","ዮ"},{"ደ","ዱ","ዲ","ዳ","ዴ","ድ","ዶ"},{"ጀ","ጁ","ጂ","ጃ","ጄ","ጅ","ጆ"},{"ገ","ጉ","ጊ","ጋ","ጌ","ግ","ጎ"},
                            {"ጠ","ጡ","ጢ","ጣ","ጤ","ጥ","ጦ"},{"ጨ","ጩ","ጪ","ጫ","ጬ","ጭ","ጮ"},{"ጰ","ጱ","ጲ","ጳ","ጴ","ጵ","ጶ"},{"ጸ","ጹ","ጺ","ጻ","ጼ","ጽ","ጾ"},{"ፀ","ፁ","ፂ","ፃ","ፄ","ፅ","ፆ"},
                            {"ፈ","ፉ","ፊ","ፋ","ፌ","ፍ","ፎ"},{"ፐ","ፑ","ፒ","ፓ","ፔ","ፕ","ፖ"}};
  String audioName;
  public void child(int parent){
    childPanel.removeAll();
    for (int i = 0; i < 7; i++) {
      childButtons[i] = new JButton(all_Childs[parent][i]);
      childPanel.add(childButtons[i]);
      childButtons[i].setFont(new Font("Abyssinica SIL",Font.PLAIN,(int)(screenSize.width * 0.03)));
      childButtons[i].addActionListener(this);
      childButtons[i].setBackground(new Color(4,240,232));
      childAudio.put(childButtons[i],"Amharic Alphabets/"+ String.valueOf(parent + 1) +"/"+ String.valueOf(i + 1) + ".wav" );
     }
  }
  public Amharic_Alphabets(){
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e){
        dispose();
        new Amharic_page();
      }
    });
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
    amhGrid.setVgap((int)(screenSize.height * 0.025));
    amhGrid.setHgap((int)(screenSize.height * 0.025));
    amhPanel.setLayout(amhGrid);
    amhPanel.setBounds((int)(screenSize.width * 0.1),(int)(screenSize.height * 0.47),(int)(screenSize.width * 0.8),(int)(screenSize.height * 0.35));
    childGrid.setHgap((int)(screenSize.height * 0.03));
    childPanel.setLayout(childGrid);
    childPanel.setBounds((int)(screenSize.width * 0.2),(int)(screenSize.height * 0.15),(int)(screenSize.width * 0.6),(int)(screenSize.height * 0.12));
    cPanel.setLayout(childGrid);
    add(amhPanel);
    add(childPanel);
   setLayout(null);
setSize(screenSize.width,screenSize.height); 
   for (int i = 0; i < amhButtons.length; i++) {
        amhButtons[i] = new JButton(fir_amh[i]);
        amhButtons[i].addActionListener(this);
        amhButtons[i].setFont(new Font("Abyssinica SIL",Font.PLAIN,(int)(screenSize.width * 0.0248)));
        amhButtons[i].setContentAreaFilled(false);
        amhButtons[i].setFocusable(false);
        amharicAlphabetsMap.put(amhButtons[i],"Amharic Alphabets/"+ String.valueOf(i + 1) + ".wav");
        amharicChildAlphabetsMap.put(amhButtons[i],i);
        amhPanel.add(amhButtons[i]);
   }
   label.setBounds(0,0,screenSize.width,screenSize.height);
  add(label);
  setVisible(true);
  childPanel.setOpaque(false);
  amhPanel.setOpaque(false);
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
