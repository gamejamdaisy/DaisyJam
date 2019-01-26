package Game.Entities.Creatures;

import Game.Entities.EntityBase;
import Game.Inventories.Inventory;
import Game.Items.Item;
import Main.Handler;
import Resources.Animation;
import Resources.Images;

import java.awt.*;
import java.util.Random;

/**
 * Created by Elemental on 2/7/2017.
 */
public class LuigiCompanion extends CreatureBase  {


    private Animation animDown, animUp, animLeft, animRight;

    private Boolean attacking=false;

    private int animWalkingSpeed = 50;
    private Inventory luigiinventory;
    private Rectangle luigicam;

    private int healthcounter = 0;

    private Random randint;
    private int moveCount = 0;
    private int direction;

    public LuigiCompanion(Handler handler, float x, float y) {
        super(handler, x, y, 86, 44);
        bounds.x=4;
        bounds.y=43;
        bounds.width=36;
        bounds.height=43;
        speed=this.speed*(float)1.0;;
        health=45;

        luigicam= new Rectangle();



        randint = new Random();
        direction = randint.nextInt(4) + 1;

        animDown = new Animation(animWalkingSpeed, Images.luigi_front);
        animLeft = new Animation(animWalkingSpeed,Images.luigi_left);
        animRight = new Animation(animWalkingSpeed,Images.luigi_right);
        animUp = new Animation(animWalkingSpeed,Images.luigi_back);
        
        

        luigiinventory= new Inventory(handler);
    }

    @Override
    public void tick() {
        animDown.tick();
        animUp.tick();
        animRight.tick();
        animLeft.tick();
        moveCount ++;
        if(moveCount>=60){
            moveCount=0;
            direction = randint.nextInt(4) + 1;
        }
        checkIfMove();

        move();


        if(isBeinghurt()){
            healthcounter++;
            if(healthcounter>=120){
                setBeinghurt(false);
                System.out.print(isBeinghurt());
            }
        }
        if(healthcounter>=120&& !isBeinghurt()){
            healthcounter=0;
        }


        luigiinventory.tick();


    }


    private void checkIfMove() {
        xMove = 0;
        yMove = 0;

        luigicam.x = (int) (x - handler.getGameCamera().getxOffset() - (64 * 3));
        luigicam.y = (int) (y - handler.getGameCamera().getyOffset() - (64 * 3));
        luigicam.width = 64 * 7;
        luigicam.height = 64 * 7;

        if (luigicam.contains(handler.getWorld().getEntityManager().getPlayer().getX() - handler.getGameCamera().getxOffset(), handler.getWorld().getEntityManager().getPlayer().getY() - handler.getGameCamera().getyOffset())
                || luigicam.contains(handler.getWorld().getEntityManager().getPlayer().getX() - handler.getGameCamera().getxOffset() + handler.getWorld().getEntityManager().getPlayer().getWidth(), handler.getWorld().getEntityManager().getPlayer().getY() - handler.getGameCamera().getyOffset() + handler.getWorld().getEntityManager().getPlayer().getHeight())) {

            Rectangle cb = getCollisionBounds(0, 0);
            Rectangle ar = new Rectangle();
            int arSize = 13;
            ar.width = arSize;
            ar.height = arSize;

            if (lu) {
                ar.x = cb.x + cb.width / 2 - arSize / 2;
                ar.y = cb.y - arSize;
            } else if (ld) {
                ar.x = cb.x + cb.width / 2 - arSize / 2;
                ar.y = cb.y + cb.height;
            } else if (ll) {
                ar.x = cb.x - arSize;
                ar.y = cb.y + cb.height / 2 - arSize / 2;
            } else if (lr) {
                ar.x = cb.x + cb.width;
                ar.y = cb.y + cb.height / 2 - arSize / 2;
            }

            for (EntityBase e : handler.getWorld().getEntityManager().getEntities()) {
                if (e.equals(this))
                    continue;
                if (e.getCollisionBounds(0, 0).intersects(ar) && !(e.equals(handler.getWorld().getEntityManager().getPlayer()))) {

                    checkAttacks();
                    return;
                }
            }


            if (x >= handler.getWorld().getEntityManager().getPlayer().getX() - 8 && x <= handler.getWorld().getEntityManager().getPlayer().getX() + 8) {//nada

                xMove = 0;
            } else if (x < handler.getWorld().getEntityManager().getPlayer().getX()) {//move right

                xMove = speed;

            } else if (x > handler.getWorld().getEntityManager().getPlayer().getX()) {//move left

                xMove = -speed;
            }

            if (y >= handler.getWorld().getEntityManager().getPlayer().getY() - 8 && y <= handler.getWorld().getEntityManager().getPlayer().getY() + 8) {//nada
                yMove = 0;
            } else if (y < handler.getWorld().getEntityManager().getPlayer().getY()) {//move down
                yMove = speed;

            } else if (y > handler.getWorld().getEntityManager().getPlayer().getY()) {//move up
                yMove = -speed;
            }


        } else {


            switch (direction) {
                case 1://up
                    yMove = -speed;
                    break;
                case 2://down
                    yMove = speed;
                    break;
                case 3://left
                    xMove = -speed;
                    break;
                case 4://right
                    xMove = speed;
                    break;

            }
        }
    }


    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(animDown,animUp,animLeft,animRight, Images.luigi_front,Images.luigi_back,Images.luigi_left,Images.luigi_right), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
        if(isBeinghurt() && healthcounter<=120){
            g.setColor(Color.white);
            g.drawString("Health: " + getHealth(),(int) (x-handler.getGameCamera().getxOffset()),(int) (y-handler.getGameCamera().getyOffset()-20));
        }
    }




    @Override
    //THIS IS AN ITEM EXAMPLE
    public void die() {
    	handler.getWorld().getItemManager().addItem(Item.world1key.createNew((int)x + bounds.x,(int)y + bounds.y,1));

    }
}
