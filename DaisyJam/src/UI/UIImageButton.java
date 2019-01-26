package UI;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Created by Elemental on 1/2/2017.
 */
public class UIImageButton extends UIObject{
	private BufferedImage[] images;
	private ClickListlener clicker;
	private File audioFile;
	private AudioInputStream audioStream;
	private AudioFormat format;
	private DataLine.Info info;
	private Clip audioClip;
	private int counter;


	public UIImageButton(float x, float y, int width, int height, BufferedImage[] images,ClickListlener clicker ) {
		super(x, y, width, height);
		this.images=images;
		this.clicker=clicker;
	}


	@Override
	public void tick() {

	} 

	@Override
	public void render(Graphics g) {

		if(active){
			if(images.length==3) {
				g.drawImage(images[2], (int) x, (int) y, width, heith, null);
			}
		}
		else if(hovering){
			g.drawImage(images[1],(int)x,(int)y,width,heith,null);
			if (counter == 1) {
				try {
					audioFile = new File("res/music/SelectionSound.wav");
					audioStream = AudioSystem.getAudioInputStream(audioFile);
					format = audioStream.getFormat();
					info = new DataLine.Info(Clip.class, format);
					audioClip = (Clip) AudioSystem.getLine(info);
					audioClip.open(audioStream);
					audioClip.loop(0);
					counter = 0;


				} catch (UnsupportedAudioFileException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (LineUnavailableException e) {
					e.printStackTrace();
				}
			}
		}else{
			g.drawImage(images[0],(int)x,(int)y,width,heith,null);
			counter = 1;

		}
	}


	@Override
	public void onClick()
	{
		clicker.onClick();
	}
}
