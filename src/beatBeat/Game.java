package beatBeat;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread{

	private Image notePathLineImage = new ImageIcon(Main.class.getResource("../images/notePathLine.png")).getImage();
	private Image judgmentLineImage = new ImageIcon(Main.class.getResource("../images/judgmentLine.png")).getImage();
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	
	private Image notePathSImage = new ImageIcon(Main.class.getResource("../images/notePath.png")).getImage();
	private Image notePathDImage = new ImageIcon(Main.class.getResource("../images/notePath.png")).getImage();
	private Image notePathFImage = new ImageIcon(Main.class.getResource("../images/notePath.png")).getImage();
	private Image notePathSpace1Image = new ImageIcon(Main.class.getResource("../images/notePath.png")).getImage();
	private Image notePathSpace2Image = new ImageIcon(Main.class.getResource("../images/notePath.png")).getImage();
	private Image notePathJImage = new ImageIcon(Main.class.getResource("../images/notePath.png")).getImage();
	private Image notePathKImage = new ImageIcon(Main.class.getResource("../images/notePath.png")).getImage();
	private Image notePathLImage = new ImageIcon(Main.class.getResource("../images/notePath.png")).getImage();
	
	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;
	
	//노트를 관리해주는 배열
	ArrayList<Note> noteList = new ArrayList<Note>();
	
	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);
		gameMusic.start();
	}
	
	public void screenDraw(Graphics2D g) {
		g.drawImage(notePathSImage, 228, 30, null);
		g.drawImage(notePathDImage, 332, 30, null);
		g.drawImage(notePathFImage, 436, 30, null);
		g.drawImage(notePathSpace1Image, 540, 30, null);
		g.drawImage(notePathSpace2Image, 640, 30, null);
		g.drawImage(notePathJImage, 744, 30, null);
		g.drawImage(notePathKImage, 848, 30, null);
		g.drawImage(notePathLImage, 952, 30, null);
		g.drawImage(notePathLineImage, 224, 30, null);
		g.drawImage(notePathLineImage, 328, 30, null);
		g.drawImage(notePathLineImage, 432, 30, null);
		g.drawImage(notePathLineImage, 536, 30, null);
		g.drawImage(notePathLineImage, 740, 30, null);
		g.drawImage(notePathLineImage, 844, 30, null);
		g.drawImage(notePathLineImage, 948, 30, null);
		g.drawImage(notePathLineImage, 1052, 30, null);
		
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgmentLineImage, 0, 580, null);
		
		for(int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			note.screenDraw(g);
		}
		
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		//안티 에일리언싱 적용
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.drawString(titleName, 20, 702);
		g.drawString(difficulty, 1190, 702);
		g.setFont(new Font("Arial", Font.BOLD, 26));
		g.setColor(Color.DARK_GRAY);
		g.drawString("S", 270, 609);
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("Space Bar", 580, 609);
		g.drawString("J", 	784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("Elephant", Font.BOLD, 30));
		g.drawString("000000", 565, 702);
	}
	
	public void pressS() {
		notePathSImage = new ImageIcon(Main.class.getResource("../images/notePathPressed.png")).getImage();
		new Music("drumSmall1.mp3",false).start();
	}
	public void releseS() {
		notePathSImage = new ImageIcon(Main.class.getResource("../images/notePath.png")).getImage();
	}
	public void pressD() {
		notePathDImage = new ImageIcon(Main.class.getResource("../images/notePathPressed.png")).getImage();
		new Music("drumSmall1.mp3",false).start();	
	}
	public void releseD() {
		notePathDImage = new ImageIcon(Main.class.getResource("../images/notePath.png")).getImage();
	}
	public void pressF() {
		notePathFImage = new ImageIcon(Main.class.getResource("../images/notePathPressed.png")).getImage();
		new Music("drumSmall1.mp3",false).start();
	}
	public void releseF() {
		notePathFImage = new ImageIcon(Main.class.getResource("../images/notePath.png")).getImage();
	}
	public void pressSpace() {
		notePathSpace1Image = new ImageIcon(Main.class.getResource("../images/notePathPressed.png")).getImage();
		notePathSpace2Image = new ImageIcon(Main.class.getResource("../images/notePathPressed.png")).getImage();
		new Music("drumBig1.mp3",false).start();
	}
	public void releseSpace() {
		notePathSpace1Image = new ImageIcon(Main.class.getResource("../images/notePath.png")).getImage();
		notePathSpace2Image = new ImageIcon(Main.class.getResource("../images/notePath.png")).getImage();
	}

	public void pressJ() {
		notePathJImage = new ImageIcon(Main.class.getResource("../images/notePathPressed.png")).getImage();
		new Music("drumSmall1.mp3",false).start();
	}
	public void releseJ() {
		notePathJImage = new ImageIcon(Main.class.getResource("../images/notePath.png")).getImage();
	}
	public void pressK() {
		notePathKImage = new ImageIcon(Main.class.getResource("../images/notePathPressed.png")).getImage();
		new Music("drumSmall1.mp3",false).start();
	}
	public void releseK() {
		notePathKImage = new ImageIcon(Main.class.getResource("../images/notePath.png")).getImage();
	}
	public void pressL() {
		notePathLImage = new ImageIcon(Main.class.getResource("../images/notePathPressed.png")).getImage();
		new Music("drumSmall1.mp3",false).start();
	}
	public void releseL() {
		notePathLImage = new ImageIcon(Main.class.getResource("../images/notePath.png")).getImage();
	}
	
	@Override
	public void run() {
		dropNotes();
	}
	
	public void close() {
		gameMusic.close();
		this.interrupt();
	}
	
	public void dropNotes() {
		Beat[] beats = null;
		if(titleName.equals("Tobu - Candyland")) {
			int startTime = 1000 - Main.REACH_TIME * 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space")
			};
		} else if(titleName.equals("bensound-funnySong")) {
			int startTime = 1000 - Main.REACH_TIME * 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space")
			};
		} else if(titleName.equals("LFZ - Popsicle")) {
			int startTime = 1000 - Main.REACH_TIME * 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space")
			};
		}
		
		int i = 0;
		while(true) {
			if(beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
			}
		}
	}
}
