import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Main {
    public static void main (String []args){
        Sound sound = new Sound();
        Viewer viewer = new Viewer();

//        sound.playSound("src/sound/clip_kalambur.wav");

    }

}


// "src/sound/clip1.wav"



//    public static void playMusic(String filepath){
//        InputStream music;
//
//        try{
//            music = new FileInputStream((new File(filepath)));
//            AudioStream audios = new AudioStream(music);
//            AudioPlayer.player.start(audios);
//        }
//        catch(Exception e){
//            JOptionPane.showMessageDialog(null, "Error");
//        }
//    }