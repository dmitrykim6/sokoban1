import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;


class Sound{
    Clip musicClip;
    Clip clip;
    int isPlay;

    void playSound(String filename){
        File file = new File(filename);
      try
        {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.start();
        }
      catch (Exception exc)
        {
            exc.printStackTrace(System.out);
        }
    }

    void playBackgroundSound(String filename, int loop){
        isPlay = 1;
        File file = new File(filename);
        try
        {
            musicClip = AudioSystem.getClip();
            musicClip.open(AudioSystem.getAudioInputStream(file));
            musicClip.start();

            musicClip.loop(loop);

        }
        catch (Exception exc)
        {
            exc.printStackTrace(System.out);
        }
    }

    void stopPlay(){
        if (isPlay == 1){
            isPlay = 0;
            musicClip.stop();
            musicClip.close();

        }
    }

}