package Game.Entities.Statics;

import Resources.Images;
import Main.Handler;

import java.awt.*;


public class LongDesertPillar extends StaticEntity {
	
    public LongDesertPillar(Handler handler, float x, float y) {
        super(handler, x, y, 320, 64);

        bounds.x=0;
        bounds.y=237;
        bounds.width = 62;
        bounds.height = 83;
        health=199999999;
    }   
    
    @Override
    public void render(Graphics g) {
        g.drawImage(Images.blocks[21],(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);

    }

	@Override
	public void tick() {
		
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}