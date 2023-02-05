import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;

public class Alphabets extends JFrame implements ActionListener {
  JButton[] numButtons = new JButton[10];
  JButton[] englishLetterButtons = new JButton[26];
  JPanel numBtnPanel = new JPanel();
  JPanel engBtnPanel = new JPanel();
  GridLayout numBtnGrid = new GridLayout(2,5);
  GridLayout engBtnGrid = new GridLayout(6,5);
  HashMap<Object, String> alphabetsMap = new HashMap<>();
  
  String audioName;
  public Alphabets(){
    setLayout(null);
    numBtnPanel.setLayout(numBtnGrid);
    engBtnPanel.setLayout(engBtnGrid);
    numBtnPanel.setBounds(10,10,300, 200);
    engBtnPanel.setBounds(10,240,300, 600);
    for (int i = 0; i < 10; i++) {
      numButtons[i] = new JButton(String.valueOf(i));
      numButtons[i].addActionListener(this);
      numBtnPanel.add(numButtons[i]);
      alphabetsMap.put(numButtons[i], "English Numbers/" + String.valueOf(i) +".wav" );
    }
    for (int i = 0; i < englishLetterButtons.length; i++) {
      englishLetterButtons[i] = new JButton(String.valueOf((char)(i + 65)));
      englishLetterButtons[i].addActionListener(this);
      engBtnPanel.add(englishLetterButtons[i]);
      alphabetsMap.put(englishLetterButtons[i],"English Alphabets/" +String.valueOf((char)(i + 65)) +".wav");

    }
    add(numBtnPanel);
    add(engBtnPanel);
    setSize(335,900);
    setVisible(true);
  }
  public static void main(String[] args) {
    
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          new Alphabets();
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
