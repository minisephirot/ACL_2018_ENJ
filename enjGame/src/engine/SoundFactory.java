package engine;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class SoundFactory {

    private static Clip clip;
    private static AudioInputStream oyeah;
    private static AudioInputStream cry;
    private static AudioInputStream tp;
    private static AudioInputStream ouch;
    private static AudioInputStream okey;

    public SoundFactory(){
        try {
            oyeah = AudioSystem.getAudioInputStream(this.getClass().getResource("/res/sound/oyeah.wav"));
            cry = AudioSystem.getAudioInputStream(this.getClass().getResource("/res/sound/cry.wav"));
            tp = AudioSystem.getAudioInputStream(this.getClass().getResource("/res/sound/tp.wav"));
            ouch = AudioSystem.getAudioInputStream(this.getClass().getResource("/res/sound/no.wav"));
            okey = AudioSystem.getAudioInputStream(this.getClass().getResource("/res/sound/okeydokey.wav"));
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            System.out.println("Erreur recup du canal son / Chargement des fichiers.");
        }
    }

    public static void playSound(AudioInputStream sound){
        // Open audio clip and load samples from the audio input stream.
        try {
            if(clip.isActive() || clip.isRunning()) {
                clip.stop();
                clip.flush();
            }
            clip.setFramePosition(0);
            clip.open(sound);
        } catch (LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
        clip.start();
    }

    public static void playOkey(){
        playSound(okey);
    }

    public static AudioInputStream getOyeah(){
        return oyeah;
    }

    public static AudioInputStream getTP() {
        return tp;
    }

    public static AudioInputStream getCry() {
        return cry;
    }

    public static AudioInputStream getOuch(){
        return ouch;
    }
}
