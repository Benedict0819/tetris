package ui;

import java.awt.Graphics;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import config.ConfigFactory;
import config.GameConfig;
import config.LayerConfig;
import control.PlayerConcrol;
import dto.GameDto;

public class JPanelGame extends JPanel{

	private static final long serialVersionUID = -4916424649169424601L;
	private List<Layer> layers = null;
	public GameDto dto = null;
	
	public JPanelGame(GameDto dto) {
		
		// ���dto����
		this.dto = dto;
		// ��ʼ�����
		initComponent();
		// ��ʼ����
		initLayer();
	}
	
	/*
	 * ��װ��ҿ�����
	 */
	public void setGameControl(PlayerConcrol control) {
		this.addKeyListener(control);
	}
	
	/*
	 * ��ʼ�����
	 */
	public void initComponent() {

	}
	
	/*
	 * ��ʼ����
	 */
	public void initLayer() {
		try {
			// �����Ϸ����
			GameConfig cfg = ConfigFactory.getGameConfig();
			// ��ò�����
			List<LayerConfig> layersCfg = cfg.getLayersConfig();
			// ������Ϸ������
			layers = new ArrayList<Layer>();
			// �������в����
			for (LayerConfig layerCfg : layersCfg) {
				// ��������
				Class<?> cls = Class.forName(layerCfg.getClassName());
				// ��ù��캯��
				Constructor<?> ctr = cls.getConstructor(int.class, int.class, int.class, int.class);
				// ���ù��캯����������
				Layer layer = (Layer)ctr.newInstance(
						layerCfg.getX(), layerCfg.getY(), layerCfg.getW(), layerCfg.getH()
						);
				// ������Ϸ���ݶ���
				layer.setDto(this.dto);
				// �ѹ����Layer��������б�
				layers.add(layer);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g) {
		// ���û��෽��
		super.paintComponent(g);
		for (Layer layer : layers) {
			layer.paint(g);
		}
		// ���ؽ���
		this.requestFocus();
	}
}
