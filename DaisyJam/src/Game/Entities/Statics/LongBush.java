package Game.Entities.Statics;

import Resources.Images;
import Main.Handler;

import java.awt.*;


public class LongBush extends StaticEntity {
	
    public LongBush(Handler handler, float x, float y) {
        super(handler, x, y, 224, 60);

        bounds.x=0;
        bounds.y=37;
        bounds.width = 59;
        bounds.height = 189;
        health=99999999;
    }   
    
    @Override
    public void render(Graphics g) {
        g.drawImage(Images.blocks[14],(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);

    }

	@Override
	public void tick() {
		
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}