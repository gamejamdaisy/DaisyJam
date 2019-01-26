package Music;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;

import Game.GameStates.*;
import Main.Handler;


public class MusicManager extends State{

	public MusicManager(Handler handler) {
		super(handler);
	}

	public static final boolean MUSIC_ON = true;
	public static final boolean MUSIC_OFF = false;
	
	//Different music per state
	private AudioClip menuMusic;
	private AudioClip pauseMusic;
	private AudioClip victoryMusic;
	private AudioClip gameOverMusic;

	//World Music
	private AudioClip song1;
	private AudioClip song2;
	
	//Methods for the music in each state
	public void playMenuMusic() {
		if(MUSIC_ON && State.getState().equals(handler.getGame().menuState)) {
			new Thread(new Runnable(){
    			public void run() {
    				menuMusic.loop();;
    			}
    		}).start();
		}
	}
	
	public void playPauseMusic() {
		if(MUSIC_ON && State.getState().equals(handler.getGame().pauseState)) {
			new Thread(new Runnable(){
    			public void run() {
    				pauseMusic.loop();
    			}
    		}).start();
		}
	}
	
	public void playVictoryMusic() {
		if(MUSIC_ON && State.getState().equals(handler.getGame().victoryState)) {
			new Thread(new Runnable(){
    			public void run() {
    				victoryMusic.loop();
    			}
    		}).start();
		}
	}
	
	public void playGameOverMusic() {
		if(MUSIC_ON && State.getState().equals(handler.getGame().gameOverState)) {
			new Thread(new Runnable(){
    			public void run() {
    				gameOverMusic.loop();
    			}
    		}).start();
		}
	}
	
	//Methods for music on each world
	public void playGameMusic(AudioClip clip) {
		if(MUSIC_ON && State.getState().equals(handler.getGame().gameState)) {
			new Thread(new Runnable(){
    			public void run() {
    				clip.loop();
    			}
    		}).start();
		}
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
	}
}
