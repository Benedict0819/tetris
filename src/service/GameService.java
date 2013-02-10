package service;

import java.awt.Point;

import dto.GameDto;
import entity.GameAct;

public class GameService {
	
	private GameDto dto;

	public GameService(GameDto dto) {
		this.dto = dto;
		GameAct act = new GameAct();
		dto.setGameAct(act);		
	}
	
	/*
	 * ���Ƽ����£��ϣ�
	 */
	public void keyUp() {
		// TODO �޸�Ϊ��ת
		if (canMove(0, -1)) {
			this.dto.getGameAct().move(0, -1);
		}
	}
	
	/*
	 * ���Ƽ����£��£�
	 */
	public void keyDown() {
		if (canMove(0, 1)) {
			this.dto.getGameAct().move(0, 1);
		}
	}

	/*
	 * ���Ƽ����£���
	 */
	public void keyLeft() {
		if (canMove(-1, 0)) {
			this.dto.getGameAct().move(-1, 0);
		}
	}

	/*
	 * ���Ƽ����£��ң�
	 */
	public void keyRight() {
		if (canMove(1, 0)) {
			this.dto.getGameAct().move(1, 0);
		}
	}
	
	/*
	 * �߽��ж�
	 */
	private boolean canMove(int moveX, int moveY) {
		Point[] nowPoints = this.dto.getGameAct().getActPoints();
		for (int i = 0; i < nowPoints.length; i++) {
			int newX = nowPoints[i].x + moveX;
			int newY = nowPoints[i].y + moveY;
			// TODO
			if (newX < 0 || newX > 9 || newY < 0 || newY > 17) {
				return false;
			}
		}
		return true;
	}
}
