package Game.Entities.Creatures;

import Game.Entities.EntityBase;
import Game.GameStates.State;
import Game.Inventories.Inventory;
import Game.Items.Item;
import Game.SpellCast.SpellCastUI;
import Resources.Animation;
import Resources.Images;
import Worlds.CaveWorld;
import Worlds.World1;
import Worlds.World3;
import Main.Handler;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Created by Elemental on 1/1/2017.
 */

public class Player extends CreatureBase {

	//Animations
	private Animation animDown, animUp, animLeft, animRight,animFireATT,animFireATTR,animFireATTU,animFireATTD, idleDown, idleUp, idleLeft, idleRight;

	// Attack


	//Inventory
	private Inventory inventory;

	//Debug variable for adding items.
	boolean NoItems = true;

	private SpellCastUI spellGUI;
	
	  private File audioFile;
	    private AudioInputStream audioStream;
	    private AudioFormat format;
	    private DataLine.Info info;
	    private Clip audioClip;


	private int fcounter = 0;
	private Boolean fcactive=true;
	private Boolean FireBall=false;
	private Boolean LaunchedFireBall=false;
	private Boolean LaunchedFireBallL=false;
	private Boolean LaunchedFireBallR=false;
	private Boolean LaunchedFireBallU=false;
	private Boolean LaunchedFireBallD=false;
	private Boolean attacking=false;
	public static boolean luigisummon = false;

	private int animWalkingSpeed = 50;
	private int animFireSpeed = 250;
	private int FireSpeed = 2;
	private int FireMove = 0;
	private int movexp,moveyp,movexn,moveyn,tempmoveyp,tempmovexn,tempmoveyn,tempmovexp,fy,fx;

	//spells



	public Player(Handler handler, float x, float y) {
		super(handler, x, y, 74, 56);

		bounds.x=10;
		bounds.y=37;
		bounds.width=39;
		bounds.height=39;
		health=75;
		this.attack=5;
		this.speed = this.speed*(float)1.5;
		


		animDown = new Animation(animWalkingSpeed,Images.player_front);
		animLeft = new Animation(animWalkingSpeed,Images.player_left);
		animRight = new Animation(animWalkingSpeed,Images.player_right);
		animUp = new Animation(animWalkingSpeed,Images.player_back);

		animFireATT = new Animation(animFireSpeed,Images.FireBallLeft);
		animFireATTR = new Animation(animFireSpeed,Images.FireBallRight);
		animFireATTU = new Animation(animFireSpeed,Images.FireBallUp);
		animFireATTD = new Animation(animFireSpeed,Images.FireBallDown);

		//Idle Animations
		idleDown = new Animation(animWalkingSpeed,Images.marioidle_front);
		idleLeft = new Animation(animWalkingSpeed,Images.marioidle_left);
		idleRight = new Animation(animWalkingSpeed,Images.marioidle_right);
		idleUp = new Animation(animWalkingSpeed,Images.marioidle_back);

		inventory= new Inventory(handler);
		spellGUI= new SpellCastUI(handler);
	}

	@Override
	public void tick() {
		//Animations
		animDown.tick();
		animUp.tick();
		animRight.tick();
		animLeft.tick();
		animFireATT.tick();
		animFireATTR.tick();
		animFireATTU.tick();
		animFireATTD.tick();

		idleDown.tick();
		idleUp.tick();
		idleRight.tick();
		idleLeft.tick();


		//Movement
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);

		if(!fcactive){
			fcounter++;
		}
		if(fcounter>=60){
			fcounter=0;
			fcactive=true;
			FireBall=true;

		}

		if(FireBall){
			FireMove++;
		}


		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_C)){
			readyFireAttack();
		}

		// Attack
		if(handler.getKeyManager().attbut) {
			checkAttacks();
		}else if(handler.getKeyManager().fattbut){

			fireAttack();

		}


		//Inventory
		inventory.tick();

		//spellgui
		spellGUI.tick();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrameIdle(idleDown,idleUp,idleLeft,idleRight, animDown, animUp, animLeft, animRight, Images.marioidle_front,Images.marioidle_back,Images.marioidle_left,Images.marioidle_right), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);

		if(FireBall){
			FireBallAttack(g);

		}




		g.setColor(Color.BLACK);
		g.drawRect((int)(x-handler.getGameCamera().getxOffset()-1),(int)(y-handler.getGameCamera().getyOffset()-21),76,11);
		if(this.getHealth()>50){
			g.setColor(Color.GREEN);
			g.fillRect((int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()-20),getHealth(),10);

		}else if(this.getHealth()>=15 && getHealth()<=50){
			g.setColor(Color.YELLOW);
			g.fillRect((int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()-20),getHealth(),10);

		}else if(this.getHealth() < 15){
			g.setColor(Color.RED);
			g.fillRect((int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()-20),getHealth(),10);

		}
		g.setColor(Color.white);
		g.drawString("Health: " + getHealth(),(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()-10));



	}

	public void readyFireAttack(){
		LaunchedFireBall=true;
		movexp =(int) (x - handler.getGameCamera().getxOffset()) + 48;
		moveyp =(int) (y - handler.getGameCamera().getyOffset()) + 64;
		movexn =(int) (x - handler.getGameCamera().getxOffset()) - 48;
		moveyn =(int) (y - handler.getGameCamera().getyOffset()) - 64;
		tempmovexp =(int) (x - handler.getGameCamera().getxOffset()) + 48;
		tempmoveyp =(int) (y - handler.getGameCamera().getyOffset()) + 64;
		tempmovexn =(int) (x - handler.getGameCamera().getxOffset()) - 48;
		tempmoveyn =(int) (y - handler.getGameCamera().getyOffset()) - 64;
		LaunchedFireBallL=false;
		LaunchedFireBallR=false;
		LaunchedFireBallU=false;
		LaunchedFireBallD=false;
		fy=(int) (y - handler.getGameCamera().getyOffset()) + (height / 2);
		fx=(int) (x - handler.getGameCamera().getxOffset()) + 16;
	}
	public void fireAttack() {

		for (Item i : getInventory().getInventoryItems()) {
			if (i.getName() == "Fire Rune"&&fcactive) {
				attacking=true;
				System.out.println("Burn");
				i.setCount(i.getCount() - 1);
				fcactive=false;
				return;

			}
		}
	}

	@SuppressWarnings("Duplicates")
	@Override
	public void checkAttacks(){
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		if(attackTimer < attackCooldown)
			return;

		Rectangle cb = getCollisionBounds(0, 0);
		Rectangle ar = new Rectangle();
		int arSize = 20;
		ar.width = arSize;
		ar.height = arSize;

		if(lu && handler.getKeyManager().attbut){
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y - arSize;
		}else if(ld && handler.getKeyManager().attbut){
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y + cb.height;
		}else if(ll && handler.getKeyManager().attbut){
			ar.x = cb.x - arSize;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		}else if(lr && handler.getKeyManager().attbut){
			ar.x = cb.x + cb.width;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		}else{
			return;
		}

		attackTimer = 0;

		for(EntityBase e : handler.getWorld().getEntityManager().getEntities()){
			if(e.equals(this))
				continue;
			if(e.getCollisionBounds(0, 0).intersects(ar)){
				e.hurt(attack);
				System.out.println(e + " has " + e.getHealth() + " lives.");
				return;
			}
		}

	}

	@Override
	public void die(){
		System.out.println("You lose");
		State.setState(handler.getGame().gameOverState);
		 try {
             audioFile = new File("res/music/mario-oof.wav");
             audioStream = AudioSystem.getAudioInputStream(audioFile);
             format = audioStream.getFormat();
             info = new DataLine.Info(Clip.class, format);
             audioClip = (Clip) AudioSystem.getLine(info);
	            audioClip.open(audioStream);
	            audioClip.loop(0);

         } catch (UnsupportedAudioFileException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         } catch (LineUnavailableException e) {
             e.printStackTrace();
         }
     }


	//World Debug variable
    int currentWorld = 1;
	
	private void getInput(){
		xMove = 0;
		yMove = 0;

		if(handler.getKeyManager().up &&! attacking)
			yMove = -speed;
		if(handler.getKeyManager().down&&! attacking)
			yMove = speed;
		if(handler.getKeyManager().left&&! attacking)
			xMove = -speed;
		if(handler.getKeyManager().right&&! attacking)
			xMove = speed;

        //Skip World Debug
        int World1 = 1;
        int Cave = 2;
        int World3 = 3;

        if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_TAB))
        {
        	if (currentWorld == World1)
        	{
        		currentWorld = Cave;
        		handler.setWorld(new CaveWorld(this.handler, "res/Maps/caveMap.map", this));
        	}
        	else if (currentWorld == Cave)
        	{
        		currentWorld = World3;
        		handler.setWorld(new World3(this.handler, "res/Maps/map3.map", this));
        	}
        	else if (currentWorld == World3)
        	{
        		//Last World added
        		currentWorld = World1; //Loop back
        		handler.setWorld(new World1(this.handler, "res/Maps/map1.map", this));
        	}
        }

		//Regain Health Debug
		if (handler.getKeyManager().regenhealth) {
			if (health < 75) {
				health++;
				
			}
		}

		//Uses the 1-Up (+health) item
		
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_H)) {
			for (Item e : getInventory().getInventoryItems()) {
				if (e.getName().equals("1-Up")) {
					if (health < 75 && health > 75-10) {
						health = 75;
						e.setCount(e.getCount() - 1);
					}
					else if (health < 75) {
						health += 10;
						e.setCount(e.getCount() - 1);
					}
				}
			}
		}
		
		//Uses the Super Mushroom (+attack) item		
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_J)) {
			for (Item m: getInventory().getInventoryItems()) {
				if (m.getName().equals("Super Mushroom")) {
					handler.getWorld().getEntityManager().getPlayer().attack += 5;
					m.setCount(m.getCount() - 1);
				}
			}
			
		}
		
		//Summons Luigi
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_G)) {
			for (Item l: getInventory().getInventoryItems()) {
				if (l.getName().equals("Luigi Cap")) {
					luigisummon = true;
					l.setCount(l.getCount() - 1);
				}
			}
			
		}
		
		//Add one of each item Debug


		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_X))
		{

			if (NoItems == true)
			{
				handler.getWorld().getEntityManager().getPlayer().getInventory().addItem(Item.fireflower);
				handler.getWorld().getEntityManager().getPlayer().getInventory().addItem(Item.rockItem);
				handler.getWorld().getEntityManager().getPlayer().getInventory().addItem(Item.woodItem);
				handler.getWorld().getEntityManager().getPlayer().getInventory().addItem(Item.coin);
				handler.getWorld().getEntityManager().getPlayer().getInventory().addItem(Item.mushroom);
				handler.getWorld().getEntityManager().getPlayer().getInventory().addItem(Item.oneup);
				handler.getWorld().getEntityManager().getPlayer().getInventory().addItem(Item.world1key);
				handler.getWorld().getEntityManager().getPlayer().getInventory().addItem(Item.luigicap);
				handler.getWorld().getEntityManager().getPlayer().getInventory().addItem(Item.world2key);
				handler.getWorld().getEntityManager().getPlayer().getInventory().addItem(Item.world3key);

				NoItems = false;
			}
			else if (NoItems == false)
			{
				for (Item i : getInventory().getInventoryItems())
				{
					i.setCount(i.getCount() + 1);

					if (i.getCount() == 0)
					{
						NoItems = true;
						
						
					}
				}
			}
		}

	}


	private void FireBallAttack(Graphics g) {


		if (lr&&LaunchedFireBall&&!LaunchedFireBallL&&!LaunchedFireBallR&&!LaunchedFireBallD&&!LaunchedFireBallU) {
			LaunchedFireBall=false;
			LaunchedFireBallL=false;
			LaunchedFireBallR=true;
			LaunchedFireBallU=false;
			LaunchedFireBallD=false;

		} else if (ld&&LaunchedFireBall&&!LaunchedFireBallL&&!LaunchedFireBallR&&!LaunchedFireBallD&&!LaunchedFireBallU) {
			LaunchedFireBall=false;
			LaunchedFireBallL=false;
			LaunchedFireBallR=false;
			LaunchedFireBallU=false;
			LaunchedFireBallD=true;

		} else if (lu&&LaunchedFireBall&&!LaunchedFireBallL&&!LaunchedFireBallR&&!LaunchedFireBallD&&!LaunchedFireBallU) {
			LaunchedFireBall=false;
			LaunchedFireBallL=false;
			LaunchedFireBallR=false;
			LaunchedFireBallU=true;
			LaunchedFireBallD=false;

		} else if(ll&&LaunchedFireBall&&!LaunchedFireBallL&&!LaunchedFireBallR&&!LaunchedFireBallD&&!LaunchedFireBallU) {
			LaunchedFireBall=false;
			LaunchedFireBallL=true;
			LaunchedFireBallR=false;
			LaunchedFireBallU=false;
			LaunchedFireBallD=false;

		}
		if (LaunchedFireBallR) {
			movexp+=FireSpeed;
			g.drawImage(getCurrentFireAnimationFrame(), movexp, fy, 64, 32, null);
			if(movexp >= tempmovexp + 64*2){
				FireBall=false;
				attacking=false;
			}
		} else if (LaunchedFireBallD) {
			moveyp+=FireSpeed;
			g.drawImage(getCurrentFireAnimationFrame(), fx-6, moveyp, 32, 64, null);
			if(moveyp >= tempmoveyp + 64*2){
				FireBall=false;
				attacking=false;
			}
		} else if (LaunchedFireBallU) {
			moveyn-=FireSpeed;
			g.drawImage(getCurrentFireAnimationFrame(), fx, moveyn, 32, 64, null);
			if(moveyn <= tempmoveyn - 64*2){
				FireBall=false;
				attacking=false;
			}
		} else if(LaunchedFireBallL) {   //ll
			movexn-=FireSpeed;
			g.drawImage(getCurrentFireAnimationFrame(), movexn, fy, 64, 32, null);
			if(movexn <= tempmovexn - 64*2){
				FireBall=false;
				attacking=false;
			}
		}





	}

	private BufferedImage getCurrentFireAnimationFrame(){

		if(LaunchedFireBallR){

			return animFireATTR.getCurrentFrame();

		}else if(LaunchedFireBallD){

			return animFireATTD.getCurrentFrame();

		}else if(LaunchedFireBallU){

			return animFireATTU.getCurrentFrame();

		}else{   //ll

			return animFireATT.getCurrentFrame();
		}


	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public SpellCastUI getSpellGUI() {
		return spellGUI;
	}
}