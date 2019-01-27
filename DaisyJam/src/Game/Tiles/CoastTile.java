package Game.Tiles;

import java.awt.image.BufferedImage;

import Resources.Images;

/**
 * Created by Elemental on 1/1/2017.
 */
public class CoastTile extends Tile {

	public CoastTile(BufferedImage texture,int id) {
		super(texture, id);
	}
	
    @Override
    public boolean isSolid(){
        return true;
    }
}