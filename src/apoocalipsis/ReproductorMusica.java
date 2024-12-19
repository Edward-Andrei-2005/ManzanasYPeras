package apoocalipsis;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class ReproductorMusica {
    //Atributos
    private Clip clip;
    
    //Métodos publicos
    public void reproducirMusica(String ruta) {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(getClass().getResource(ruta));
            clip = AudioSystem.getClip();
            clip.open(audioStream);

            // Control del volumen (FloatControl)
            FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

            // Ajustar el volumen (por ejemplo, -10.0f para reducir el volumen o 6.0f para aumentarlo)
            volumeControl.setValue(-20.0f);  // Rango común: de -80.0f (silencio) a 6.0f (máximo volumen)

            // Agregar listener para detectar el final del clip y reiniciarlo
            clip.addLineListener(event -> {
                if (event.getType() == javax.sound.sampled.LineEvent.Type.STOP) {
                    clip.setFramePosition(0); // Reiniciar al principio
                    clip.start(); // Volver a reproducir
                }
            });

            clip.start(); // Iniciar la música
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void detenerMusica() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
}
