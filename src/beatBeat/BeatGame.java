package beatBeat;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BeatGame extends JFrame {

	// 더블 버퍼링을 위해 전체 화면에 대한 이미지를 담는 인스턴스
	private Image screenImage;
	private Graphics screenGraphic;

	// 메인클래스의 위치를 기반으로 리소스를 얻어온다음 이미지 소스를 가져와서 초기화해줌
	private Image background = new ImageIcon(Main.class.getResource("../images/introBackground_title.jpg")).getImage();
	
	
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));

	// 버튼 아이콘
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButton2.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButton1.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButton2.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButton1.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButton2.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButton1.png"));

	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/leftButton2.png"));
	private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../images/leftButton1.png"));
	private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/rightButton2.png"));
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rightButton1.png"));

	// 만들어 둔 아이콘들로 만든 버튼
	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);

	// 마우스 포인터값
	private int mouseX, mouseY;

	// 메인스크린인지 아닌지
	private boolean isMainScreen = false;

	ArrayList<Track> trackList = new ArrayList<Track>();
	
	private Image selectedImage; 
	private Image titleImage;
	private Music selectedMusic;
	private int nowSelected = 0;
	
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

		Music introMusic = new Music("introMusic.mp3", true); // 인트로 음악을 넣어서 뮤직 객체 생성,무한 반복값 줌
		introMusic.start();
		
		trackList.add(new Track("candyLand Title Image.png", "cnadyLand Start Image.png", "candyLand Game Image.png"
				,"Candyland Selected.mp3", "Tobu - Candyland .mp3"));
		trackList.add(new Track("funnySong Title Image.png", "funnySong Start Image.png", "funnySong Game Image.png"
				,"funnySong Selected.mp3", "bensound-funnySong.mp3"));
		trackList.add(new Track("popsicle Title Image.png", "popsicle Start Image.png", "popsicle Game Image.png"
				,"Popsicle Selected.mp3", "LFZ - Popsicle .mp3"));
		
		
		// exit버튼 메뉴바에 있는거
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

		// strat버튼
		startButton.setBounds(980, 520, 300, 100);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				introMusic.close();
				selecTrack(0);
				startButton.setVisible(false);
				quitButton.setVisible(false);
				leftButton.setVisible(true); // 레프트 버튼 활성화
				rightButton.setVisible(true); // 라이트 버튼 활성화
				background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
				isMainScreen = true;
			}
		});
		add(startButton);

		// quit버튼
		quitButton.setBounds(980, 600, 300, 100);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonEnteredImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		add(quitButton);

		// left버튼
		leftButton.setVisible(false);
		leftButton.setBounds(140, 310, 60, 60);
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftButtonEnteredImage);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				selectLeft();
			}
		});
		add(leftButton);

		// right버튼
		rightButton.setVisible(false);
		rightButton.setBounds(1080, 310, 60, 60);
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightButtonEnteredImage);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				selectRight();
			}
		});
		add(rightButton);

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
				// 드래그 할때 순간순간마다 x,y좌표를 얻어와서 게임창의 위치를 바꿔준다.
				setLocation(x - mouseX, y - mouseY);
			}

		});
		add(menuBar);

		
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
		// drawImage메서드는 인트로 백그라운드 리소스를 스크린 이미지에 그려줌
		// 주로 이미지나 역동적인 이미지에 사용하는게 일반적
		// add메서드 안쓰는 단순한 이미지들에게 많이 사용한다.
		g.drawImage(background, 0, 0, null);
		// 만약 메인스크린이면 다른거나오게
		if (isMainScreen) {
			g.drawImage(selectedImage, 340, 100, null);
			g.drawImage(titleImage, 340, 70, null);
		}
		// 메뉴바같은걸 JFrame안에 그리면 추가해주는 것
		// 주로 버튼이나 고정적인 대상에는 paintComponents를 이용해서 구현한다.
		// add메서드 쓰는대상을 그려준다.
		paintComponents(g);
		// 리페인트 함으로서 다시 페인트함수를 불러옴
		this.repaint();
	}
	
	public void selecTrack(int nowSelected) {
		if(selectedMusic != null)
			selectedMusic.close();
		titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage())).getImage();
		selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage())).getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();
	}
	
	//왼쪽 곡 선택
	public void selectLeft() {
		//1. 첫번째 곡이면 맨끝으로 아니면 --
		if(nowSelected == 0)
			nowSelected = trackList.size() - 1;
		else
			nowSelected--;
		selecTrack(nowSelected);
	}
	
	//오른 쪽 곡선택
	public void selectRight() {
		//1. 맨끝곡이면 첫번째 곡으로 아니면 ++
		if(nowSelected == trackList.size() - 1)
			nowSelected = 0;
		else
			nowSelected++;
		selecTrack(nowSelected);
	}
}
