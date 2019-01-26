package Game.GameStates;

import java.awt.Graphics;

import Main.Handler;
import Resources.Images;
import UI.UIImageButton;
import UI.UIManager;

public class IntroState extends State {

    private int count = 0;
    private UIManager uiManager;
	
	public IntroState(Handler handler) {
		super(handler);

        uiManager = new UIManager(handler);
        handler.getMouseManager().setUimanager(uiManager);

	} 

    @Override
    public void tick() {
        handler.getMouseManager().setUimanager(uiManager);
        uiManager.tick();
        if(handler.getKeyManager().attbut){
            State.setState(handler.getGame().gameState);
        }


    }
//	TODO Change the image
    @Override
    public void render(Graphics g) {
        g.drawImage(Images.IntroScreen,0,0,800,600,null);
        uiManager.Render(g);

    }
}
