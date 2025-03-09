package Eredua;
import java.util.Scanner;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teklatua implements KeyListener {
	private static Teklatua nireTeklatua = null;
	private Scanner sc;
	
	public static Teklatua getNireTeklatua() {
		if (nireTeklatua == null) {
			nireTeklatua = new Teklatua();
		}
		return nireTeklatua; 
	}
	
	private Teklatua() {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			System.out.println("UP");
		}
	}
		// TODO Auto-generated method stu

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


}
