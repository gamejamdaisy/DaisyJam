package Game.Tiles;

import Resources.Images;

/**
 * Created by Elemental on 1/1/2017.
 */
public class BorderTile extends Tile {

	public BorderTile(int id) {
		super(Images.blocks[6], id);
	}
	
    @Override
    public boolean isSolid(){
        return true;
    }
}
