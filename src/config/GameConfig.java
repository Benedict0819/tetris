package config;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class GameConfig {
	
	private int windowUp;
	private int width;
	private int height;
	private int padding;
	private int windowSize;
	private String title;
	
	private List<LayerConfig> layersConfig;
	
	public static void main(String[] args) {
		ConfigFactory.getGameConfig();
	}
	
	/*
	 * ��ȡȫ����Ϸ����
	 */
	public GameConfig() throws DocumentException {
		// ����XML��ȡ��
		SAXReader reader = new SAXReader();
		// ��ȡXML�ļ�
		Document doc = reader.read("config/cfg.xml");
		// ��ȡXML�ļ��ĸ��ڵ�
		Element game = doc.getRootElement();
		// ���ô��ڲ���
		this.setUiConfig(game.element("frame"));
		// ����ϵͳ����
		this.setSystemConfig(game.element("system"));
		// �������ݷ��ʲ���
		this.setDataConfig(game.element("data"));
	}

	@SuppressWarnings("unchecked")
	private void setUiConfig(Element frame) {
		
		// ��ȡ���ڱ���
		this.title = frame.attributeValue("title");
		// ��ȡ���ڰθ�
		this.windowUp = Integer.parseInt(frame.attributeValue("windowUp"));
		// ��ȡ���ڿ��
		this.width = Integer.parseInt(frame.attributeValue("width"));
		// ��ȡ���ڸ߶�
		this.height = Integer.parseInt(frame.attributeValue("height"));
		// ��ȡ�߿��ڱ߾�
		this.padding = Integer.parseInt(frame.attributeValue("padding"));
		// ��ȡ���ڴ�ϸ
		this.windowSize = Integer.parseInt(frame.attributeValue("windowSize"));
		
		// ��ȡ��������
		List<Element> layers = frame.elements("layer");
		layersConfig = new ArrayList<LayerConfig>();
		for (Element layer : layers) {
			LayerConfig lc = new LayerConfig(
					layer.attributeValue("className"),	
					Integer.parseInt(layer.attributeValue("x")),
					Integer.parseInt(layer.attributeValue("y")),
					Integer.parseInt(layer.attributeValue("w")),
					Integer.parseInt(layer.attributeValue("h")) );
			layersConfig.add(lc);
		}
	}
	
	public int getWindowUp() {
		return windowUp;
	}
	
	public String getTitle() {
		return title;
	}

	private void setDataConfig(Element element) {
		// �Զ����ɵķ������
		
	}

	private void setSystemConfig(Element element) {
		// �Զ����ɵķ������
		
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getPadding() {
		return padding;
	}

	public int getWindowSize() {
		return windowSize;
	}

	public List<LayerConfig> getLayersConfig() {
		return layersConfig;
	}
}
