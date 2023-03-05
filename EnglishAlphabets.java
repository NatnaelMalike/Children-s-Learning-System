import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;

public class EnglishAlphabets extends JFrame implements ActionListener {
  Toolkit tk=Toolkit.getDefaultToolkit();
  Dimension screenSize = tk.getScreenSize();
  JButton[] englishLetterButtons = new JButton[26];
  JPanel engBtnPanel = new JPanel();
  Image image;
  ImageIcon icon; 
  GridLayout engBtnGrid = new GridLayout(6,5);
  HashMap<Object, String> alphabetsMap = new HashMap<>();
  String audioName;
  public EnglishAlphabets(){
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e){
        dispose();
        new English_Page();
      }
    });
    engBtnGrid.setVgap((int)(screenSize.width * 0.05));
    engBtnGrid.setHgap((int)(screenSize.width * 0.05));
    engBtnPanel.setLayout(engBtnGrid);
    for (int i = 0; i < englishLetterButtons.length; i++) {
      image = tk.getImage("images/English Alphabets/" +String.valueOf((char)(i + 65)) +".jpg");
      icon = new ImageIcon(image);
      englishLetterButtons[i] = new JButton("",icon);
      englishLetterButtons[i].addActionListener(this);
      engBtnPanel.add(englishLetterButtons[i]);
      alphabetsMap.put(englishLetterButtons[i],"English Alphabet/" +String.valueOf((char)(i + 65)) +".wav");
    }
    JScrollPane scpane = new JScrollPane(engBtnPanel);
    engBtnPanel.setPreferredSize(new Dimension((int)(screenSize.width*0.8),(int)(screenSize.height*2.8)));
    
    add(scpane);
    setSize(screenSize.width,screenSize.width);
    setVisible(true);
  }
  public static void main(String[] args) {
    
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          new EnglishAlphabets();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    for (Object key : alphabetsMap.keySet()) {
      if (e.getSource() == key) {
        audioName = alphabetsMap.get(key);
      }
    }
    new AudioPlayer(audioName);
    
  }
  
}
