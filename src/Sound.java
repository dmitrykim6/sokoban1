import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;


class Sound{
    Clip clip;
    int isPlay;

    void playSound(String filename, int loop){
        isPlay = 1;

      try
        {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(filename)));
            clip.start();
            if (loop == 1) {
                clip.loop(1000);
            }
        }
      catch (Exception exc)
        {
            exc.printStackTrace(System.out);
        }
    }

    void stopPlay(){
        if (isPlay == 1){
            isPlay = 0;
            clip.stop();
            clip.close();

        }
    }

}