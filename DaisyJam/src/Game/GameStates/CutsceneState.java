package Game.GameStates;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import Resources.Images;
import Main.Game;
import Main.Handler;
import Game.GameStates.*;

import Main.Handler;


public class CutsceneState extends State{    
	
	
	//Cutcene arrays
	public static BufferedImage[] cutscene1 = {};

	public CutsceneState(Handler handler) {
		super(handler);
	}
	
	public static void Run(Graphics g, BufferedImage[] cutscene) {
		for(int i = 0; i < cutscene.length; i++) {
			int count = 0;
			while(count < 60) {
				g.drawImage(cutscene[i],0,0,800,600,null);
				count ++;
			}
		}
	}

	// Implement method to change worlds when cutscene ends 
	
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
