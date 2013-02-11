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
		// TODO �޸�Ϊ��ת
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
		// TODO �ж��Ƿ�������� ���� �Ʒ� �Ƿ�����
		// ˢ��һ���µķ���
		this.dto.getGameAct().init(random.nextInt(MAX_TYPE));
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
}
