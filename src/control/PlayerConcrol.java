package control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlayerConcrol extends KeyAdapter{
	
	private GameControl gameControl;
	
	public PlayerConcrol(GameControl gameControl) {
		this.gameControl = gameControl;
	}
	
	/*
	 * ���̰�����Ϣ
	 * @see java.awt.event.KeyAdapter#keyPressed(java.awt.event.KeyEvent)
	 */
	public void keyPressed(KeyEvent e) {
		e.getKeyCode();
	}
}
