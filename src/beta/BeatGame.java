package beta;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class BeatGame extends JFrame{
	
	//���� ���۸��� ���� ��ü ȭ�鿡 ���� �̹����� ��� �ν��Ͻ�
	private Image screenImage;
	private Graphics screenGraphic;
	
	private Image introBackground;
	
	public BeatGame() {
		
		setTitle("BeatGame");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		//���������� ������
		setResizable(false);
		//����� â �߾ӿ� ����
		setLocationRelativeTo(null);
		//â���� ���α׷� ����ǵ���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		//����Ŭ������ ��ġ�� ������� ���ҽ��� ���´��� �̹��� �ҽ��� �����ͼ� �ʱ�ȭ����
		introBackground = new ImageIcon(Main.class.getResource("../images/introBackground_title.jpg")).getImage();
		
		//��Ʈ�� ������ �־ ���� ��ü ����,���� �ݺ��� ��  
		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
	}
	
	//paint��  gui���ӿ��� ���� ù��°�� �׸��� �׷��ִ� �Լ� ��ӵ� �Լ���
	public void paint(Graphics g) {
		//1. ȭ�� ũ�⸸ŭ �̹��� ����
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		//2. ��ũ�� �̹����� �̿��� �׷��� ��ü�� ���ͼ�
		screenGraphic = screenImage.getGraphics();
		//3. �̹����� ���ϴ� ������ �׷��ش�.
		screenDraw(screenGraphic);
		//4. drawImage�޼��带���� ��ũ�� �̹����� 0,0��ġ�� �׷���
		g.drawImage(screenImage, 0, 0, null);
	}
	
	//���α׷��� ����Ǵ� �������� paint�Լ��� �Դٰ��� �ϸ鼭 �׷���
	public void screenDraw(Graphics g) {
		//��Ʈ�� ��׶��� ���ҽ��� ��ũ�� �̹����� �׷��� 
		g.drawImage(introBackground, 0, 0, null);
		//������Ʈ �����μ� �ٽ� ����Ʈ�Լ��� �ҷ���
		this.repaint();
	}
}
