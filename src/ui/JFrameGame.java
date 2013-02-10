package ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import config.ConfigFactory;
import config.GameConfig;

public class JFrameGame extends JFrame {

	private static final long serialVersionUID = -6194695820531427582L;

	public JFrameGame(JPanelGame panelGame) {
		
		// �����Ϸ����
		GameConfig cfg = ConfigFactory.getGameConfig();
		// ���ô��ڱ���
		this.setTitle(cfg.getTitle());
		// ����Ĭ�Ϲر����ԣ����������
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ���ô��ڴ�С
		this.setSize(cfg.getWidth(), cfg.getHeight());
		// �������û��ı䴰�ڴ�С
		this.setResizable(false);
		// ���ھ���
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		int x = screen.width - this.getWidth() >> 1;
		int y = (screen.height - this.getHeight() >> 1) - cfg.getWindowUp();
		this.setLocation(x, y);
		// ����Ĭ��Panel
		this.setContentPane(panelGame);
		// ���øô���Ĭ����ʾ
		this.setVisible(true);
	}
}
