
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuizProgram extends JFrame {

  private JPanel contentPane;
  private JTextField answerField;
  private int currentQuestion = 0;
  private String[] questions = { "What is the capital of France?", 
                                 "What is the currency of Japan?", 
                                 "What is the largest ocean in the world?" };
  private String[] answers = { "Paris", "Yen", "Pacific Ocean" };

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          QuizProgram frame = new QuizProgram();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the frame.
   */
  public QuizProgram() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JLabel questionLabel = new JLabel(questions[currentQuestion]);
    questionLabel.setBounds(25, 50, 400, 50);
    contentPane.add(questionLabel);
    
    answerField = new JTextField();
    answerField.setBounds(25, 150, 400, 50);
    contentPane.add(answerField);
    answerField.setColumns(10);
    
    JButton submitButton = new JButton("Submit");
    submitButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String userAnswer = answerField.getText();
        if (userAnswer.equalsIgnoreCase(answers[currentQuestion])) {
          JOptionPane.showMessageDialog(null, "Correct!");
        } else {
          JOptionPane.showMessageDialog(null, "Incorrect.");
        }
        currentQuestion++;
        if (currentQuestion == questions.length) {
          JOptionPane.showMessageDialog(null, "Quiz Completed.");
          System.exit(0);
        } else {
          questionLabel.setText(questions[currentQuestion]);
          answerField.setText("");
        }
      }
    });
    submitButton.setBounds(150, 220, 100, 50);
    contentPane.add(submitButton);
  }
}
