package Resources;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Images {
	private static final int width = 48, height = 94;    //Daisy W/H

	private static final int iwidth = 32, iheight = 32;  //Item W/H

	private static final int Bwidth = 64, Bheight = 64;  //Tiles W/H
	private static final int Rwidth = 56, Rheight = 93;
	private static final int Fwidth = 512, Fheight = 197;

	public static BufferedImage[] blocks;

	//Daisy Moving
	public static BufferedImage[] player_right;
	public static BufferedImage[] player_left;
	public static BufferedImage[] player_front;
	public static BufferedImage[] player_back;

	//Idle Mario Variables
	public static BufferedImage[] marioidle_right;
	public static BufferedImage[] marioidle_left;
	public static BufferedImage[] marioidle_front;
	public static BufferedImage[] marioidle_back;

	//Luigi
	public static BufferedImage[] luigi_right;
	public static BufferedImage[] luigi_left;
	public static BufferedImage[] luigi_front;
	public static BufferedImage[] luigi_back;

	//Bowser
	public static BufferedImage[] bowser_right;
	public static BufferedImage[] bowser_left;
	public static BufferedImage[] bowser_front;
	public static BufferedImage[] bowser_back;

	//Goomba
	public static BufferedImage[] goomba_right;
	public static BufferedImage[] goomba_left;
	public static BufferedImage[] goomba_front;
	public static BufferedImage[] goomba_back;

	//Koopa
	public static BufferedImage[] koopa_right;
	public static BufferedImage[] koopa_left;
	public static BufferedImage[] koopa_front;
	public static BufferedImage[] koopa_back;

	//Koopa
	public static BufferedImage[] drybones_right;
	public static BufferedImage[] drybones_left;
	public static BufferedImage[] drybones_front;
	public static BufferedImage[] drybones_back;

	//Chain Chomp
	public static BufferedImage[] chain_right;
	public static BufferedImage[] chain_left;
	public static BufferedImage[] chain_front;
	public static BufferedImage[] chain_back;

	//Princess Peach
	public static BufferedImage[] princesspeach;
	public static BufferedImage[] yoshi;
	public static BufferedImage[] toad;

	//Quest UI
	//Box
	public static BufferedImage[]questbox;
	public static BufferedImage[] questnumbers;

	public static BufferedImage[] butstart;
	public static BufferedImage[] particleSmoke;
	public static BufferedImage[] items;
	public static BufferedImage[] numbers;
	public static BufferedImage inventory;
	public static BufferedImage title;
	public static BufferedImage door;
	public static BufferedImage E;
	public static BufferedImage EP;
	public static BufferedImage Pause;
	public static BufferedImage HealthBar;
	public static BufferedImage GameOver;
	public static BufferedImage Victory;
	public static BufferedImage[] Resume;
	public static BufferedImage[] BTitle;
	public static BufferedImage[] Options;
	public static BufferedImage[] Runes;
	public static ImageIcon icon;
	public static BufferedImage[] FireBallLeft;
	public static BufferedImage[] FireBallRight;
	public static BufferedImage[] FireBallUp;
	public static BufferedImage[] FireBallDown;
	public static BufferedImage loading;
	public static BufferedImage spellGUI;
	public static BufferedImage IntroScreen;

	public static BufferedImage[] fountain;
	public static BufferedImage[] drystatue;
	public static BufferedImage[] firepillar;

	public static BufferedImage[] startButtons;
	public static BufferedImage[] exitButtons;
	public static BufferedImage pipe;


	public Images() {

		SpriteSheet newsheet = new SpriteSheet(Images.loadImage("/Sheets/SpriteSheet.png"));
		SpriteSheet numsheet = new SpriteSheet(Images.loadImage("/Sheets/NumberSheet.png"));
		SpriteSheet runesheet = new SpriteSheet(Images.loadImage("/Sheets/runes.png"));
		SpriteSheet FireBallsheet = new SpriteSheet(Images.loadImage("/Sheets/FireBall.png"));
		SpriteSheet FireBallRightsheet = new SpriteSheet(Images.loadImage("/Sheets/FireBallRight.png"));
		SpriteSheet FireBallUpsheet = new SpriteSheet(Images.loadImage("/Sheets/FireBallUp.png"));
		SpriteSheet FireBallDownsheet = new SpriteSheet(Images.loadImage("/Sheets/FireBallDown.png"));

		//Added sheets:
		SpriteSheet mariorun = new SpriteSheet(Images.loadImage("/Sheets/MarioSheet.png"));
		SpriteSheet goombasheet = new SpriteSheet(Images.loadImage("/Sheets/GoombaSheet.png"));
		SpriteSheet peachtiles = new SpriteSheet(Images.loadImage("/Sheets/PeachTiles.png"));
		SpriteSheet inventorysheet = new SpriteSheet(Images.loadImage("/Sheets/InventoryItems.png"));
		SpriteSheet fountainsheet = new SpriteSheet(Images.loadImage("/Sheets/FountainSheet.png"));
		SpriteSheet statuesheet = new SpriteSheet(Images.loadImage("/Sheets/StatueSheet.png"));
		SpriteSheet npcsheet = new SpriteSheet(Images.loadImage("/Sheets/NPCSheet.png")); 
		SpriteSheet koopasheet = new SpriteSheet(Images.loadImage("/Sheets/KoopaSheet.png"));
		SpriteSheet deserttiles = new SpriteSheet(Images.loadImage("/Sheets/DesertTiles.png"));
		SpriteSheet drybonesstatue = new SpriteSheet(Images.loadImage("/Sheets/DryBonesStatue.png"));
		SpriteSheet chainchompsheet = new SpriteSheet(Images.loadImage("/Sheets/ChainChompSheet.png"));
		SpriteSheet drybonessheet = new SpriteSheet(Images.loadImage("/Sheets/DryBonesSheet.png"));
		SpriteSheet luigisheet = new SpriteSheet(Images.loadImage("/Sheets/LuigiSheet.png"));
		SpriteSheet firepillarsheet = new SpriteSheet(Images.loadImage("/Sheets/FirePillar.png"));
		SpriteSheet bowsertiles = new SpriteSheet(Images.loadImage("/Sheets/BowserTiles.png"));
		SpriteSheet quest1sheet = new SpriteSheet(Images.loadImage("/Sheets/Quest1UI.png"));
		SpriteSheet bowsersheet = new SpriteSheet(Images.loadImage("/Sheets/BowserSheet.png"));
		SpriteSheet quest2sheet = new SpriteSheet(Images.loadImage("/Sheets/Quest2UI.png"));
		SpriteSheet quest3sheet = new SpriteSheet(Images.loadImage("/Sheets/Quest3UI.png"));

		//Game Jam Added Sheets
		SpriteSheet daisysheet = new SpriteSheet(Images.loadImage("/Sheets/Playable_Characters/DaisySheet.png"));
		SpriteSheet menubuttonssheet = new SpriteSheet(Images.loadImage("/Buttons/MenuButtons.png"));

		SpriteSheet pipestuff = new SpriteSheet(Images.loadImage("/Sheets/BluePipe.png"));
		SpriteSheet islandsheet = new SpriteSheet(Images.loadImage("/Sheets/islandSheet.png"));
		SpriteSheet stairs = new SpriteSheet(Images.loadImage("/Sheets/stairs.png"));




		blocks = new BufferedImage[256];

		//Changed values

		player_left = new BufferedImage[8];
		player_right = new BufferedImage[8];
		player_front = new BufferedImage[8];
		player_back = new BufferedImage[8];

		//Added these
		marioidle_left = new BufferedImage[1];
		marioidle_right = new BufferedImage[1];
		marioidle_front = new BufferedImage[1];
		marioidle_back = new BufferedImage[1];


		goomba_left = new BufferedImage[8];
		goomba_right = new BufferedImage[8];
		goomba_front = new BufferedImage[8];
		goomba_back = new BufferedImage[8];

		//Koopa
		koopa_left = new BufferedImage[8];
		koopa_right = new BufferedImage[8];
		koopa_front = new BufferedImage[8];
		koopa_back = new BufferedImage[8];

		//Luigi
		luigi_left = new BufferedImage[8];
		luigi_right = new BufferedImage[8];
		luigi_front = new BufferedImage[8];
		luigi_back = new BufferedImage[8];

		//Dry Bones
		drybones_left = new BufferedImage[8];
		drybones_right = new BufferedImage[8];
		drybones_front = new BufferedImage[8];
		drybones_back = new BufferedImage[8];

		//Chain
		chain_left = new BufferedImage[4];
		chain_right = new BufferedImage[4];
		chain_front = new BufferedImage[4];
		chain_back = new BufferedImage[4];

		//Bowser
		bowser_left = new BufferedImage[16];
		bowser_right = new BufferedImage[16];
		bowser_front = new BufferedImage[16];
		bowser_back = new BufferedImage[16];

		//Peach
		princesspeach = new BufferedImage[4];

		yoshi = new BufferedImage[4];
		toad = new BufferedImage[4];

		butstart = new BufferedImage[3];
		particleSmoke = new BufferedImage[3];
		items = new BufferedImage[256];
		numbers = new BufferedImage[21];
		Resume = new BufferedImage[2];
		BTitle = new BufferedImage[2];
		Options = new BufferedImage[2];
		Runes = new BufferedImage[36];

		//Fountain
		fountain = new BufferedImage[3];

		drystatue = new BufferedImage[6];

		firepillar = new BufferedImage[6];

		FireBallLeft = new BufferedImage[6];
		FireBallRight = new BufferedImage[6];
		FireBallUp = new BufferedImage[6];
		FireBallDown = new BufferedImage[6];

		questnumbers = new BufferedImage[5];
		questbox = new BufferedImage[3];

		startButtons = new BufferedImage[3];
		exitButtons = new BufferedImage[3];


		try {

			loading = ImageIO.read(getClass().getResourceAsStream("/Sheets/loading.png"));
			spellGUI = ImageIO.read(getClass().getResourceAsStream("/Sheets/SpellGUI.png"));

			inventory = ImageIO.read(getClass().getResourceAsStream("/Sheets/guit.png"));
			title = ImageIO.read(getClass().getResourceAsStream("/Sheets/MenuScreen.jpg"));

			//New Door
			door = peachtiles.crop(2,216,80,84);

			E = ImageIO.read(getClass().getResourceAsStream("/Buttons/E.png"));
			EP = ImageIO.read(getClass().getResourceAsStream("/Buttons/EP.png"));
			Pause = ImageIO.read(getClass().getResourceAsStream("/Sheets/PauseState.png"));
			Resume[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/Resume.png"));
			Resume[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/ResumeP.png"));
			BTitle[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/BTitle.png"));
			BTitle[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/BTitleP.png"));
			Options[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/Options.png"));
			Options[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/OptionsP.png"));
			HealthBar = ImageIO.read(getClass().getResourceAsStream("/Buttons/HealthBar.png"));

			GameOver = ImageIO.read(getClass().getResourceAsStream("/Sheets/GameOverState.png"));
			Victory = ImageIO.read(getClass().getResourceAsStream("/Sheets/VictoryState.png"));
			IntroScreen = ImageIO.read(getClass().getResourceAsStream("/Sheets/IntroCutscene.png"));


			startButtons[0]= menubuttonssheet.crop(1,1,136,28);
			startButtons[1]= menubuttonssheet.crop(1,30,136,28);
			startButtons[2]= menubuttonssheet.crop(1,59,136,28);

			exitButtons[0]= menubuttonssheet.crop(1,88,72,22);
			exitButtons[1]= menubuttonssheet.crop(1,111,72,22);
			exitButtons[2]= menubuttonssheet.crop(1,134,72,22);

			pipe = pipestuff.crop(1, 1, 134,80);

			//icon
			icon = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/Sheets/MushroomIcon.png")));

			//fireball left
			FireBallLeft[0]= FireBallsheet.crop(Fwidth*0,Fheight*0,Fwidth,Fheight);
			FireBallLeft[1]= FireBallsheet.crop(Fwidth*1,Fheight*0,Fwidth,Fheight);
			FireBallLeft[2]= FireBallsheet.crop(Fwidth*2,Fheight*0,Fwidth,Fheight);
			FireBallLeft[3]= FireBallsheet.crop(Fwidth*0,Fheight*1,Fwidth,Fheight);
			FireBallLeft[4]= FireBallsheet.crop(Fwidth*1,Fheight*1,Fwidth,Fheight);
			FireBallLeft[5]= FireBallsheet.crop(Fwidth*2,Fheight*1,Fwidth,Fheight);

			//fireball right
			FireBallRight[0]= FireBallRightsheet.crop(Fwidth*0,Fheight*0,Fwidth,Fheight);
			FireBallRight[1]= FireBallRightsheet.crop(Fwidth*1,Fheight*0,Fwidth,Fheight);
			FireBallRight[2]= FireBallRightsheet.crop(Fwidth*2,Fheight*0,Fwidth,Fheight);
			FireBallRight[3]= FireBallRightsheet.crop(Fwidth*0,Fheight*1,Fwidth,Fheight);
			FireBallRight[4]= FireBallRightsheet.crop(Fwidth*1,Fheight*1,Fwidth,Fheight);
			FireBallRight[5]= FireBallRightsheet.crop(Fwidth*2,Fheight*1,Fwidth,Fheight);

			//fireball up
			FireBallUp[0]= FireBallUpsheet.crop(Fheight*1,Fwidth*0,Fheight,Fwidth);
			FireBallUp[1]= FireBallUpsheet.crop(Fheight*1,Fwidth*1,Fheight,Fwidth);
			FireBallUp[2]= FireBallUpsheet.crop(Fheight*1,Fwidth*2,Fheight,Fwidth);
			FireBallUp[3]= FireBallUpsheet.crop(Fheight*0,Fwidth*0,Fheight,Fwidth);
			FireBallUp[4]= FireBallUpsheet.crop(Fheight*0,Fwidth*1,Fheight,Fwidth);
			FireBallUp[5]= FireBallUpsheet.crop(Fheight*0,Fwidth*2,Fheight,Fwidth);

			//fireball down
			FireBallDown[0]= FireBallDownsheet.crop(Fheight*1,Fwidth*0,Fheight,Fwidth);
			FireBallDown[1]= FireBallDownsheet.crop(Fheight*1,Fwidth*1,Fheight,Fwidth);
			FireBallDown[2]= FireBallDownsheet.crop(Fheight*1,Fwidth*2,Fheight,Fwidth);
			FireBallDown[3]= FireBallDownsheet.crop(Fheight*0,Fwidth*0,Fheight,Fwidth);
			FireBallDown[4]= FireBallDownsheet.crop(Fheight*0,Fwidth*1,Fheight,Fwidth);
			FireBallDown[5]= FireBallDownsheet.crop(Fheight*0,Fwidth*2,Fheight,Fwidth);

			Runes[0]= runesheet.crop(Rwidth*0,Rheight*0,Rwidth,Rheight);//Runes
			Runes[1]= runesheet.crop(Rwidth*1,Rheight*0,Rwidth,Rheight);
			Runes[2]= runesheet.crop(Rwidth*2,Rheight*0,Rwidth,Rheight);
			Runes[3]= runesheet.crop(Rwidth*3,Rheight*0,Rwidth,Rheight);
			Runes[4]= runesheet.crop(Rwidth*4,Rheight*0,Rwidth,Rheight);
			Runes[5]= runesheet.crop(Rwidth*5,Rheight*0,Rwidth,Rheight);
			Runes[6]= runesheet.crop(Rwidth*6,Rheight*0,Rwidth,Rheight);
			Runes[7]= runesheet.crop(Rwidth*7,Rheight*0,Rwidth,Rheight);


			blocks[0] = ImageIO.read(getClass().getResourceAsStream("/Blocks/Slime.png"));

			butstart[0]= newsheet.crop(11,422,93,34);//normbut
			butstart[1]= newsheet.crop(11,456,93,33);//hoverbut
			butstart[2]= newsheet.crop(11,489,93,32);//clickbut

			particleSmoke[0]= newsheet.crop(111,397,18,38);
			particleSmoke[1]= newsheet.crop(129,399,20,35);
			particleSmoke[2]= newsheet.crop(154,400,20,35);

			//Items
			items[0]= inventorysheet.crop(274,70,iwidth,iheight); //Wood
			items[1]= inventorysheet.crop(2,36,iwidth,iheight);   //Rock
			items[2]= inventorysheet.crop(172,36,iwidth,iheight); //Fire Flower (Rune)
			items[3]= inventorysheet.crop(104,2,iwidth,iheight);  //Coin
			items[4]= inventorysheet.crop(2,2,iwidth,iheight);    //Super Mushroom (+Attack)
			items[5]= inventorysheet.crop(36,2,iwidth,iheight);   //1-Up (+Health)
			items[6]= inventorysheet.crop(274,36,iwidth,iheight); //World 1 Key
			items[7]= inventorysheet.crop(70,36,iwidth,iheight);  //Luigi Summon Item
			items[8]= inventorysheet.crop(342,36,iwidth,iheight); //World 2 Key
			items[9]= inventorysheet.crop(308,2,iwidth,iheight);  //World 3 Key


			//Quest
			//Quest 1
			questbox[0] = quest1sheet.crop(1, 1, 113, 83);
			questbox[1] = quest2sheet.crop(1, 1, 113, 83);
			questbox[2] = quest3sheet.crop(1, 1, 113, 83);

			//Numbers

			questnumbers[0] = quest1sheet.crop(116, 2, 24, 24);
			questnumbers[1] = quest1sheet.crop(143, 2, 24, 24);
			questnumbers[2] = quest1sheet.crop(170, 2, 24, 24);
			questnumbers[3] = quest1sheet.crop(197, 2, 24, 24);
			questnumbers[4] = quest1sheet.crop(170, 29, 24, 24);

			//Updated Number Sprites
			numbers[1]= numsheet.crop(2,2,32,22);
			numbers[2]= numsheet.crop(36,2,32,22);
			numbers[3]= numsheet.crop(70,2,32,22);
			numbers[4]= numsheet.crop(104,2,32,22);
			numbers[5]= numsheet.crop(2,26,32,22);
			numbers[6]= numsheet.crop(36,26,32,22);
			numbers[7]= numsheet.crop(70,26,32,22);
			numbers[8]= numsheet.crop(104,26,32,22);
			numbers[9]= numsheet.crop(2,50,32,22);
			numbers[10]= numsheet.crop(36,50,32,22);
			numbers[11]= numsheet.crop(70,50,32,22);
			numbers[12]= numsheet.crop(104,50,32,22);
			numbers[13]= numsheet.crop(2,74,32,22);
			numbers[14]= numsheet.crop(36,74,32,22);
			numbers[15]= numsheet.crop(70,74,32,22);
			numbers[16]= numsheet.crop(104,74,32,22);
			numbers[17]= numsheet.crop(2,98,32,22);
			numbers[18]= numsheet.crop(36,98,32,22);
			numbers[19]= numsheet.crop(70,98,32,22);
			numbers[20]= numsheet.crop(104,98,32,22);


			//block images,array index is equal to block id

			//World 1 (Peach Garden)
			//New Grass Tiles
			blocks[1] = peachtiles.crop(2,2,Bwidth,Bheight); //Empty Grass
			blocks[2] = peachtiles.crop(68,2,Bwidth,Bheight); //1 Grass
			blocks[3] = peachtiles.crop(134,2,Bwidth,Bheight); //2 Grass
			blocks[4] = peachtiles.crop(200,2,Bwidth,Bheight); //1 Flower
			blocks[5] = peachtiles.crop(266,2,Bwidth,Bheight); //2 Flowers

			//Castle Tiles Brought down to just one
			blocks[6] = peachtiles.crop(332,2,Bwidth,Bheight); //Peach Castle Wall

			//New Tree
			blocks[7] = peachtiles.crop(332,68,144,182); //Tree

			//Bricks replace moss rocks
			blocks[8] = peachtiles.crop(398,2,Bwidth,Bheight); //Regular Brick
			blocks[9] = peachtiles.crop(464,2,Bwidth,Bheight); //Empty Block
			blocks[10] = peachtiles.crop(530,2,Bwidth,Bheight); //? Block

			//Rocks 
			blocks[11] = peachtiles.crop(2,68,Bwidth,72);

			//Lamp post
			blocks[12] = fountainsheet.crop(656,2,52,166);

			//Peach Statue
			blocks[13] = statuesheet.crop(2,2,104,236);

			//Bushes
			blocks[14] = peachtiles.crop(478,68,60,224); //Long Bush
			blocks[15] = peachtiles.crop(540,68,60,128); //Short Bush

			//World 2 (Desert)
			blocks[16] = deserttiles.crop(2,2,Bwidth,Bheight);      //Desert "grass"
			blocks[17] = deserttiles.crop(68,2,Bwidth,Bheight);     //Desert "Walls"
			blocks[18] = deserttiles.crop(134,2,Bwidth,Bheight);    //Empty Block (No Grass)
			blocks[19] = deserttiles.crop(2,68,134,230);            //Cactus
			blocks[20] = deserttiles.crop(138,68,64,160);           //Short Desert Pillar
			blocks[21] = deserttiles.crop(204,68,64,320);           //Long Desert Pillar	
			blocks[22] = deserttiles.crop(200,2,Bwidth,Bheight);    //? Block (No Grass)

			//Bowser World
			blocks[23] = bowsertiles.crop(1,1,Bwidth,Bheight);       //Bowser Floor
			blocks[24] = bowsertiles.crop(66,1,Bwidth,Bheight);     //Bowser Walls
			blocks[25] = bowsertiles.crop(131,1,Bwidth,Bheight);    //Luigi Block
			blocks[26] = ImageIO.read(getClass().getResourceAsStream("/Sheets/bowserlogo.png"));   //Logo  floor

			//Island World
			//Coastline
			blocks[27] = islandsheet.crop(0, 0, Bwidth, Bheight);
			blocks[28] = islandsheet.crop(64, 0, Bwidth, Bheight);
			blocks[29] = islandsheet.crop(128, 0, Bwidth, Bheight);
			blocks[30] = islandsheet.crop(128, 64, Bwidth, Bheight);
			blocks[31] = islandsheet.crop(128, 128, Bwidth, Bheight);
			blocks[32] = islandsheet.crop(64, 128, Bwidth, Bheight);
			blocks[33] = islandsheet.crop(0, 128, Bwidth, Bheight);
			blocks[34] = islandsheet.crop(0, 64, Bwidth, Bheight);
			blocks[35] = islandsheet.crop(192, 0, Bwidth, Bheight);
			blocks[36] = islandsheet.crop(256, 0, Bwidth, Bheight);
			blocks[37] = islandsheet.crop(320, 0, Bwidth, Bheight);
			blocks[38] = islandsheet.crop(320, 64, Bwidth, Bheight);
			blocks[39] = islandsheet.crop(320, 128, Bwidth, Bheight);
			blocks[40] = islandsheet.crop(256, 128, Bwidth, Bheight);
			blocks[41] = islandsheet.crop(192, 128, Bwidth, Bheight);
			blocks[42] = islandsheet.crop(192, 64, Bwidth, Bheight);

			//island ground
			blocks[43] = islandsheet.crop(448, 0, Bwidth, Bheight);
			blocks[44] = islandsheet.crop(384, 0, Bwidth, Bheight);
			blocks[45] = islandsheet.crop(448, 0, Bwidth, Bheight);
			blocks[46] = islandsheet.crop(384, 64, Bwidth, Bheight);
			blocks[47] = islandsheet.crop(448, 64, Bwidth, Bheight);
			blocks[48] = islandsheet.crop(384, 128, Bwidth, Bheight);
			blocks[49] = islandsheet.crop(448, 128, Bwidth, Bheight);
			blocks[50] = islandsheet.crop(0,  192, Bwidth, Bheight);
			blocks[51] = islandsheet.crop(64, 192, Bwidth, Bheight);
			blocks[52] = islandsheet.crop(128, 192, Bwidth, Bheight);
			blocks[53] = islandsheet.crop(0, 256, Bwidth, Bheight);
			blocks[54] = islandsheet.crop(64, 256, Bwidth, Bheight);
			blocks[55] = islandsheet.crop(128, 256, Bwidth, Bheight);
			blocks[56] = islandsheet.crop(0, 320, Bwidth, Bheight);
			blocks[57] = islandsheet.crop(64, 320, Bwidth, Bheight);
			blocks[58] = islandsheet.crop(128, 320, Bwidth, Bheight);

			//Water related
			blocks[59] = islandsheet.crop(64, 64, Bwidth, Bheight); //water surface
			blocks[60] = islandsheet.crop(512, 0, Bwidth, Bheight); //rock in water

			//Stairs
			blocks[61] = stairs.crop(0, 0, Bwidth, Bheight);
			blocks[62] = stairs.crop(64, 0, Bwidth, Bheight);


			//Fountain
			fountain[0] = fountainsheet.crop(2,2,216,226);
			fountain[1] = fountainsheet.crop(220,2,216,226);
			fountain[2] = fountainsheet.crop(438,2,216,226);

			//Dry Bones Statue
			drystatue[0] = drybonesstatue.crop(2,2,134,262);
			drystatue[1] = drybonesstatue.crop(138,2,134,262);
			drystatue[2] = drybonesstatue.crop(274,2,134,262);
			drystatue[3] = drybonesstatue.crop(410,2,134,262);
			drystatue[4] = drybonesstatue.crop(546,2,134,262);
			drystatue[5] = drybonesstatue.crop(682,2,134,262);

			//Fire Pillar
			firepillar[0] = firepillarsheet.crop(2,2,124,370);
			firepillar[1] = firepillarsheet.crop(128,2,124,370);
			firepillar[2] = firepillarsheet.crop(254,2,124,370);
			firepillar[3] = firepillarsheet.crop(380,2,124,370);
			firepillar[4] = firepillarsheet.crop(506,2,124,370);
			firepillar[5] = firepillarsheet.crop(632,2,124,370);

			//Mario Animations
			player_front[0]=daisysheet.crop(2,2,width,height);
			player_front[1]=daisysheet.crop(52,2,width,height);
			player_front[2]=daisysheet.crop(102,2,width,height);
			player_front[3]=daisysheet.crop(152,2,width,height);
			player_front[4]=daisysheet.crop(202,2,width,height);
			player_front[5]=daisysheet.crop(252,2,width,height);
			player_front[6]=daisysheet.crop(302,2,width,height);
			player_front[7]=daisysheet.crop(352,2,width,height);

			player_left[0]=daisysheet.crop(2,98,width,height);
			player_left[1]=daisysheet.crop(52,98,width,height);
			player_left[2]=daisysheet.crop(102,98,width,height);
			player_left[3]=daisysheet.crop(152,98,width,height);
			player_left[4]=daisysheet.crop(202,98,width,height);
			player_left[5]=daisysheet.crop(252,98,width,height);
			player_left[6]=daisysheet.crop(302,98,width,height);
			player_left[7]=daisysheet.crop(352,98,width,height);

			player_right[0]=daisysheet.crop(2,194,width,height);
			player_right[1]=daisysheet.crop(52,194,width,height);
			player_right[2]=daisysheet.crop(102,194,width,height);
			player_right[3]=daisysheet.crop(152,194,width,height);
			player_right[4]=daisysheet.crop(202,194,width,height);
			player_right[5]=daisysheet.crop(252,194,width,height);
			player_right[6]=daisysheet.crop(302,194,width,height);
			player_right[7]=daisysheet.crop(352,194,width,height);

			player_back[0]=daisysheet.crop(2,290,width,height);
			player_back[1]=daisysheet.crop(52,290,width,height);
			player_back[2]=daisysheet.crop(102,290,width,height);
			player_back[3]=daisysheet.crop(152,290,width,height);
			player_back[4]=daisysheet.crop(202,290,width,height);
			player_back[5]=daisysheet.crop(252,290,width,height);
			player_back[6]=daisysheet.crop(302,290,width,height);
			player_back[7]=daisysheet.crop(352,290,width,height);

			//Mario Idle "Animations"
			marioidle_back[0]=mariorun.crop(2,306,width,height);
			marioidle_right[0]=mariorun.crop(60,306,width,height);
			marioidle_front[0]=mariorun.crop(118,306,width,height);
			marioidle_left[0]=mariorun.crop(176,306,width,height);

			//Enemies

			//Goomba Animations
			goomba_front[0]=goombasheet.crop(2,2,44,48);
			goomba_front[1]=goombasheet.crop(48,2,44,48);
			goomba_front[2]=goombasheet.crop(94,2,44,48);
			goomba_front[3]=goombasheet.crop(140,2,44,48);
			goomba_front[4]=goombasheet.crop(186,2,44,48);
			goomba_front[5]=goombasheet.crop(232,2,44,48);
			goomba_front[6]=goombasheet.crop(278,2,44,48);
			goomba_front[7]=goombasheet.crop(324,2,44,48);

			goomba_left[0]=goombasheet.crop(2,52,44,48);
			goomba_left[1]=goombasheet.crop(48,52,44,48);
			goomba_left[2]=goombasheet.crop(94,52,44,48);
			goomba_left[3]=goombasheet.crop(140,52,44,48);
			goomba_left[4]=goombasheet.crop(186,52,44,48);
			goomba_left[5]=goombasheet.crop(232,52,44,48);
			goomba_left[6]=goombasheet.crop(278,52,44,48);
			goomba_left[7]=goombasheet.crop(324,52,44,48);

			goomba_right[0]=goombasheet.crop(2,102,44,48);
			goomba_right[1]=goombasheet.crop(48,102,44,48);
			goomba_right[2]=goombasheet.crop(94,102,44,48);
			goomba_right[3]=goombasheet.crop(140,102,44,48);
			goomba_right[4]=goombasheet.crop(186,102,44,48);
			goomba_right[5]=goombasheet.crop(232,102,44,48);
			goomba_right[6]=goombasheet.crop(278,102,44,48);
			goomba_right[7]=goombasheet.crop(324,102,44,48);

			goomba_back[0]=goombasheet.crop(2,152,44,48);
			goomba_back[1]=goombasheet.crop(48,152,44,48);
			goomba_back[2]=goombasheet.crop(94,152,44,48);
			goomba_back[3]=goombasheet.crop(140,152,44,48);
			goomba_back[4]=goombasheet.crop(186,152,44,48);
			goomba_back[5]=goombasheet.crop(232,152,44,48);
			goomba_back[6]=goombasheet.crop(278,152,44,48);
			goomba_back[7]=goombasheet.crop(324,152,44,48);

			//Koopa
			koopa_front[0]=koopasheet.crop(2,2,54,74);
			koopa_front[1]=koopasheet.crop(58,2,54,74);
			koopa_front[2]=koopasheet.crop(114,2,54,74);
			koopa_front[3]=koopasheet.crop(170,2,54,74);
			koopa_front[4]=koopasheet.crop(226,2,54,74);
			koopa_front[5]=koopasheet.crop(282,2,54,74);
			koopa_front[6]=koopasheet.crop(338,2,54,74);
			koopa_front[7]=koopasheet.crop(394,2,54,74);

			koopa_left[0]=koopasheet.crop(2,78,54,74);
			koopa_left[1]=koopasheet.crop(58,78,54,74);
			koopa_left[2]=koopasheet.crop(114,78,54,74);
			koopa_left[3]=koopasheet.crop(170,78,54,74);
			koopa_left[4]=koopasheet.crop(226,78,54,74);
			koopa_left[5]=koopasheet.crop(282,78,54,74);
			koopa_left[6]=koopasheet.crop(338,78,54,74);
			koopa_left[7]=koopasheet.crop(394,78,54,74);

			koopa_right[0]=koopasheet.crop(2,154,54,74);
			koopa_right[1]=koopasheet.crop(58,154,54,74);
			koopa_right[2]=koopasheet.crop(114,154,54,74);
			koopa_right[3]=koopasheet.crop(170,154,54,74);
			koopa_right[4]=koopasheet.crop(226,154,54,74);
			koopa_right[5]=koopasheet.crop(282,154,54,74);
			koopa_right[6]=koopasheet.crop(338,154,54,74);
			koopa_right[7]=koopasheet.crop(394,154,54,74);

			koopa_back[0]=koopasheet.crop(2,230,54,74);
			koopa_back[1]=koopasheet.crop(58,230,54,74);
			koopa_back[2]=koopasheet.crop(114,230,54,74);
			koopa_back[3]=koopasheet.crop(170,230,54,74);
			koopa_back[4]=koopasheet.crop(226,230,54,74);
			koopa_back[5]=koopasheet.crop(282,230,54,74);
			koopa_back[6]=koopasheet.crop(338,230,54,74);
			koopa_back[7]=koopasheet.crop(394,230,54,74);

			//Chain Chomp
			chain_front[0]=chainchompsheet.crop(2,2,96,88);
			chain_front[1]=chainchompsheet.crop(100,2,96,88);
			chain_front[2]=chainchompsheet.crop(198,2,96,88);
			chain_front[3]=chainchompsheet.crop(296,2,96,88);

			chain_left[0]=chainchompsheet.crop(2,92,96,88);
			chain_left[1]=chainchompsheet.crop(100,92,96,88);
			chain_left[2]=chainchompsheet.crop(198,92,96,88);
			chain_left[3]=chainchompsheet.crop(296,92,96,88);

			chain_right[0]=chainchompsheet.crop(2,182,96,88);
			chain_right[1]=chainchompsheet.crop(100,182,96,88);
			chain_right[2]=chainchompsheet.crop(198,182,96,88);
			chain_right[3]=chainchompsheet.crop(296,182,96,88);

			chain_back[0]=chainchompsheet.crop(2,272,96,88);
			chain_back[1]=chainchompsheet.crop(100,272,96,88);
			chain_back[2]=chainchompsheet.crop(198,272,96,88);
			chain_back[3]=chainchompsheet.crop(296,272,96,88);

			//Bowser
			bowser_front[0]=bowsersheet.crop(2,2,138,138);
			bowser_front[1]=bowsersheet.crop(142,2,138,138);
			bowser_front[2]=bowsersheet.crop(282,2,138,138);
			bowser_front[3]=bowsersheet.crop(422,2,138,138);
			bowser_front[4]=bowsersheet.crop(562,2,138,138);
			bowser_front[5]=bowsersheet.crop(702,2,138,138);
			bowser_front[6]=bowsersheet.crop(842,2,138,138);
			bowser_front[7]=bowsersheet.crop(982,2,138,138);
			bowser_front[8]=bowsersheet.crop(1122,2,138,138);
			bowser_front[9]=bowsersheet.crop(1262,2,138,138);
			bowser_front[10]=bowsersheet.crop(1402,2,138,138);
			bowser_front[11]=bowsersheet.crop(1542,2,138,138);
			bowser_front[12]=bowsersheet.crop(1682,2,138,138);
			bowser_front[13]=bowsersheet.crop(1822,2,138,138);
			bowser_front[14]=bowsersheet.crop(1962,2,138,138);
			bowser_front[15]=bowsersheet.crop(2102,2,138,138);

			bowser_left[0]=bowsersheet.crop(2,142,138,138);
			bowser_left[1]=bowsersheet.crop(142,142,138,138);
			bowser_left[2]=bowsersheet.crop(282,142,138,138);
			bowser_left[3]=bowsersheet.crop(422,142,138,138);
			bowser_left[4]=bowsersheet.crop(562,142,138,138);
			bowser_left[5]=bowsersheet.crop(702,142,138,138);
			bowser_left[6]=bowsersheet.crop(842,142,138,138);
			bowser_left[7]=bowsersheet.crop(982,142,138,138);
			bowser_left[8]=bowsersheet.crop(1122,142,138,138);
			bowser_left[9]=bowsersheet.crop(1262,142,138,138);
			bowser_left[10]=bowsersheet.crop(1402,142,138,138);
			bowser_left[11]=bowsersheet.crop(1542,142,138,138);
			bowser_left[12]=bowsersheet.crop(1682,142,138,138);
			bowser_left[13]=bowsersheet.crop(1822,142,138,138);
			bowser_left[14]=bowsersheet.crop(1962,142,138,138);
			bowser_left[15]=bowsersheet.crop(2102,142,138,138);

			bowser_right[0]=bowsersheet.crop(2,282,138,138);
			bowser_right[1]=bowsersheet.crop(142,282,138,138);
			bowser_right[2]=bowsersheet.crop(282,282,138,138);
			bowser_right[3]=bowsersheet.crop(422,282,138,138);
			bowser_right[4]=bowsersheet.crop(562,282,138,138);
			bowser_right[5]=bowsersheet.crop(702,282,138,138);
			bowser_right[6]=bowsersheet.crop(842,282,138,138);
			bowser_right[7]=bowsersheet.crop(982,282,138,138);
			bowser_right[8]=bowsersheet.crop(1122,282,138,138);
			bowser_right[9]=bowsersheet.crop(1262,282,138,138);
			bowser_right[10]=bowsersheet.crop(1402,282,138,138);
			bowser_right[11]=bowsersheet.crop(1542,282,138,138);
			bowser_right[12]=bowsersheet.crop(1682,282,138,138);
			bowser_right[13]=bowsersheet.crop(1822,282,138,138);
			bowser_right[14]=bowsersheet.crop(1962,282,138,138);
			bowser_right[15]=bowsersheet.crop(2102,282,138,138);

			bowser_back[0]=bowsersheet.crop(2,422,138,138);
			bowser_back[1]=bowsersheet.crop(142,422,138,138);
			bowser_back[2]=bowsersheet.crop(282,422,138,138);
			bowser_back[3]=bowsersheet.crop(422,422,138,138);
			bowser_back[4]=bowsersheet.crop(562,422,138,138);
			bowser_back[5]=bowsersheet.crop(702,422,138,138);
			bowser_back[6]=bowsersheet.crop(842,422,138,138);
			bowser_back[7]=bowsersheet.crop(982,422,138,138);
			bowser_back[8]=bowsersheet.crop(1122,422,138,138);
			bowser_back[9]=bowsersheet.crop(1262,422,138,138);
			bowser_back[10]=bowsersheet.crop(1402,422,138,138);
			bowser_back[11]=bowsersheet.crop(1542,422,138,138);
			bowser_back[12]=bowsersheet.crop(1682,422,138,138);
			bowser_back[13]=bowsersheet.crop(1822,422,138,138);
			bowser_back[14]=bowsersheet.crop(1962,422,138,138);
			bowser_back[15]=bowsersheet.crop(2102,422,138,138);

			//Dry Bones
			drybones_front[0]=drybonessheet.crop(2,2,46,74);
			drybones_front[1]=drybonessheet.crop(50,2,46,74);
			drybones_front[2]=drybonessheet.crop(98,2,46,74);
			drybones_front[3]=drybonessheet.crop(146,2,46,74);
			drybones_front[4]=drybonessheet.crop(194,2,46,74);
			drybones_front[5]=drybonessheet.crop(242,2,46,74);
			drybones_front[6]=drybonessheet.crop(290,2,46,74);
			drybones_front[7]=drybonessheet.crop(338,2,46,74);

			drybones_left[0]=drybonessheet.crop(2,78,46,74);
			drybones_left[1]=drybonessheet.crop(50,78,46,74);
			drybones_left[2]=drybonessheet.crop(98,78,46,74);
			drybones_left[3]=drybonessheet.crop(146,78,46,74);
			drybones_left[4]=drybonessheet.crop(194,78,46,74);
			drybones_left[5]=drybonessheet.crop(242,78,46,74);
			drybones_left[6]=drybonessheet.crop(290,78,46,74);
			drybones_left[7]=drybonessheet.crop(338,78,46,74);

			drybones_right[0]=drybonessheet.crop(2,154,46,74);
			drybones_right[1]=drybonessheet.crop(50,154,46,74);
			drybones_right[2]=drybonessheet.crop(98,154,46,74);
			drybones_right[3]=drybonessheet.crop(146,154,46,74);
			drybones_right[4]=drybonessheet.crop(194,154,46,74);
			drybones_right[5]=drybonessheet.crop(242,154,46,74);
			drybones_right[6]=drybonessheet.crop(290,154,46,74);
			drybones_right[7]=drybonessheet.crop(338,154,46,74);

			drybones_back[0]=drybonessheet.crop(2,230,46,74);
			drybones_back[1]=drybonessheet.crop(50,230,46,74);
			drybones_back[2]=drybonessheet.crop(98,230,46,74);
			drybones_back[3]=drybonessheet.crop(146,230,46,74);
			drybones_back[4]=drybonessheet.crop(194,230,46,74);
			drybones_back[5]=drybonessheet.crop(242,230,46,74);
			drybones_back[6]=drybonessheet.crop(290,230,46,74);
			drybones_back[7]=drybonessheet.crop(338,230,46,74);


			//NPCS			

			//Peach
			princesspeach[0]=npcsheet.crop(2,2,48,94);   //Front
			princesspeach[1]=npcsheet.crop(52,2,48,94);  //Left
			princesspeach[2]=npcsheet.crop(102,2,48,94); //Back
			princesspeach[3]=npcsheet.crop(152,2,48,94); //Right

			//Yoshi
			yoshi[0]=npcsheet.crop(2,98,50,84);

			toad[0]=npcsheet.crop(2,184,36,54);

			//Luigi
			luigi_front[0]=luigisheet.crop(2,2,44,86);
			luigi_front[1]=luigisheet.crop(48,2,44,86);
			luigi_front[2]=luigisheet.crop(94,2,44,86);
			luigi_front[3]=luigisheet.crop(140,2,44,86);
			luigi_front[4]=luigisheet.crop(186,2,44,86);
			luigi_front[5]=luigisheet.crop(232,2,44,86);
			luigi_front[6]=luigisheet.crop(278,2,44,86);
			luigi_front[7]=luigisheet.crop(324,2,44,86);

			luigi_left[0]=luigisheet.crop(2,90,44,86);
			luigi_left[1]=luigisheet.crop(48,90,44,86);
			luigi_left[2]=luigisheet.crop(94,90,44,86);
			luigi_left[3]=luigisheet.crop(140,90,44,86);
			luigi_left[4]=luigisheet.crop(186,90,44,86);
			luigi_left[5]=luigisheet.crop(232,90,44,86);
			luigi_left[6]=luigisheet.crop(278,90,44,86);
			luigi_left[7]=luigisheet.crop(324,90,44,86);

			luigi_right[0]=luigisheet.crop(2,178,44,86);
			luigi_right[1]=luigisheet.crop(48,178,44,86);
			luigi_right[2]=luigisheet.crop(94,178,44,86);
			luigi_right[3]=luigisheet.crop(140,178,44,86);
			luigi_right[4]=luigisheet.crop(186,178,44,86);
			luigi_right[5]=luigisheet.crop(232,178,44,86);
			luigi_right[6]=luigisheet.crop(278,178,44,86);
			luigi_right[7]=luigisheet.crop(324,178,44,86);

			luigi_back[0]=luigisheet.crop(2,266,44,86);
			luigi_back[1]=luigisheet.crop(48,266,44,86);
			luigi_back[2]=luigisheet.crop(94,266,44,86);
			luigi_back[3]=luigisheet.crop(140,266,44,86);
			luigi_back[4]=luigisheet.crop(186,266,44,86);
			luigi_back[5]=luigisheet.crop(232,266,44,86);
			luigi_back[6]=luigisheet.crop(278,266,44,86);
			luigi_back[7]=luigisheet.crop(324,266,44,86);


		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(Images.class.getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}



}