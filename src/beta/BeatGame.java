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

	// ���� ���۸��� ���� ��ü ȭ�鿡 ���� �̹����� ��� �ν��Ͻ�
	private Image screenImage;
	private Graphics screenGraphic;
	// ����Ŭ������ ��ġ�� ������� ���ҽ��� ���´��� �̹��� �ҽ��� �����ͼ� �ʱ�ȭ����
	private Image introBackground = new ImageIcon(Main.class.getResource("../images/introBackground_title.jpg"))
			.getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButton2.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButton1.png"));
	
	private JButton exitButton = new JButton(exitButtonBasicImage);

	private int mouseX, mouseY;

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
				//�巡�� �Ҷ� ������������ x,y��ǥ�� ���ͼ� ����â�� ��ġ�� �ٲ��ش�.
				setLocation(x - mouseX, y - mouseY);
			}
		
		});
		add(menuBar);
		
		Music introMusic = new Music("introMusic.mp3", true); // ��Ʈ�� ������ �־ ���� ��ü ����,���� �ݺ��� ��
		introMusic.start();
	}

	// paint�� gui���ӿ��� ���� ù��°�� �׸��� �׷��ִ� �Լ� ��ӵ� �Լ���
	public void paint(Graphics g) {
		// 1. ȭ�� ũ�⸸ŭ �̹��� ����
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		// 2. ��ũ�� �̹����� �̿��� �׷��� ��ü�� ���ͼ�
		screenGraphic = screenImage.getGraphics();
		// 3. �̹����� ���ϴ� ������ �׷��ش�.
		screenDraw(screenGraphic);
		// 4. drawImage�޼��带���� ��ũ�� �̹����� 0,0��ġ�� �׷���
		g.drawImage(screenImage, 0, 0, null);
	}

	// ���α׷��� ����Ǵ� �������� paint�Լ��� �Դٰ��� �ϸ鼭 �׷���
	public void screenDraw(Graphics g) {
		// ��Ʈ�� ��׶��� ���ҽ��� ��ũ�� �̹����� �׷���
		g.drawImage(introBackground, 0, 0, null);
		// �޴��ٰ����� JFrame�ȿ� �׸��� �߰����ִ� ��
		// �ַ� ��ư�̳� �������� ��󿡴� paintComponents�� �̿��ؼ� �����Ѵ�.
		paintComponents(g);
		// ������Ʈ �����μ� �ٽ� ����Ʈ�Լ��� �ҷ���
		this.repaint();
	}
}
