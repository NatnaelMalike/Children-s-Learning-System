import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {
  JPanel btnBoard = new JPanel();
  GridLayout btnGrid = new GridLayout(2,2);
  JButton [] Choices = new JButton[4];
  JButton playMe = new JButton("Play~Sound");
  JButton next = new JButton("Next Question");
  String [] questions = {"A.wav","B.wav","1.wav","4.wav"};
  int currentQuestion = 0;
  int index = 0;


  public Quiz(){
    for (int i = 0; i < Choices.length; i++) {
          Choices[i] = new JButton("A");
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
      currentQuestion++;
      
    }
    
  }
}
