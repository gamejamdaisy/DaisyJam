package Game.GameStates;
import Main.Game;
import Resources.Images;
import UI.ClickListlener;
import UI.UIImageButton;
import UI.UIManager;
import Main.Handler;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MenuState extends State {
	private File audioFile;
	private AudioInputStream audioStream;
	private AudioFormat format;
	private DataLine.Info info;
	private Clip audioClip;
	
	private UIManager uiManager;

	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUimanager(uiManager);
		


		uiManager.addObjects(new UIImageButton(510, 224, 136, 28, Images.startButtons, new ClickListlener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUimanager(null);
				handler.getGame().reStart();
				yehFam = true;
				State.setState(handler.getGame().gameState);
				try {
					audioFile = new File("res/music/Daisy_Yohoo.wav");
					audioStream = AudioSystem.getAudioInputStream(audioFile);
					format = audioStream.getFormat();
					info = new DataLine.Info(Clip.class, format);
					audioClip = (Clip) AudioSystem.getLine(info);
					audioClip.open(audioStream);
					audioClip.loop(0); 

				} catch (UnsupportedAudioFileException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (LineUnavailableException e) {
					e.printStackTrace();
				}
			}
		}));
		
		uiManager.addObjects(new UIImageButton(545, 312, 72, 22, Images.exitButtons, new ClickListlener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUimanager(null);
				handler.getGame().reStart();
				State.setState(handler.getGame().gameState);
			}
		}));
		
	}

	@Override
	public void tick() {
		handler.getMouseManager().setUimanager(uiManager);
		uiManager.tick();

		// Temporarily just go directly to the GameState, skip the menu state!
		//handler.getMouseManager().setUimanager(null);
		//State.setState(handler.getGame().gameState);
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.darkGray);
		g.fillRect(0,0,handler.getWidth(),handler.getHeight());
		g.drawImage(Images.title,0,0,800,600,null);
		uiManager.Render(g);

	}


}
