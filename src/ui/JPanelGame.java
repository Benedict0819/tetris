package ui;

import java.awt.Graphics;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import config.ConfigFactory;
import config.GameConfig;
import config.LayerConfig;

public class JPanelGame extends JPanel{

	private static final long serialVersionUID = -4916424649169424601L;
	private List<Layer> layers = null;

	public JPanelGame() {
		
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
				Layer l = (Layer)ctr.newInstance(
						layerCfg.getX(), layerCfg.getY(), layerCfg.getW(), layerCfg.getH()
						);
				// �ѹ����Layer��������б�
				layers.add(l);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g) {
		
		for (Layer layer : layers) {
			layer.paint(g);
		}
	}
}
