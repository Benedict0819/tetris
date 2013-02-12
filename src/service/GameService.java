package service;

import java.awt.Point;
import java.util.Random;

import dto.GameDto;
import entity.GameAct;

public class GameService {
	
	private GameDto dto;
	
	// �����������
	private Random random = new Random();
	
	// ��һ������
	private static final int MAX_TYPE = 6; 
	
	public GameService(GameDto dto) {
		this.dto = dto;
		GameAct act = new GameAct();
		dto.setGameAct(act);		
	}
	
	/*
	 * ����������ϣ�
	 */
	public void keyUp() {
		this.dto.getGameAct().round(this.dto.getGameMap());
	}
	
	/*
	 * ����������£�
	 */
	public void keyDown() {
		if (this.dto.getGameAct().move(0, 1, this.dto.getGameMap())) {
			return;
		}
		// �����Ϸ��ͼ����
		boolean[][] map = this.dto.getGameMap();
		// ��÷������
		Point[] act = this.dto.getGameAct().getActPoints();
		// ������ӵ���ͼ
		for (int i = 0; i < act.length; i++) {
			map[act[i].x][act[i].y] = true;
		}
		// �ж�����
		int exp = this.plusExp();
		// ���Ӿ���ֵ
		this.levelUp(exp);
		// ���������һ������
		this.dto.getGameAct().init(this.dto.getNext());
		this.dto.setNext(random.nextInt(MAX_TYPE));
	}

	/*
	 * �����������
	 */
	public void keyLeft() {
		this.dto.getGameAct().move(-1, 0, this.dto.getGameMap());
	}

	/*
	 * ����������ң�
	 */
	public void keyRight() {
		this.dto.getGameAct().move(1, 0, this.dto.getGameMap());
	}
	
	// ���ӷ���
	private void levelUp(int exp) {
		int rmLine = this.dto.getNowRemoveLine();
		rmLine += exp;
		this.dto.setNowRemoveLine(rmLine);
	}
	
	/*
	 * �ӷֲ���
	 */
	private int plusExp() {
		int exp = 0;
		boolean[][] map = this.dto.getGameMap();
		for (int y = 0; y < 18; y++ ) {
			if (isCanRemove(y, map)) {
				this.removeLine(y, map);
				exp++;
			}
		}
		return exp;
	}
	
	/*
	 * ���в���
	 */
	private void removeLine(int rowNumber, boolean[][] map) {
		for (int x = 0; x < 10; x++ ) {
			for (int y = rowNumber; y > 0; y--) {
				map[x][y] = map[x][y-1];
			}
			map[x][0] = false;
		}
	}
	
	/*
	 * �ж�һ���ܷ�����
	 */
	private boolean isCanRemove(int y, boolean[][] map) {
		for (int x = 0; x < 10; x++ ) {
			if (!map[x][y]) {
				return false;
			}
		}
		return true;
	}
}
