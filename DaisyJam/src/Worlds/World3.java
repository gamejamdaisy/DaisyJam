package Worlds;
import java.awt.Graphics;

import Game.Entities.Creatures.*;
import Game.Entities.Statics.*;
import Game.GameStates.State;
import Main.Handler;
import Resources.Images;


public class World3 extends BaseWorld{
	private Handler handler;
	private Player player;
	private BaseWorld world3;

	public World3(Handler handler, String path, Player player) {
		super(handler,path,player);
		this.handler = handler;
		this.player=player;
		
		//Stuff in the World go here
		entityManager.addEntity(new FirePillar(handler, 90, 520));
		entityManager.addEntity(new FirePillar(handler, 760, 520));
		entityManager.addEntity(new FirePillar(handler, 90, 125));
		entityManager.addEntity(new FirePillar(handler, 760, 125));
		entityManager.addEntity(new LuigiBlock(handler, 600, 100));
		entityManager.addEntity(new QuestionBlockGrassless(handler, 250, 375));
		entityManager.addEntity(new QuestionBlockGrassless(handler, 600, 375));
		entityManager.addEntity(new QuestionBlockGrassless(handler, 250, 750));
		entityManager.addEntity(new QuestionBlockGrassless(handler, 600, 750));
		entityManager.addEntity(new Bowser(handler, 350, 600));
		entityManager.addEntity(new ToadNPC(handler, 200, 0,world3));
		
		


  }
	@Override
	public void tick() {
		entityManager.tick();
		itemManager.tick();
		
		 countP++;
	        if(countP>=30){
	            countP=30;
	        }

	        if(handler.getKeyManager().pbutt && countP>=30){
	            handler.getMouseManager().setUimanager(null);
	            countP=0;
	            State.setState(handler.getGame().pauseState);
	        }
		
	}

}