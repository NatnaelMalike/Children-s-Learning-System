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
    Image backgnd = tk.getImage("images/num.jpg");
        ImageIcon iconback = new ImageIcon(backgnd);
        JLabel background = new JLabel(iconback);

    public EnglishNumber(){
      setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent e){
          dispose();
          new English_Page();
        }
      });
        setLayout(null);
    numBtnPanel.setLayout(numBtnGrid);
    numBtnGrid.setVgap((int)(screenSize.height * 0.1));
    numBtnGrid.setHgap((int)(screenSize.height * 0.1));
    numBtnPanel.setBounds((int)(screenSize.width * 0.1),(int)(screenSize.height * 0.2),(int)(screenSize.width * 0.8),(int)(screenSize.height * 0.65));
    for (int i = 0; i < 10; i++) {
      image = tk.getImage("images/English Numbers/" +String.valueOf(i) +".jpg");
        icon = new ImageIcon(image);
        numButtons[i] = new JButton("",icon);
        numButtons[i].addActionListener(this);
        numButtons[i].setOpaque(false);
        numButtons[i].setContentAreaFilled(false);
        numBtnPanel.add(numButtons[i]);
        numberMap.put(numButtons[i], "English Numbers/" + String.valueOf(i) +".wav" );
      }
      add(numBtnPanel);
    setSize(screenSize.width,screenSize.width);
    setVisible(true);
    numBtnPanel.setOpaque(false);
    background.setBounds(0,0,screenSize.width,screenSize.height);
        add(background);
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
