package Worlds;
import Game.Entities.Creatures.*;
import Game.Entities.Statics.*;
import Game.GameStates.State;
import Main.Handler;


/**
 * Created by Elemental on 1/2/2017.
 */
public class World1 extends BaseWorld{

	private Handler handler;
	private BaseWorld caveWorld;

	public World1(Handler handler, String path, Player player){
		super(handler,path,player);
		this.handler = handler;
		caveWorld = new CaveWorld(handler,"res/Maps/caveMap.map",player);
		 
		
	    
		//entityManager.addEntity(new Door(handler, 100, 0, caveWorld));
		entityManager.addEntity(new LongBush(handler, 120, 200));
		entityManager.addEntity(new LongBush(handler, 330, 200));
		entityManager.addEntity(new Tree(handler, 80, 450));
		entityManager.addEntity(new Goomba(handler, 340, 600));
		entityManager.addEntity(new Tree(handler, 300, 650));
		entityManager.addEntity(new Tree(handler, 80, 900));
		entityManager.addEntity(new LongBush(handler, 120, 1200));
		entityManager.addEntity(new Goomba(handler, 340, 1300));
		entityManager.addEntity(new LampPost(handler, 483, 1160));
		entityManager.addEntity(new LampPost(handler, 483, 1365));
		entityManager.addEntity(new LampPost(handler, 70, 1365));
		entityManager.addEntity(new Fountain(handler, 700, 500));
		entityManager.addEntity(new PeachStatue(handler, 625, 0));
		entityManager.addEntity(new LampPost(handler, 600, 475));
		entityManager.addEntity(new LampPost(handler, 945, 475));
		entityManager.addEntity(new LampPost(handler, 760, 0));
		entityManager.addEntity(new PeachStatue(handler, 845, 0));
		entityManager.addEntity(new PeachStatue(handler, 1200, 0));
		entityManager.addEntity(new PeachStatue(handler, 1400, 0));
		entityManager.addEntity(new LampPost(handler, 1060, 0));
		entityManager.addEntity(new LampPost(handler, 1060, 150));
		entityManager.addEntity(new LampPost(handler, 1330, 0));
		entityManager.addEntity(new QuestionBlock(handler, 625, 300));
		entityManager.addEntity(new QuestionBlock(handler, 775, 300));
		entityManager.addEntity(new QuestionBlock(handler, 775, 425));
		entityManager.addEntity(new QuestionBlock(handler, 915, 300));
		entityManager.addEntity(new Rock(handler, 750, 1420));
		entityManager.addEntity(new Rock(handler, 615, 1325));
		entityManager.addEntity(new Rock(handler, 915, 1325));
		entityManager.addEntity(new Tree(handler, 725, 900));
		entityManager.addEntity(new ShortBush(handler, 600, 975));
		entityManager.addEntity(new ShortBush(handler, 920, 1150));
		entityManager.addEntity(new QuestionBlock(handler, 775, 1280));
		entityManager.addEntity(new Goomba(handler, 775, 710));
		entityManager.addEntity(new Tree(handler, 240, 1250));
		entityManager.addEntity(new Tree(handler, 1160, 325));
		entityManager.addEntity(new Tree(handler, 1380, 325));
		entityManager.addEntity(new PeachStatue(handler, 1300, 575));
		entityManager.addEntity(new LampPost(handler, 1180, 525));
		entityManager.addEntity(new LampPost(handler, 1460, 525));
		entityManager.addEntity(new LampPost(handler, 1180, 780));
		entityManager.addEntity(new LampPost(handler, 1460, 780));
		entityManager.addEntity(new LongBush(handler, 1180, 1025));
		entityManager.addEntity(new LongBush(handler, 1450, 1025));
		entityManager.addEntity(new Koopa(handler, 1300, 1450));
		entityManager.addEntity(new Pipe(handler, 1470, 1360, caveWorld));
		
		
		

		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
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