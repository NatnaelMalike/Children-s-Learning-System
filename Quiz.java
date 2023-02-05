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
  Random random = new Random();
  HashMap <String, String> quizQueAns = new HashMap<>();
  String [] questions = {"A.wav","B.wav","C.wav","D.wav","E.wav","F.wav","1.wav","2.wav","3.wav","4.wav","5.wav","6.wav"};
  String [] answers = {"A","B","C","D","E","F","1","2","3","4","5","6"};
  String [] choiceLabels = new String[4];
  int currentQuestion = 0;
  int index = 0;
  int min = 0;
  int max = 3;
  int random_int;
  int choiceAnswer;
  boolean choiceChecker = true;

  public void randomChoice(){
    Choices[randomGenerator(3, 0)].setText(answers[index]);
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
    add(playMe);
    add(next);
    setLayout(null);
    setSize(300,500);
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
    
    if (e.getSource() == playMe ) {
      new AudioPlayer(questions[index]);

    }else if(e.getSource() == next){
      index ++;
      randomChoice(index);
    }else if(e.getSource() == Choices){
      
      for (int i = 0; i < Choices.length; i++) {
        if(Choices[i].getText() == String.valueOf(currentQuestion)){
          JOptionPane.showMessageDialog(null, "Correct!");
        }
      }
      
    }
    
  }
}
