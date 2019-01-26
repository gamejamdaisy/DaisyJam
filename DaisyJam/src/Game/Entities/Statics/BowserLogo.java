package Game.Entities.Statics;

import Game.Items.Item;
import Game.Tiles.Tile;
import Resources.Images;
import Main.Handler;

import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Elemental on 1/2/2017.
 */
public class BowserLogo extends StaticEntity {
	
    public BowserLogo(Handler handler, float x, float y) {
        super(handler, x, y, 420, 420);

        bounds.x=0;
        bounds.y=0;
        bounds.width = 0;
        bounds.height = 0;
        health=99999999;

    }

    @Override
    public void tick() {
        if(isBeinghurt()){
            
        }
        if(!isBeinghurt() && !handler.getKeyManager().attbut){
            
        }
        if(!isActive()){
           

        }

    }

    @Override
    public void render(Graphics g) {
//        renderLife(g);
        g.drawImage(Images.blocks[26],(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);

    }

    @Override
    public void die() {
    }
}