package Game.Tiles;

import Resources.Images;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Elemental on 1/1/2017.
 */

public class Tile {

    //statics

    public static Tile[] tiles = new Tile[256];
    
    //World 1
    //New Grass Tiles (Peach's Garden)
    public static Tile emptygrassTile = new GrassTile(Images.blocks[1], 1);
    public static Tile onegrassTile = new GrassTile(Images.blocks[2], 2);
    public static Tile twograssTile = new GrassTile(Images.blocks[3], 3);
    public static Tile oneflowerTile = new GrassTile(Images.blocks[4], 4);
    public static Tile twoflowerTile = new GrassTile(Images.blocks[5], 5);
    
    //Border Tiles brought down to just one
    public static Tile peachcastletile = new BorderTile(6);

     //Bricks
    public static Tile bricktile = new BrickTile(Images.blocks[8],8);
    public static Tile emptybricktile = new BrickTile(Images.blocks[9],9);
    
    //World 2 (Desert)
    public static Tile sand = new GrassTile(Images.blocks[16], 10);
    public static Tile desertwall = new BrickTile(Images.blocks[17],11);
    public static Tile emptybricknograss = new BrickTile(Images.blocks[18],12);
  
    //World 3 (Bowser)
    public static Tile castlefloor = new GrassTile(Images.blocks[23], 13);
    public static Tile castlewall = new BrickTile(Images.blocks[24],14);
    
    //CLASS


    protected BufferedImage texture;
    protected final int id;
    public static final int TILEWIDTH = 64 ,TILEHEIGHT = 64;


    public Tile(BufferedImage texture, int id){

        this.texture=texture;
        this.id=id;

        tiles[id] = this;

    }

    public void tick(){

    }

    public void render(Graphics g, int x, int y){
        g.drawImage(texture,x,y,TILEWIDTH,TILEHEIGHT,null);


    }

    public boolean isSolid(){
        return false;
    }

    public int getId() {
        return id;
    }
}
