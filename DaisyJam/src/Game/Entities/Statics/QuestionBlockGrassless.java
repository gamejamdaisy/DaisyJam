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
public class QuestionBlockGrassless extends StaticEntity {

    private File audioFile;
    private AudioInputStream audioStream;
    private AudioFormat format;
    private DataLine.Info info;
    private Clip audioClip;
    private Random randint;
    private int RNGR;

    public QuestionBlockGrassless(Handler handler, float x, float y) {
        super(handler, x, y, 64, 64);

        bounds.x=0;
        bounds.y=0;
        bounds.width = 64;
        bounds.height = 64;
        health=10;

        try {
            audioFile = new File("res/music/Pickaxe.wav");
            audioStream = AudioSystem.getAudioInputStream(audioFile);
            format = audioStream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            audioClip = (Clip) AudioSystem.getLine(info);
            audioClip.open(audioStream);



        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void tick() {
        if(isBeinghurt()){
            audioClip.start();
        }
        if(!isBeinghurt() && !handler.getKeyManager().attbut){
            audioClip.stop();
        }
        if(!isActive()){
            audioClip.stop();

        }

    }

    @Override
    public void render(Graphics g) {
        //renderLife(g);
        g.drawImage(Images.blocks[22],(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);

    }

    @Override
    public void die() {
        randint=new Random();
        RNGR=randint.nextInt(3) + 1;
        System.out.println(RNGR);
       
        if(RNGR==1){
            handler.getWorld().getItemManager().addItem(Item.coin.createNew((int)x + bounds.x + (randint.nextInt(32) -32),(int)y + bounds.y+(randint.nextInt(32) -32),(randint.nextInt(3) +1)));
        }
        if(RNGR==2){
            handler.getWorld().getItemManager().addItem(Item.oneup.createNew((int)x + bounds.x + (randint.nextInt(32) -32),(int)y + bounds.y+(randint.nextInt(32) -32),(randint.nextInt(2) +1)));
        }
        if(RNGR==3){
            handler.getWorld().getItemManager().addItem(Item.mushroom.createNew((int)x + bounds.x + (randint.nextInt(32) -32),(int)y + bounds.y+(randint.nextInt(32) -32),(randint.nextInt(2) +1)));
        }

    }
}