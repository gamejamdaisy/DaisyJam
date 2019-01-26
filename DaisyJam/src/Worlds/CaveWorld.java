package Worlds;
import Game.Entities.Creatures.*;
import Game.Entities.Statics.*;
import Main.Handler;

/**
 * Created by Elemental on 2/10/2017.
 */
public class CaveWorld extends BaseWorld{
	private Handler handler;
	private Player player;
	private BaseWorld world3;

	public CaveWorld(Handler handler, String path, Player player) {
		super(handler,path,player);
		this.handler = handler;
		this.player=player;
		
		world3 = new World3(handler,"res/Maps/map3.map",player);

		entityManager.addEntity(new YoshiNPC(handler, 300, 0, world3));
		entityManager.addEntity(new DoorW2(handler, 100, 0, world3));
		entityManager.addEntity(new Rock(handler, 75, 370));
		//entityManager.addEntity(new ShortDesertPillar(handler, 425, 0));
		entityManager.addEntity(new ShortDesertPillar(handler, 425, 275));
		entityManager.addEntity(new Cactus(handler, 693, 95));
		entityManager.addEntity(new ShortDesertPillar(handler, 1050, 0));
		entityManager.addEntity(new ShortDesertPillar(handler, 1050, 275));
		entityManager.addEntity(new Rock(handler, 1460, 66));
		entityManager.addEntity(new LongDesertPillar(handler, 1290, 275));
		entityManager.addEntity(new LongDesertPillar(handler, 1465, 275));
		entityManager.addEntity(new DesertStatue(handler, 425, 600));
		entityManager.addEntity(new DesertStatue(handler, 790, 600));
		entityManager.addEntity(new DryBones(handler, 900, 600));
		entityManager.addEntity(new DesertStatue(handler, 1125, 600));
		entityManager.addEntity(new Rock(handler, 1460, 925));
		entityManager.addEntity(new ShortDesertPillar(handler, 1000, 515));
		entityManager.addEntity(new ShortDesertPillar(handler, 650, 515));
		entityManager.addEntity(new ShortDesertPillar(handler, 1000, 860));
		entityManager.addEntity(new ShortDesertPillar(handler, 650, 860));
		entityManager.addEntity(new Rock(handler, 75, 590));
		entityManager.addEntity(new LongDesertPillar(handler, 75, 840));
		entityManager.addEntity(new LongDesertPillar(handler, 250, 840));
		entityManager.addEntity(new Rock(handler, 75, 1460));
		entityManager.addEntity(new Cactus(handler, 350, 1175));
		entityManager.addEntity(new ShortDesertPillar(handler, 1000, 1100));
		entityManager.addEntity(new ShortDesertPillar(handler, 650, 1100));
		entityManager.addEntity(new ShortDesertPillar(handler, 1000, 1375));
		entityManager.addEntity(new ShortDesertPillar(handler, 650, 1375));
		entityManager.addEntity(new QuestionBlockGrassless(handler, 1000, 750));
		entityManager.addEntity(new QuestionBlockGrassless(handler, 650, 750));
		entityManager.addEntity(new ChainChomp(handler, 1300, 1450));
	}
	
	@Override
	public void tick() {
		entityManager.tick();
		itemManager.tick();
		
	}

}