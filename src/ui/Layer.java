package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import config.ConfigFactory;
import config.GameConfig;
import dto.GameDto;

/**
 * ���ƴ�����
 * 2013/2/5
 */

public abstract class Layer {
	
	protected static final int PADDING;
	private static final int SIZE;
	
	static {
		// �����Ϸ����
		GameConfig cfg = ConfigFactory.getGameConfig();
		PADDING = cfg.getPadding();
		SIZE = cfg.getWindowSize();
	}
	private static final Image WINDOW_IMG = new ImageIcon("graphics/window/window.png").getImage();
	private static final int WINDOW_IMGW = WINDOW_IMG.getWidth(null);
	private static final int WINDOW_IMGH = WINDOW_IMG.getHeight(null);
	
	protected int x;	// �������Ͻ� x ����
	protected int y;	// �������Ͻ� y ����
	protected int w;	// ���ƿ��
	protected int h;	// ���Ƹ߶�
	
	// ��Ϸ����
	protected GameDto dto = null;

	public Layer(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	public void setDto(GameDto dto) {
		this.dto = dto;
	}
	
	// Java ��һ�����ﶨ����ӿں��౾��Ҳ�ö���Ϊ���ࣿ
	abstract public void paint(Graphics g);
	
	// ���ƴ���
	public void createWindow(Graphics g) {
		// ����
		g.drawImage(WINDOW_IMG, x, y, x+SIZE, y+SIZE, 0, 0, SIZE, SIZE, null);
		// ����
		g.drawImage(WINDOW_IMG, x+SIZE, y, x+w-SIZE, y+SIZE, SIZE, 0, WINDOW_IMGW-SIZE, SIZE, null);
		// ����
		g.drawImage(WINDOW_IMG, x+w-SIZE, y, x+w, y+SIZE, WINDOW_IMGW-SIZE, 0, WINDOW_IMGW, SIZE, null);
		// ����
		g.drawImage(WINDOW_IMG, x, y+SIZE, x+SIZE, y+h-SIZE, 0, SIZE, SIZE, WINDOW_IMGH-SIZE, null);
		// ��
		g.drawImage(WINDOW_IMG, x+SIZE, y+SIZE, x+w-SIZE, y+h-SIZE, SIZE, SIZE, WINDOW_IMGW-SIZE, WINDOW_IMGH-SIZE, null);
		// ����
		g.drawImage(WINDOW_IMG, x+w-SIZE, y+SIZE, x+w, y+h-SIZE, WINDOW_IMGW-SIZE, SIZE, WINDOW_IMGW, WINDOW_IMGH-SIZE, null);
		// ����
		g.drawImage(WINDOW_IMG, x, y+h-SIZE, x+SIZE, y+h, 0, WINDOW_IMGH-SIZE, SIZE, WINDOW_IMGH, null);
		// ����
		g.drawImage(WINDOW_IMG, x+SIZE, y+h-SIZE, x+w-SIZE, y+h, SIZE, WINDOW_IMGH-SIZE, WINDOW_IMGW-SIZE, WINDOW_IMGH, null);
		// ����
		g.drawImage(WINDOW_IMG, x+w-SIZE, y+h-SIZE, x+w, y+h, WINDOW_IMGW-SIZE, WINDOW_IMGH-SIZE, WINDOW_IMGW, WINDOW_IMGH, null);
	}
}
