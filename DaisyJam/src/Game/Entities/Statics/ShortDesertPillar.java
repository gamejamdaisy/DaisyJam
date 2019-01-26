package Game.Entities.Statics;

import Resources.Images;
import Main.Handler;

import java.awt.*;


public class ShortDesertPillar extends StaticEntity {
	
    public ShortDesertPillar(Handler handler, float x, float y) {
        super(handler, x, y, 160, 64);

        bounds.x=0;
        bounds.y=89;
        bounds.width = 63;
        bounds.height = 71;
        health=199999999;
    }   
    
    @Override
    public void render(Graphics g) {
        g.drawImage(Images.blocks[20],(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);

    }

	@Override
	public void tick() {
		
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}