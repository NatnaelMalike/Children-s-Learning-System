
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlayer {
  public AudioPlayer(String au){
    
    try {
      File audioFile = new File("./audio/" + au);
      AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
      Clip audioClip = AudioSystem.getClip();
      audioClip.open(audioStream);
      audioClip.start();
    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
      ex.printStackTrace();
    }
  }
}
