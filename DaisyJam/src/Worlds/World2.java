package Worlds;

import Game.Entities.Creatures.Player;
import Game.GameStates.State;
import Main.Handler;

public class World2 extends BaseWorld{
	private Handler handler;
	private Player player;
	private BaseWorld world2;

	public World2(Handler handler, String path, Player player) {
		super(handler,path,player);
		this.handler = handler;
		this.player=player;
		
		//Stuff in the World go here
		entityManager.getPlayer().setX(292);
		entityManager.getPlayer().setY(200);
		
		


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