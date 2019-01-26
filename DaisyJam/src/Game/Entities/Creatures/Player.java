package Game.Entities.Creatures;

import Game.Entities.EntityBase;
import Game.GameStates.State;
import Game.Inventories.Inventory;
import Game.Items.Item;

import Resources.Animation;
import Resources.Images;
import Worlds.CaveWorld;
import Worlds.World1;
import Worlds.World3;
import Main.Game;
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

public class Player extends CreatureBase {

	//Animations
	private Animation animDown, animUp, animLeft, animRight;

	// Attack


	//Inventory
	private Inventory inventory;

	//Debug variable for adding items.
	boolean NoItems = true;

	private File audioFile;
	private AudioInputStream audioStream;
	private AudioFormat format;
	private DataLine.Info info;
	private Clip audioClip;
 
	private Boolean attacking=false;
	
	public int World1 = 1;
	public int Cave = 2;
	public int World3 = 3;

	private int animWalkingSpeed = 50;
	private int animFireSpeed = 250; 
	private int movexp,moveyp,movexn,moveyn,tempmoveyp,tempmovexn,tempmoveyn,tempmovexp,fy,fx;

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, 94, 48);

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
		
		inventory= new Inventory(handler);
	}

	@Override
	public void tick() {
		//Animations
		animDown.tick();
		animUp.tick();
		animRight.tick();
		animLeft.tick();

		//Movement
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);

		// Attack
		if(handler.getKeyManager().attbut) {
			checkAttacks();
		}
		
		//Inventory
		inventory.tick();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(animDown, animUp, animLeft, animRight, Images.player_front,Images.player_back,Images.player_left,Images.player_right), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);

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
	public int currentWorld = 1;

	public int getCurrentWorld() {
		return currentWorld;
	}

	public int getWorld1() {
		return World1;
	}

	public void setWorld1(int world1) {
		World1 = world1;
	}

	public int getCave() {
		return Cave;
	}

	public void setCave(int cave) {
		Cave = cave;
	}

	public int getWorld3() {
		return World3;
	}

	public void setWorld3(int world3) {
		World3 = world3;
	}

	public void setCurrentWorld(int currentWorld) {
		this.currentWorld = currentWorld;
	}

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

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
}