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

public class PeachNPC extends StaticEntity {

	//Phase 4
	public static boolean questComplete1 = false;
	public static boolean coins3Delivered = false;
	public static boolean key1Delivered = false;
	public static int coinsneeded = 3;
	public static int keyneeded = 1;
	
    private Rectangle ir = new Rectangle();
    public Boolean EP = false;

    private BaseWorld world;

    public PeachNPC(Handler handler, float x, float y,BaseWorld world) {
        super(handler, x, y, 94, 48);
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

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Images.princesspeach[0],(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);

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
            g.drawImage(Images.questbox[0],(int) x+width+10,(int) y+10,113,83,null);
         if (coinsneeded == 3) {
        	 g.drawImage(Images.questnumbers[3],(int) x+132,(int) y+22,24,24,null);
         }
         if (coinsneeded == 2) {
        	 g.drawImage(Images.questnumbers[2],(int) x+132,(int) y+22,24,24,null);
         }
         if (coinsneeded == 1) {
        	 g.drawImage(Images.questnumbers[1],(int) x+132,(int) y+22,24,24,null);
         }
         if (coins3Delivered) {
        	 g.drawImage(Images.questnumbers[4],(int) x+132,(int) y+22,24,24,null);
         }
         if (!key1Delivered) {
        	 g.drawImage(Images.questnumbers[1],(int) x+132,(int) y+57,24,24,null);
         }
         if (key1Delivered) {
        	 g.drawImage(Images.questnumbers[4],(int) x+132,(int) y+57,24,24,null);
         }
            
            //System.out.println("Contact successful");
        }
        //If E is pressed then 
        else if(ir.contains(pr) && EP)
        {

			for (Item m: handler.getWorld().getEntityManager().getPlayer().getInventory().getInventoryItems())
			{
				System.out.println("For loop entered.");
				if (m.getName().equals("Coin"))
				{
					if (m.getCount() >= 1)
					{
						m.setCount(m.getCount() - 1);
						coinsneeded = coinsneeded - 1;
						//coins3Delivered = true;
					}
				if (coinsneeded == 0) {
					coins3Delivered = true;
				}
				
				}
				if (m.getName().equals("World-1 Key"))
				{
					if (m.getCount() >= 1)
					{
						m.setCount(m.getCount() - 1);
						key1Delivered = true;
					}
				}
			}
			if (coins3Delivered && key1Delivered)
			{

				g.drawImage(Images.EP,(int) x+width,(int) y+10,32,32,null);
				
				System.out.println("Quest completed successful");
				questComplete1 = true;
				
			}
			else if(!coins3Delivered || !key1Delivered)
			{

				System.out.println("Missing items for quest.");
			}
        }
    }


    @Override
    public void die() {

    }
}
