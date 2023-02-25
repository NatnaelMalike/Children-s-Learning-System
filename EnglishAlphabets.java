import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;

public class EnglishAlphabets extends JFrame implements ActionListener {
  Toolkit tk=Toolkit.getDefaultToolkit();
  Dimension screenSize = tk.getScreenSize();
  JButton[] englishLetterButtons = new JButton[26];
  JPanel engBtnPanel = new JPanel();
 
  
  
  GridLayout engBtnGrid = new GridLayout(6,5);
  HashMap<Object, String> alphabetsMap = new HashMap<>();
  String audioName;
  public EnglishAlphabets(){
    //setLayout(null);
    engBtnGrid.setVgap((int)(screenSize.width * 0.05));
    engBtnGrid.setHgap((int)(screenSize.width * 0.05));
    engBtnPanel.setLayout(engBtnGrid);
    
  
    for (int i = 0; i < englishLetterButtons.length; i++) {
      englishLetterButtons[i] = new JButton(String.valueOf((char)(i + 65)));
      englishLetterButtons[i].addActionListener(this);
      engBtnPanel.add(englishLetterButtons[i]);
      alphabetsMap.put(englishLetterButtons[i],"English Alphabets/" +String.valueOf((char)(i + 65)) +".wav");
    }
    JScrollPane scpane = new JScrollPane(engBtnPanel);
    //engBtnPanel.setBounds((int)(screenSize.width * 0.05),(int)(screenSize.height * 0.05),(int)(screenSize.width * 0.8),(int)(screenSize.height * 0.5));
    engBtnPanel.setPreferredSize(new Dimension((int)(screenSize.width*0.8),(int)(screenSize.height*1.5)));
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
