package beta;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class BeatGame extends JFrame{
	
	//더블 버퍼링을 위해 전체 화면에 대한 이미지를 담는 인스턴스
	private Image screenImage;
	private Graphics screenGraphic;
	
	private Image introBackground;
	
	public BeatGame() {
		
		setTitle("BeatGame");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		//임의적으로 못줄임
		setResizable(false);
		//실행시 창 중앙에 오게
		setLocationRelativeTo(null);
		//창끄면 프로그램 종료되도록
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		//메인클래스의 위치를 기반으로 리소스를 얻어온다음 이미지 소스를 가져와서 초기화해줌
		introBackground = new ImageIcon(Main.class.getResource("../images/introBackground_title.jpg")).getImage();
		
		//인트로 음악을 넣어서 뮤직 객체 생성,무한 반복값 줌  
		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
	}
	
	//paint는  gui게임에서 가장 첫번째로 그림을 그려주는 함수 약속된 함수임
	public void paint(Graphics g) {
		//1. 화면 크기만큼 이미지 생성
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		//2. 스크린 이미지를 이용해 그래픽 객체를 얻어와서
		screenGraphic = screenImage.getGraphics();
		//3. 이미지에 원하는 내용을 그려준다.
		screenDraw(screenGraphic);
		//4. drawImage메서드를통해 스크린 이미지를 0,0위치에 그려줌
		g.drawImage(screenImage, 0, 0, null);
	}
	
	//프로그램이 종료되는 순간까지 paint함수를 왔다갔다 하면서 그려줌
	public void screenDraw(Graphics g) {
		//인트로 백그라운드 리소스를 스크린 이미지에 그려줌 
		g.drawImage(introBackground, 0, 0, null);
		//리페인트 함으로서 다시 페인트함수를 불러옴
		this.repaint();
	}
}
