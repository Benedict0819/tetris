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
}
