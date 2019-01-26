package Game.Entities.Statics;

import Game.Entities.Creatures.Koopa;
import Game.Entities.Creatures.Player;
import Game.GameStates.State;
import Game.Items.Item;
import Main.Handler;
import Resources.Images;
import Worlds.BaseWorld;
import Worlds.CaveWorld;
import Worlds.World1;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ToadNPC extends StaticEntity {

	//Phase 4
	public static boolean finalquestcomplete = false;
	public static boolean coins3Delivered = false;
	public static boolean key3Delivered = false;
	public static int coinsneeded = 3;
	public static int keyneeded = 1;
	
    private Rectangle ir = new Rectangle();
    public Boolean EP = false;

    private BaseWorld world;

    public ToadNPC(Handler handler, float x, float y,BaseWorld world) {
        super(handler, x, y, 54,36);
        this.world=world;
        health=10000000;
        bounds.x=0;
        bounds.y=0;
        bounds.width = 100;
        bounds.height = 64;

        ir.width = bounds.width;
        ir.height = bounds.height;
        int irx=(int)(bounds.x-handler.getGameCamera().getxOffset()+x);
        int iry= (int)(bounds.y-handler.getGameCamera().getyOffset()+height);
        ir.y=iry;
        ir.x=irx;
    }

    @Override
    public void tick() {

        if(isBeinghurt()){
            setHealth(10000000);
        }

        if(handler.getKeyManager().attbut){
            EP=true;

        }else if(!handler.getKeyManager().attbut){
            EP=false;
        }
        if (finalquestcomplete == true){
        	State.setState(handler.getGame().victoryState);
	
}
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Images.toad[0],(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);

        g.setColor(Color.black);
        checkForPlayer(g, handler.getWorld().getEntityManager().getPlayer());
    }

    private void checkForPlayer(Graphics g, Player p)
    {

        Rectangle pr = p.getCollisionBounds(0,0);

        //Interaction with player code
        
        //If E is not pressed display that an action is available
        if(ir.contains(pr) && !EP)
        {
            g.drawImage(Images.questbox[2],(int) x+width+10,(int) y+10,113,83,null);
         
         if (!key3Delivered) {
        	 g.drawImage(Images.questnumbers[1],(int) x+132,(int) y+57,24,24,null);
         }
         if (key3Delivered) {
        	 g.drawImage(Images.questnumbers[4],(int) x+132,(int) y+57,24,24,null);
         }
            
            //System.out.println("Contact successful");
        }
        //If E is pressed then 
        else if(ir.contains(pr) && EP)
        {
            //System.out.println("E pressed");
        	//TODO
        	//The image for the quest needs to be added here.
            
			for (Item m: handler.getWorld().getEntityManager().getPlayer().getInventory().getInventoryItems())
			{
				
				if (m.getName().equals("World-3 Key"))
				{
					if (m.getCount() >= 1)
					{
						m.setCount(m.getCount() - 1);
						key3Delivered = true;
					}
				}
			}
			if (key3Delivered)
			{
				//TODO
				//Image needs to be replaced
				g.drawImage(Images.EP,(int) x+width,(int) y+10,32,32,null);
				
				System.out.println("Quest completed successful");
				finalquestcomplete = true;
				//State.setState(handler.getGame().victoryState);
				//handler.getWorld().getEntityManager().addEntity(new Koopa(handler, 100, 100));
				//World1.setIsdoor(true);
				
			}
			else if(!key3Delivered)
			{
				//TODO
				//Add images and dynamic numbers showing what items are still needed for the quest.
				System.out.println("Missing items for quest.");
			}
        }
    }


    @Override
    public void die() {

    }
}
