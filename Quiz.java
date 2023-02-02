import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Quiz extends JFrame implements ActionListener {
  JPanel btnBoard = new JPanel();
  GridLayout btnGrid = new GridLayout(2,2);
  JButton [] Choices = new JButton[4];
  JButton playMe = new JButton("Play~Sound");
  JButton next = new JButton("Next Question");
  JButton startQuiz = new JButton("Start Quiz");
  Random random = new Random();
  HashMap <String, String> quizQueAns = new HashMap<>();
  String [] questions = {"A.wav","T.wav","C.wav","D.wav","E.wav","F.wav","1.wav","2.wav","3.wav","4.wav"};
  Character [] []options = {{'C','J','A','S'},{'H','J','T','S'},{'H','C','T','S'},{'H','J','T','D'},{'E','J','T','S'},
  {'A','J','F','S'},{'5','2','1','0'},{'7','2','3','1'},{'5','6','8','3'},{'0','8','4','5'}};
  String [] choiceLabels = new String[4];
  int currentQuestion = 1;
  int index = 0;
  int min = 0;
  int max = 3;
  int randomIndex;
  int choiceAnswer;
  boolean choiceChecker = true;
  int num = 0;
  String question;

  public void randomChoice(){
    
    for (int i = 0; i < questions.length; i++) {
      randomIndex = (int) (Math.random() * questions.length);
       question = questions[randomIndex];
      for (int j = 0; j < 4; j++) {
        Choices[j].setText(String.valueOf(options[randomIndex][j]));
      }
    }
    
  }
  

  public int randomGenerator(int max, int min){
    return (int)Math.floor(Math.random() * (max - min + 1) + min);
  }

  public Quiz(){

    for (int i = 0; i < Choices.length; i++) {
          Choices[i] = new JButton("");
          Choices[i].addActionListener(this);
          btnBoard.add(Choices[i]);
    }
    playMe.setBounds(20, 250,100,40 );
    playMe.addActionListener(this);
    next.addActionListener(this);
    next.setBounds(150, 250,100,40 );
    startQuiz.addActionListener(this);
    startQuiz.setBounds(20, 300,100,40 );
    add(playMe);
    add(next);
    add(startQuiz);
    setLayout(null);
    setSize(1200,700);
    btnBoard.setLayout(btnGrid);
    btnBoard.setBounds(10,10,250,200);
    add(btnBoard);
    setVisible(true);
  }
  public static void main(String[] args) {
    new Quiz();
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == startQuiz){randomChoice();}
    
    else if (e.getSource() == playMe ) {
      new AudioPlayer(question);

    }else if(e.getSource() == next){
      currentQuestion++;
      
      randomChoice();
    }else{
      for(int i = 0; i<4; i++){
        if(e.getSource() == Choices[i]){
          if(question.charAt(0) == options[randomIndex][i]){
            JOptionPane.showMessageDialog(null, "Correct.");
          }else{
          JOptionPane.showMessageDialog(null, "InCorrect.");
          break;}
        }     
    }

  }
  if (currentQuestion == questions.length) {
    JOptionPane.showMessageDialog(null, "Quiz Completed.");
    System.exit(0);}
}
}
