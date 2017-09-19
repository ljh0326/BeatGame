package beatBeat;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread {

	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	private int x, y = (580 - 1000 / Main.SLEEP_TIME * Main.NOTE_SPEED) * Main.REACH_TIME;
	private String noteType;

	// 현재 위치 받음
	public Note(String noteType) {
		if (noteType.equalsIgnoreCase("S")) {
			x = 228;
		} else if (noteType.equalsIgnoreCase("D")) {
			x = 332;
		} else if (noteType.equalsIgnoreCase("F")) {
			x = 436;
		} else if (noteType.equalsIgnoreCase("Space")) {
			x = 540;
		} else if (noteType.equalsIgnoreCase("J")) {
			x = 744;
		} else if (noteType.equalsIgnoreCase("K")) {
			x = 848;
		} else if (noteType.equalsIgnoreCase("L")) {
			x = 952;
		}
		this.noteType = noteType;
	}

	public void screenDraw(Graphics2D g) {
		if (!noteType.equals("Space")) {
			g.drawImage(noteBasicImage, x, y, null);
		} else {
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, x + 100, y, null);
		}
	}

	public void drop() {
		y += Main.NOTE_SPEED;
	}

	@Override
	public void run() {
		try {
			while (true) {
				drop();
				Thread.sleep(Main.SLEEP_TIME);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
