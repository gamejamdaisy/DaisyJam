package Game.Entities.Statics;

import Resources.Images;
import Main.Handler;

import java.awt.*;


public class PeachStatue extends StaticEntity {
	
    public PeachStatue(Handler handler, float x, float y) {
        super(handler, x, y, 236, 104);

        bounds.x=7;
        bounds.y=139;
        bounds.width = 95;
        bounds.height = 92;
        health=999999;
    }   
    
    @Override
    public void render(Graphics g) {
        g.drawImage(Images.blocks[13],(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);

    }

	@Override
	public void tick() {
		
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}