import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
public class Amharic_Color extends JFrame implements ActionListener {
    Toolkit tk=Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    JButton [] colorButtons = new JButton[12];
    JLabel [] colorName = new JLabel[12];
    JPanel box = new JPanel();
    JPanel colorBtnPanel = new JPanel();
    GridLayout colorBtnGrid = new GridLayout(6,2);
    GridLayout boxLayout = new GridLayout(2,1);
    Image image;
    ImageIcon icon;
    Image backgnd = tk.getImage("images/clrs.png");
    ImageIcon iconback = new ImageIcon(backgnd);
    JLabel background = new JLabel(iconback);
    HashMap <Object, String> colorsAudio = new HashMap<>();
    String audioName;
    String [] colorNames ={"አረንጓዴ", "ቢጫ", "ብርቱካንማ", "ቡኒ", "ግራጫ", "ሐምራዊ", "ነጭ", "ቀይ", "ሰማያዊ", "ጥቁር", "ወይነጠጅ", "ውሃማ"};

    public Amharic_Color(){
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
        setLayout(null);
        for (int i = 0; i < colorButtons.length; i++) {
            image = tk.getImage("images/Colors/" +String.valueOf(i + 1) +".png");
            icon = new ImageIcon(image);
            colorButtons[i] = new JButton("", icon);
            colorName[i] = new JLabel(colorNames[i]);
            colorName[i].setFont(new Font("Abyssinica SIL",Font.PLAIN,(int)(screenSize.width * 0.0248)));
            add(colorName[i]);
            colorButtons[i].addActionListener(this);
            add(colorButtons[i]);
            colorsAudio.put(colorButtons[i],"Amharic Colors/"+String.valueOf(i + 1)+".wav");
        } 
        colorButtons[0].setBounds((int)(screenSize.width * 0.05),(int)(screenSize.width * 0.02), (int)(screenSize.width * 0.1), (int)(screenSize.width * 0.1));
        colorButtons[1].setBounds((int)(screenSize.width * 0.05),(int)(screenSize.width * 0.195), (int)(screenSize.width * 0.1), (int)(screenSize.width * 0.1));
        colorButtons[2].setBounds((int)(screenSize.width * 0.05),(int)(screenSize.width * 0.377), (int)(screenSize.width * 0.1), (int)(screenSize.width * 0.1));
        colorButtons[3].setBounds((int)(screenSize.width * 0.3),(int)(screenSize.width * 0.02), (int)(screenSize.width * 0.1), (int)(screenSize.width * 0.1));
        colorButtons[4].setBounds((int)(screenSize.width * 0.3),(int)(screenSize.width * 0.195), (int)(screenSize.width * 0.1), (int)(screenSize.width * 0.1));
        colorButtons[5].setBounds((int)(screenSize.width * 0.3),(int)(screenSize.width * 0.377), (int)(screenSize.width * 0.1), (int)(screenSize.width * 0.1));
        colorButtons[6].setBounds((int)(screenSize.width * 0.55),(int)(screenSize.width * 0.02), (int)(screenSize.width * 0.1), (int)(screenSize.width * 0.1));
        colorButtons[7].setBounds((int)(screenSize.width * 0.55),(int)(screenSize.width * 0.195), (int)(screenSize.width * 0.1), (int)(screenSize.width * 0.1));
        colorButtons[8].setBounds((int)(screenSize.width * 0.55),(int)(screenSize.width * 0.377), (int)(screenSize.width * 0.1), (int)(screenSize.width * 0.1));
        colorButtons[9].setBounds((int)(screenSize.width * 0.8),(int)(screenSize.width * 0.02), (int)(screenSize.width * 0.1), (int)(screenSize.width * 0.1));
        colorButtons[10].setBounds((int)(screenSize.width * 0.8),(int)(screenSize.width * 0.195), (int)(screenSize.width * 0.1), (int)(screenSize.width * 0.1));
        colorButtons[11].setBounds((int)(screenSize.width * 0.8),(int)(screenSize.width * 0.377), (int)(screenSize.width * 0.1), (int)(screenSize.width * 0.1));
        colorName[0].setBounds((int)(screenSize.width * 0.067),(int)(screenSize.width * 0.091), 200, 200);
        colorName[1].setBounds((int)(screenSize.width * 0.077),(int)(screenSize.width * 0.265), 200, 200);
        colorName[2].setBounds((int)(screenSize.width * 0.057),(int)(screenSize.width * 0.449), 200, 200);
        colorName[3].setBounds((int)(screenSize.width * 0.337),(int)(screenSize.width * 0.091), 200, 200);
        colorName[4].setBounds((int)(screenSize.width * 0.337),(int)(screenSize.width * 0.265), 200, 200);
        colorName[5].setBounds((int)(screenSize.width * 0.317),(int)(screenSize.width * 0.449), 200, 200);
        colorName[6].setBounds((int)(screenSize.width * 0.587),(int)(screenSize.width * 0.091), 200, 200);
        colorName[7].setBounds((int)(screenSize.width * 0.587),(int)(screenSize.width * 0.265), 200, 200);
        colorName[8].setBounds((int)(screenSize.width * 0.567),(int)(screenSize.width * 0.449), 200, 200);
        colorName[9].setBounds((int)(screenSize.width * 0.837),(int)(screenSize.width * 0.091), 200, 200);
        colorName[10].setBounds((int)(screenSize.width * 0.817),(int)(screenSize.width * 0.265), 200, 200);
        colorName[11].setBounds((int)(screenSize.width * 0.837),(int)(screenSize.width * 0.449), 200, 200);
        add(colorBtnPanel);
        setSize(screenSize.width,screenSize.height);
        setVisible(true);
        setTitle("Amharic Colors");
        background.setBounds(0,0,screenSize.width,screenSize.height);
        add(background);
        try {
          setUndecorated(true);
        } catch (Exception e) {
          // TODO: handle exception
        }
        
    }
    public static void main(String[] args) {
       new Amharic_Color(); 
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
