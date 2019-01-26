package Game.Entities.Statics;

import Resources.Images;
import Main.Handler;

import java.awt.*;


public class Cactus extends StaticEntity {
	
    public Cactus(Handler handler, float x, float y) {
        super(handler, x, y, 230, 134);

        bounds.x=26;
        bounds.y=122;
        bounds.width = 86;
        bounds.height = 105;
        health=199999999;
    }   
    
    @Override
    public void render(Graphics g) {
        g.drawImage(Images.blocks[19],(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);

    }

	@Override
	public void tick() {
		
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}