import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.*;
import javax.swing.*;

public class QuizScore extends JFrame {
    String amH;
    String enH;
    JLabel info;
    JLabel highScore;
    JLabel Score;
    JLabel hScore;
    public QuizScore(int answered){
        
        setLayout(null);
        info  = new JLabel("Score:");
        Score = new JLabel(String.valueOf(answered));
        highScore = new JLabel("High Score");
        hScore = new JLabel();
        info.setFont(new Font("Monospaced",Font.BOLD,50));
        Score.setFont(new Font("Monospaced",Font.BOLD,40));
        highScore.setFont(new Font("Monospaced",Font.BOLD,50));
        hScore.setFont(new Font("Monospaced",Font.BOLD,40));
        info.setBounds(150,100,250,75);
        Score.setBounds(180,175,250,75);
        highScore.setBounds(150,250,350,75);
        hScore.setBounds(180,325,250,75);
        setSize(500,500);
        setVisible(true);
        setTitle("Quiz Score");
        add(info);
        add(Score);
        add(highScore);
        add(hScore);
        
    }
    public void englishWrite(String answer){
        englishRead();
        try {
            if(Integer.valueOf(answer)> Integer.valueOf(enH)){
                File file = new File("./docs/ScoreEnglish.txt");
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(answer);
                hScore.setText(answer);
                bw.close();
            }
            
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void englishRead(){
        try {
            File file = new File("./docs/ScoreEnglish.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);   
            String line;
            while ((line = br.readLine()) != null) {
                this.enH=line;
                hScore.setText(enH);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
    }
    public void AmharicWrite(String answer){
        amharicRead();
        try {
            
            if(Integer.valueOf(answer)> Integer.valueOf(amH)){
            File file = new File("./docs/ScoreAmharic.txt");
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            hScore.setText(answer);
            bw.write(answer);
            bw.close();
            }
            
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void amharicRead(){
        try {
            File file = new File("./docs/ScoreAmharic.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);   
            String line;
            while ((line = br.readLine()) != null) {
                this.amH = line;
                hScore.setText(amH);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
    
    }
}
