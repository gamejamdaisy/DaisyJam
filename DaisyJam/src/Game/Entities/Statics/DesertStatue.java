package Game.Entities.Statics;

import Resources.Animation;
import Resources.Images;
import Main.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class DesertStatue extends StaticEntity {
	
	//Animation Variables
	private Animation statueeye;
	private int statueeyeanispeed = 150;

    public DesertStatue(Handler handler, float x, float y) {
        super(handler, x, y, 262, 134);

        bounds.x=41;
        bounds.y=202;
        bounds.width = 66;
        bounds.height = 62;
        health=999999999;
        
        //Animation
        statueeye = new Animation(statueeyeanispeed, Images.drystatue);
    }
    
    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentStatueFrame(),(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);

    }
    
	private BufferedImage getCurrentStatueFrame(){
		return statueeye.getCurrentFrame();

	}

	@Override
	public void tick() {
		statueeye.tick();
		
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}