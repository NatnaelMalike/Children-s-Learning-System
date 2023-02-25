import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import javax.swing.*;
public class EnglishNumber extends JFrame implements ActionListener {

    Toolkit tk=Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    Image image;
    ImageIcon icon;
    JPanel numBtnPanel = new JPanel();
    JButton[] numButtons = new JButton[10];
    GridLayout numBtnGrid = new GridLayout(2,5);
    HashMap<Object, String> numberMap = new HashMap<>();
    String audioName;

    public EnglishNumber(){
        setLayout(null);
    numBtnPanel.setLayout(numBtnGrid);
    numBtnGrid.setVgap((int)(screenSize.height * 0.1));
    numBtnGrid.setHgap((int)(screenSize.height * 0.1));
    numBtnPanel.setBounds((int)(screenSize.width * 0.1),(int)(screenSize.height * 0.2),(int)(screenSize.width * 0.8),(int)(screenSize.height * 0.6));
    for (int i = 0; i < 10; i++) {
        numButtons[i] = new JButton(String.valueOf(i));
        numButtons[i].addActionListener(this);
        numBtnPanel.add(numButtons[i]);
        numberMap.put(numButtons[i], "English Numbers/" + String.valueOf(i) +".wav" );
      }
      add(numBtnPanel);
    setSize(screenSize.width,screenSize.width);
    setVisible(true);
    }

    public static void main(String[] args) {
        
    EventQueue.invokeLater(new Runnable() {
        public void run() {
          try {
            new EnglishNumber();
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
      for (Object key : numberMap.keySet()) {
        if (e.getSource() == key) {
          audioName = numberMap.get(key);
        }
      }
      new AudioPlayer(audioName);
      
    }
}
