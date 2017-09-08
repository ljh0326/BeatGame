package beta;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BeatGame extends JFrame {

	// 더블 버퍼링을 위해 전체 화면에 대한 이미지를 담는 인스턴스
	private Image screenImage;
	private Graphics screenGraphic;
	// 메인클래스의 위치를 기반으로 리소스를 얻어온다음 이미지 소스를 가져와서 초기화해줌
	private Image introBackground = new ImageIcon(Main.class.getResource("../images/introBackground_title.jpg"))
			.getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButton2.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButton1.png"));
	
	private JButton exitButton = new JButton(exitButtonBasicImage);

	private int mouseX, mouseY;

	public BeatGame() {

		setUndecorated(true); // 메뉴바가 보이지 않게 해준다.
		setTitle("BeatGame");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); // 임의적으로 못줄임
		setLocationRelativeTo(null); // 실행시 창 중앙에 오게
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창끄면 프로그램 종료되도록
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);

		exitButton.setBounds(1245, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		
		
		add(exitButton);
		
		menuBar.setBounds(0, 0, 1280, 30); // 메뉴바의 위치와 크기를 정해준다.
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				//드래그 할때 순간순간마다 x,y좌표를 얻어와서 게임창의 위치를 바꿔준다.
				setLocation(x - mouseX, y - mouseY);
			}
		
		});
		add(menuBar);
		
		Music introMusic = new Music("introMusic.mp3", true); // 인트로 음악을 넣어서 뮤직 객체 생성,무한 반복값 줌
		introMusic.start();
	}

	// paint는 gui게임에서 가장 첫번째로 그림을 그려주는 함수 약속된 함수임
	public void paint(Graphics g) {
		// 1. 화면 크기만큼 이미지 생성
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		// 2. 스크린 이미지를 이용해 그래픽 객체를 얻어와서
		screenGraphic = screenImage.getGraphics();
		// 3. 이미지에 원하는 내용을 그려준다.
		screenDraw(screenGraphic);
		// 4. drawImage메서드를통해 스크린 이미지를 0,0위치에 그려줌
		g.drawImage(screenImage, 0, 0, null);
	}

	// 프로그램이 종료되는 순간까지 paint함수를 왔다갔다 하면서 그려줌
	public void screenDraw(Graphics g) {
		// 인트로 백그라운드 리소스를 스크린 이미지에 그려줌
		g.drawImage(introBackground, 0, 0, null);
		// 메뉴바같은걸 JFrame안에 그리면 추가해주는 것
		// 주로 버튼이나 고정적인 대상에는 paintComponents를 이용해서 구현한다.
		paintComponents(g);
		// 리페인트 함으로서 다시 페인트함수를 불러옴
		this.repaint();
	}
}
