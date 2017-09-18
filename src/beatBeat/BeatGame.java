package beatBeat;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BeatGame extends JFrame {

	// ���� ���۸��� ���� ��ü ȭ�鿡 ���� �̹����� ��� �ν��Ͻ�
	private Image screenImage;
	private Graphics screenGraphic;

	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	private Image judgmentLineImage = new ImageIcon(Main.class.getResource("../images/judgmentLine.png")).getImage();
	private Image notePathImage = new ImageIcon(Main.class.getResource("../images/notePath.png")).getImage();
	private Image notePathLineImage = new ImageIcon(Main.class.getResource("../images/notePathLine.png")).getImage();
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	// ����Ŭ������ ��ġ�� ������� ���ҽ��� ���´��� �̹��� �ҽ��� �����ͼ� �ʱ�ȭ����
	private Image background = new ImageIcon(Main.class.getResource("../images/introBackground_title.jpg")).getImage();

	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));

	// ��ư ������
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

	// easy hard ��ư
	private ImageIcon easyButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/easyButton2.png"));
	private ImageIcon easyButtonBasicImage = new ImageIcon(Main.class.getResource("../images/easyButton1.png"));
	private ImageIcon hardButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/hardButton2.png"));
	private ImageIcon hardButtonBasicImage = new ImageIcon(Main.class.getResource("../images/hardButton1.png"));

	// back Button
	private ImageIcon backButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/backButton2.png"));
	private ImageIcon backButtonBasicImage = new ImageIcon(Main.class.getResource("../images/backButton1.png"));

	// ����� �� �����ܵ�� ���� ��ư
	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	private JButton easyButton = new JButton(easyButtonBasicImage);
	private JButton hardButton = new JButton(hardButtonBasicImage);
	private JButton backButton = new JButton(backButtonBasicImage);

	// ���콺 �����Ͱ�
	private int mouseX, mouseY;

	// ���ν�ũ������ �ƴ���
	private boolean isMainScreen = false;
	private boolean isGameScreen = false;
	
	ArrayList<Track> trackList = new ArrayList<Track>();

	private Image selectedImage;
	private Image titleImage;
	private Music selectedMusic;
	private Music introMusic = new Music("introMusic.mp3", true); // ��Ʈ�� ������ �־ ���� ��ü ����,���� �ݺ��� ��
	private int nowSelected = 0;

	public BeatGame() {

		setUndecorated(true); // �޴��ٰ� ������ �ʰ� ���ش�.
		setTitle("BeatGame");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); // ���������� ������
		setLocationRelativeTo(null); // ����� â �߾ӿ� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // â���� ���α׷� ����ǵ���
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);

		introMusic.start();

		trackList.add(new Track("candyLand Title Image.png", "cnadyLand Start Image.png", "candyLand Game Image.png",
				"Candyland Selected.mp3", "Tobu - Candyland .mp3"));
		trackList.add(new Track("funnySong Title Image.png", "funnySong Start Image.png", "funnySong Game Image.png",
				"funnySong Selected.mp3", "bensound-funnySong.mp3"));
		trackList.add(new Track("popsicle Title Image.png", "popsicle Start Image.png", "popsicle Game Image.png",
				"Popsicle Selected.mp3", "LFZ - Popsicle .mp3"));

		// exit��ư �޴��ٿ� �ִ°�
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

		// strat��ư
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
				enterMain();
			}
		});
		add(startButton);

		// quit��ư
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

		// left��ư
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

		// right��ư
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

		// easy��ư
		easyButton.setVisible(false);
		easyButton.setBounds(375, 580, 250, 70);
		easyButton.setBorderPainted(false);
		easyButton.setContentAreaFilled(false);
		easyButton.setFocusPainted(false);
		easyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				easyButton.setIcon(easyButtonEnteredImage);
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				easyButton.setIcon(easyButtonBasicImage);
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				gameStart(nowSelected, "easy");
			}
		});
		add(easyButton);

		// hard��ư
		hardButton.setVisible(false);
		hardButton.setBounds(655, 580, 250, 70);
		hardButton.setBorderPainted(false);
		hardButton.setContentAreaFilled(false);
		hardButton.setFocusPainted(false);
		hardButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hardButton.setIcon(hardButtonEnteredImage);
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				hardButton.setIcon(hardButtonBasicImage);
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				gameStart(nowSelected, "hard");
			}
		});
		add(hardButton);

		// back��ư
		backButton.setVisible(false);
		backButton.setBounds(20, 50, 60, 60);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(backButtonEnteredImage);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(backButtonBasicImage);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				backMain();
			}
		});
		add(backButton);

		menuBar.setBounds(0, 0, 1280, 30); // �޴����� ��ġ�� ũ�⸦ �����ش�.
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
				// �巡�� �Ҷ� ������������ x,y��ǥ�� ���ͼ� ����â�� ��ġ�� �ٲ��ش�.
				setLocation(x - mouseX, y - mouseY);
			}

		});
		add(menuBar);

	}

	// paint�� gui���ӿ��� ���� ù��°�� �׸��� �׷��ִ� �Լ� ��ӵ� �Լ���
	public void paint(Graphics g) {
		// 1. ȭ�� ũ�⸸ŭ �̹��� ����
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		// 2. ��ũ�� �̹����� �̿��� �׷��� ��ü�� ���ͼ�
		screenGraphic = screenImage.getGraphics();
		// 3. �̹����� ���ϴ� ������ �׷��ش�. ��¥���� �ذ� �ϱ����� 2D�� ����ȯ
		screenDraw((Graphics2D)screenGraphic);
		// 4. drawImage�޼��带���� ��ũ�� �̹����� 0,0��ġ�� �׷���
		g.drawImage(screenImage, 0, 0, null);
	}

	// ���α׷��� ����Ǵ� �������� paint�Լ��� �Դٰ��� �ϸ鼭 �׷���
	public void screenDraw(Graphics2D g) {
		// drawImage�޼���� ��Ʈ�� ��׶��� ���ҽ��� ��ũ�� �̹����� �׷���
		// �ַ� �̹����� �������� �̹����� ����ϴ°� �Ϲ���
		// add�޼��� �Ⱦ��� �ܼ��� �̹����鿡�� ���� ����Ѵ�.
		g.drawImage(background, 0, 0, null);
		// ���� ���ν�ũ���̸� �ٸ��ų�����
		if (isMainScreen) {
			g.drawImage(selectedImage, 340, 100, null);
			g.drawImage(titleImage, 340, 70, null);
		}
		if (isGameScreen) {
			g.drawImage(notePathImage, 228, 30, null);
			g.drawImage(notePathImage, 332, 30, null);
			g.drawImage(notePathImage, 436, 30, null);
			g.drawImage(notePathImage, 540, 30, null);
			g.drawImage(notePathImage, 640, 30, null);
			g.drawImage(notePathImage, 744, 30, null);
			g.drawImage(notePathImage, 848, 30, null);
			g.drawImage(notePathImage, 952, 30, null);
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
			g.drawImage(noteBasicImage, 228, 30, null);
			g.drawImage(noteBasicImage, 332, 30, null);
			g.drawImage(noteBasicImage, 436, 30, null);
			g.drawImage(noteBasicImage, 540, 30, null);
			g.drawImage(noteBasicImage, 640, 30, null);
			g.drawImage(noteBasicImage, 744, 30, null);
			g.drawImage(noteBasicImage, 848, 30, null);
			g.drawImage(noteBasicImage, 952, 30, null);
			g.setColor(Color.white);
			g.setFont(new Font("Arial", Font.BOLD, 30));
			//��Ƽ ���ϸ���� ����
			g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			g.drawString("Candy - Land", 20, 702);
			g.drawString("Easy", 1190, 702);
			g.setFont(new Font("Arial", Font.BOLD, 26));
			g.setColor(Color.DARK_GRAY);
			g.drawString("S", 270, 609);
			g.drawString("D", 374, 609);
			g.drawString("F", 478, 609);
			g.drawString("Space Bar", 580, 609);
			g.drawString("J", 	784, 609);
			g.drawString("K", 889, 609);
			g.drawString("L", 993, 609);
			g.setFont(new Font("Elephant", Font.BOLD, 30));
			g.drawString("000000", 565, 702);
		}
		// �޴��ٰ����� JFrame�ȿ� �׸��� �߰����ִ� ��
		// �ַ� ��ư�̳� �������� ��󿡴� paintComponents�� �̿��ؼ� �����Ѵ�.
		// add�޼��� ���´���� �׷��ش�.
		paintComponents(g);
		// ������Ʈ �����μ� �ٽ� ����Ʈ�Լ��� �ҷ���
		this.repaint();
	}

	public void selecTrack(int nowSelected) {
		if (selectedMusic != null)
			selectedMusic.close();
		titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage()))
				.getImage();
		selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage()))
				.getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();
	}

	// ���� �� ����
	public void selectLeft() {
		// 1. ù��° ���̸� �ǳ����� �ƴϸ� --
		if (nowSelected == 0)
			nowSelected = trackList.size() - 1;
		else
			nowSelected--;
		selecTrack(nowSelected);
	}

	// ���� �� ���
	public void selectRight() {
		// 1. �ǳ����̸� ù��° ������ �ƴϸ� ++
		if (nowSelected == trackList.size() - 1)
			nowSelected = 0;
		else
			nowSelected++;
		selecTrack(nowSelected);
	}

	// ���� ȭ������ ����
	public void gameStart(int nowSelected, String difficulty) {
		if (selectedMusic != null)
			selectedMusic.close();
		isMainScreen = false;
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImgae()))
				.getImage();
		backButton.setVisible(true);
		isGameScreen = true;
	}

	public void backMain() {
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
		backButton.setVisible(false);
		selecTrack(nowSelected);
		isGameScreen = false;
	}

	public void enterMain() {
		startButton.setVisible(false);
		quitButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
		isMainScreen = true;
		leftButton.setVisible(true); // ����Ʈ ��ư Ȱ��ȭ
		rightButton.setVisible(true); // ����Ʈ ��ư Ȱ��ȭ
		easyButton.setVisible(true); // ���� ��ư Ȱ��ȭ
		hardButton.setVisible(true); // �ϵ� ��ư Ȱ��ȭ
		introMusic.close();
		selecTrack(0);
	}
}
