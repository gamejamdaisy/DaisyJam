package Game.Entities.Statics;

import Resources.Animation;
import Resources.Images;
import Main.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Fountain extends StaticEntity {
	
	//Animation Variables
	private Animation watersplash;
	private int wateranispeed = 50;

    public Fountain(Handler handler, float x, float y) {
        super(handler, x, y, 226, 216);

        bounds.x=3;
        bounds.y=64;
        bounds.width = 213;
        bounds.height = 163;
        health=999999999;
        
        //Animation
        watersplash = new Animation(wateranispeed, Images.fountain);
    }
    
    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentFountainFrame(),(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);

    }
    
	private BufferedImage getCurrentFountainFrame(){
		return watersplash.getCurrentFrame();

	}

	@Override
	public void tick() {
		watersplash.tick();
		
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}