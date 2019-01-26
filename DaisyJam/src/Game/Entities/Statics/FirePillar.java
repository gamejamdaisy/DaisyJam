package Game.Entities.Statics;

import Resources.Animation;
import Resources.Images;
import Main.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FirePillar extends StaticEntity {
	
	//Animation Variables
	private Animation watersplash;
	private int wateranispeed = 50;

    public FirePillar(Handler handler, float x, float y) {
        super(handler, x, y, 370, 124);

        bounds.x=4;
        bounds.y=285;
        bounds.width = 119;
        bounds.height = 87;
        health=999999999;
        
        //Animation
        watersplash = new Animation(wateranispeed, Images.firepillar);
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