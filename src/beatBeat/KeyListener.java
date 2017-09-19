package beatBeat;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {

	@Override
	public void keyPressed(KeyEvent e) {
		if(BeatGame.game == null) {
			return;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			BeatGame.game.pressS();
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			BeatGame.game.pressD();
		} else if (e.getKeyCode() == KeyEvent.VK_F) {
			BeatGame.game.pressF();
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			BeatGame.game.pressSpace();
		} else if (e.getKeyCode() == KeyEvent.VK_J) {
			BeatGame.game.pressJ();
		} else if (e.getKeyCode() == KeyEvent.VK_K) {
			BeatGame.game.pressK();
		} else if (e.getKeyCode() == KeyEvent.VK_L) {
			BeatGame.game.pressL();
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(BeatGame.game == null) {
			return;
		}
		
		if (e.getKeyCode() == KeyEvent.VK_S) {
			BeatGame.game.releseS();
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			BeatGame.game.releseD();
		} else if (e.getKeyCode() == KeyEvent.VK_F) {
			BeatGame.game.releseF();
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			BeatGame.game.releseSpace();
		} else if (e.getKeyCode() == KeyEvent.VK_J) {
			BeatGame.game.releseJ();
		} else if (e.getKeyCode() == KeyEvent.VK_K) {
			BeatGame.game.releseK();
		} else if (e.getKeyCode() == KeyEvent.VK_L) {
			BeatGame.game.releseL();
		}
	}
}
