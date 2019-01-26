package Game.Entities.Statics;

import Resources.Images;
import Main.Handler;

import java.awt.*;


public class ShortBush extends StaticEntity {
	
    public ShortBush(Handler handler, float x, float y) {
        super(handler, x, y, 128, 60);

        bounds.x=0;
        bounds.y=19;
        bounds.width = 60;
        bounds.height = 109;
        health=99999;
    }   
    
    @Override
    public void render(Graphics g) {
        g.drawImage(Images.blocks[15],(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);

    }

	@Override
	public void tick() {
		
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}