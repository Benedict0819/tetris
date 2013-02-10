package control;

import service.GameService;
import ui.JPanelGame;

public class GameControl {
	/*
	 * ��Ϸ�����
	 */
	private JPanelGame panelGame;
	/*
	 * ��Ϸ�߼���
	 */
	private GameService gameService;
	
	public GameControl(JPanelGame panelGame, GameService gameService) {
		this.panelGame = panelGame;
		this.gameService = gameService;
	}
	
	/*
	 * ���Ƽ����£��ϣ�
	 */
	public void keyUp() {
		this.gameService.keyUp();
		this.panelGame.repaint();
	}
	
	/*
	 * ���Ƽ����£��£�
	 */
	public void keyDown() {
		this.gameService.keyDown();
		this.panelGame.repaint();
	}

	/*
	 * ���Ƽ����£���
	 */
	public void keyLeft() {
		this.gameService.keyLeft();
		this.panelGame.repaint();
	}

	/*
	 * ���Ƽ����£��ң�
	 */
	public void keyRight() {
		this.gameService.keyRight();
		this.panelGame.repaint();
	}
}
