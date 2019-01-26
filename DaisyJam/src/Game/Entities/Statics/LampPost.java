package Game.Entities.Statics;

import Resources.Images;
import Main.Handler;

import java.awt.*;


public class LampPost extends StaticEntity {
	
    public LampPost(Handler handler, float x, float y) {
        super(handler, x, y, 166, 52);

        bounds.x=16;
        bounds.y=128;
        bounds.width = 20;
        bounds.height = 32;
        health=999999999;
    }   
    
    @Override
    public void render(Graphics g) {
        g.drawImage(Images.blocks[12],(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);

    }

	@Override 
	public void tick() {
		
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}