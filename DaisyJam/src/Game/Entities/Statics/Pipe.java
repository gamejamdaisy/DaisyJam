package Game.Entities.Statics;

import Game.Entities.Creatures.Player;
import Game.GameStates.State;
import Main.Handler;
import Resources.Images;
import Worlds.BaseWorld;

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

/**
 * Created by Elemental on 2/2/2017.
 */


public class Pipe extends StaticEntity {

    private Rectangle ir = new Rectangle();
    public Boolean EP = false;
    public Boolean QC = false;
    
    protected boolean amDead = false;
    
    private File audioFile;
	private AudioInputStream audioStream; 
	private AudioFormat format; 
	private DataLine.Info info;
	private Clip audioClip;

    private BaseWorld world;

    public Pipe(Handler handler, float x, float y,BaseWorld world) {
        super(handler, x, y, 82, 136);
        this.world=world;
        health=1;
        bounds.x=0;
        bounds.y=0;
        bounds.width = 136;
        bounds.height = 82;
 
        ir.width = bounds.width;
        ir.height = bounds.height;
        int irx=(int)(bounds.x-handler.getGameCamera().getxOffset()+x);
        int iry= (int)(bounds.y-handler.getGameCamera().getyOffset()+height);
        ir.y=iry;
        ir.x=irx;
    }

    @Override
    public void tick() {
    	
    }

    @Override
    public void render(Graphics g) {
    	 g.drawImage(Images.pipe,(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);
    }

    @Override
    public void die() {
    	handler.setWorld(world);
    	handler.getWorld().getEntityManager().getPlayer().setIsPipe1dead(true);
    	try {
			audioFile = new File("res/music/PipeSound.wav");
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
}
