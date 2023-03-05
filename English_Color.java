
import javax.swing.*;
import java.awt.*;
    import java.awt.event.*;
    import java.util.HashMap;
    public class English_Color extends JFrame implements ActionListener{
        Toolkit tk=Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        JButton [] colorButtons = new JButton[12];
        JPanel colorBtnPanel = new JPanel();
        GridLayout colorBtnGrid = new GridLayout(2,6);
        Image image;
        ImageIcon icon;
        Image backgnd = tk.getImage("images/School 02.jpg");
        ImageIcon iconback = new ImageIcon(backgnd);
        JLabel background = new JLabel(iconback);
        HashMap <Object, String> colorsAudio = new HashMap<>();
        String audioName;
        
        public English_Color(){
          setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
          addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
              dispose();
              new English_Page();
            }
          });
            colorBtnPanel.setLayout(colorBtnGrid);
            colorBtnGrid.setVgap((int)(screenSize.width * 0.03));
            colorBtnGrid.setHgap((int)(screenSize.width * 0.02));
           // setLayout(null);
            for (int i = 0; i < colorButtons.length; i++) {
                image = tk.getImage("images/English Color/" +String.valueOf(i + 1) +".jpg");
                icon = new ImageIcon(image);
                colorButtons[i] = new JButton("", icon);
                colorButtons[i].addActionListener(this);
                colorButtons[i].setBorder(null);
                colorButtons[i].setContentAreaFilled(false);
                colorBtnPanel.add(colorButtons[i]);
                colorsAudio.put(colorButtons[i],"English Colors/"+String.valueOf(i + 1)+".wav");
            } 
            
            colorBtnPanel.setBounds((int)(screenSize.width*0.05),(int)(screenSize.height*0.05),(int)(screenSize.width*0.8),(int)(screenSize.height*1));
            //colorBtnPanel.setOpaque(false);
            add(colorBtnPanel);
            setSize(screenSize.width,screenSize.height);
            setVisible(true);
            background.setBounds(0,0,screenSize.width,screenSize.height);
            add(background);
            try {
              setUndecorated(true);
            } catch (Exception e) {
            }  
        }
        public static void main(String[] args) {
           new English_Color(); 
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
    
    

