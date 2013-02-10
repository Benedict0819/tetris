package main;

import service.GameService;
import ui.JFrameGame;
import ui.JPanelGame;
import control.GameControl;
import control.PlayerConcrol;
import dto.GameDto;

public class Main {
	
	public static void main(String[] args) {
		
		// ������Ϸ����Դ
		GameDto dto = new GameDto();
		// ������Ϸ���
		JPanelGame jPanel = new JPanelGame(dto);
		// ������Ϸ�߼��飨��װ��Ϸ����Դ��
		GameService service = new GameService(dto);
		// ������Ϸ��������������Ϸ�������Ϸ�߼��飩
		GameControl gameControl = new GameControl(jPanel, service);
		// ������ҿ�������������Ϸ��������
		PlayerConcrol control = new PlayerConcrol(gameControl);
		// ��װ��ҿ�����
		jPanel.setGameControl(control);
		// ������Ϸ���ڣ���װ��Ϸ��壩
		new JFrameGame(jPanel);
	}
}
