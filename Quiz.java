import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Quiz extends JFrame implements ActionListener {
  Toolkit tk=Toolkit.getDefaultToolkit();
  Dimension screenSize = tk.getScreenSize(); 
  JPanel btnBoard = new JPanel();
  JPanel score = new JPanel();
  GridLayout btnGrid = new GridLayout(2,2);
  JButton [] Choices = new JButton[4];
  JButton playMe, next,startQuiz;
  Random random = new Random();
  String [] btnPhoto = {"startQuiz","playMe","next"};
  HashMap <String, String> quizQueAns = new HashMap<>();
  String [] questions = {"E.wav","F.wav","J.wav","K.wav","U.wav","Z.wav","0.wav","3.wav","5.wav","7.wav","9.wav"};
  Character [] []options = {{'I','J','E','S'},{'H','B','T','F'},{'J','C','T','S'},{'H','K','A','D'},{'V','G','U','O'},
  {'Z','Y','L','N'},{'5','3','1','0'},{'5','7','3','8'},{'5','6','8','4'},{'1','8','4','7'},{'2','5','9','3'}};
  String [] choiceLabels = new String[4];
  int [] ind = new int[11];
  int currentQuestion = 1;
  int min = 0;
  int max = 3;
  int randomIndex;
  int indicator;
  String question;
  Image image1 = tk.getImage("images/Quiz/icon1.png");
  Image image2 = tk.getImage("images/Quiz/play sound.png");
  Image image3 = tk.getImage("images/Quiz/next.png");
  Image image4 = tk.getImage("images/Quiz/quizBackground.png");;
  ImageIcon icon1 = new ImageIcon(image1);
  ImageIcon icon2 = new ImageIcon(image2);
  ImageIcon icon3 = new ImageIcon(image3);
  ImageIcon icon4 = new ImageIcon(image4);;
  JLabel label = new JLabel(icon4);
  int answered;
  ArrayList<Integer> numbers;
  Random randomGenerator;

  public void randomChoice(){
   randomIndex = ind[indicator];
   question = questions[randomIndex];
      for (int j = 0; j < 4; j++) {
        Choices[j].setText(String.valueOf(options[randomIndex][j]));
      }
      indicator++;
}
  
  public int randomGenerator(int max, int min){
    return (int)Math.floor(Math.random() * (max - min + 1) + min);
  }
  public Quiz(){
    playMe = new JButton("", icon2);
    next = new JButton("", icon3);
    startQuiz = new JButton("", icon1);
    playMe.setBounds(50, 370,120,105 );
    playMe.addActionListener(this);
    playMe.setVisible(false);
    playMe.setBorder(null);
    playMe.setBackground(new Color(243,205,80));
    next.addActionListener(this);
    next.setVisible(false);
    next.setBounds(250, 360,120,120 );
    next.setBorder(null);
    next.setBackground(new Color(243,205,80));
    startQuiz.addActionListener(this);
    startQuiz.setBounds(50, 400,250,132 );
    add(playMe);
    add(next);
    add(startQuiz);
    setLayout(null);
    setSize(900,612 );
    btnBoard.setLayout(btnGrid);
    btnBoard.setBounds(70,50,280,250);
    btnBoard.setVisible(false);
    btnGrid.setHgap(35);
    btnGrid.setVgap(30);
    add(btnBoard);
    setLocation((int) (screenSize.width * 0.3),(int) (screenSize.width * 0.075));
    label.setBounds(0,0,900,612);
    add(label);
    setVisible(true);
     numbers = new ArrayList<Integer>();   
     randomGenerator = new Random();
    while (numbers.size() < questions.length) {
    int random = randomGenerator .nextInt(questions.length);
    if (!numbers.contains(random)) {
      numbers.add(random);
    }
  }
  for (int i = 0; i < numbers.size(); i++) {
    ind[i] = numbers.get(i);
  }
  }
  public static void main(String[] args) {
    new Quiz();
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == startQuiz){
      for (int i = 0; i < Choices.length; i++) {
        Choices[i] = new JButton("");
        Choices[i].addActionListener(this);
        Choices[i].setFont(new Font("Monospaced",Font.BOLD,63));
        Choices[i].setFocusable(false);
        Choices[i].setForeground(new Color(139,0,0));
        Choices[i].setBackground(new Color(243,205,80));
        Choices[i].setBorder(null);
        btnBoard.add(Choices[i]);
      }
      next.setVisible(true);
      playMe.setVisible(true);
      btnBoard.setVisible(true);
      startQuiz.setVisible(false);
      randomChoice();
    }
    else if (e.getSource() == playMe ) {
      new AudioPlayer("English Quiz/"+question);

    }else if(e.getSource() == next){
      currentQuestion++;
      randomChoice();
    }else{
      for(int i = 0; i<4; i++){
        if(e.getSource() == Choices[i]){
          if(question.charAt(0) == options[randomIndex][i]){
            new AudioPlayer("English Quiz/correct.wav");
            JOptionPane.showMessageDialog(null, "Correct.");
            answered++;
          }else{
            new AudioPlayer("English Quiz/incorrect.wav");
          JOptionPane.showMessageDialog(null, "InCorrect.");
          }
        }     
    }
  }
  if (currentQuestion == questions.length) {
    JOptionPane.showMessageDialog(null, "Quiz Completed.");
    System.exit(0);}
}
}
