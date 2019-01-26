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
    
  //Island World
    public static Tile islandgrass = new GrassTile(Images.blocks[44],15);
    public static Tile islandtopgrass = new GrassTile(Images.blocks[51], 16);
    public static Tile islandbottgrass = new GrassTile(Images.blocks[57], 17);
    public static Tile islandlftgrass = new GrassTile(Images.blocks[53], 18);
    public static Tile islandrgtgrass = new GrassTile(Images.blocks[55], 19);
    public static Tile islandsand = new GrassTile(Images.blocks[43], 20);    
    public static Tile coastTL = new CoastTile(Images.blocks[35], 21);    
    public static Tile coastTop = new CoastTile(Images.blocks[36], 22);    
    public static Tile coastTR = new CoastTile(Images.blocks[37], 23);    
    public static Tile coastR = new CoastTile(Images.blocks[38], 24);    
    public static Tile coastBR = new CoastTile(Images.blocks[39], 25);    
    public static Tile coastBot = new CoastTile(Images.blocks[40], 26);    
    public static Tile coastBL = new CoastTile(Images.blocks[41], 27);    
    public static Tile coastL = new CoastTile(Images.blocks[42], 28); 
    public static Tile sea = new CoastTile(Images.blocks[59], 29);
    public static Tile Irock = new CoastTile(Images.blocks[60], 30);
    public static Tile Verticalbridge = new GrassTile(Images.blocks[61], 31);
    public static Tile Horizontalbridge = new GrassTile(Images.blocks[62], 32);
    public static Tile uTL = new CoastTile(Images.blocks[27], 33);
    public static Tile uTR = new CoastTile(Images.blocks[29], 34);
    public static Tile uBR = new CoastTile(Images.blocks[31], 35);
    public static Tile uBL = new CoastTile(Images.blocks[33], 36);






    
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
