package ru.hsm.kutuzoff;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.LinkedList;

public class Bullets {
	public static LinkedList<Shot> bulls = new LinkedList<Shot>();

	public Bullets() {

	}

	
	public void addShot(Shot shot) {		
		bulls.add(shot);
	}

	public void draw(Graphics g) {
		for (int i = 0; i < bulls.size(); i++) {
			bulls.get(i).draw(g);
		}
	}

	public void move() {
		for (int i = 0; i < bulls.size(); i++) {
			bulls.get(i).move();
		}
		
		// чистим всех, кто вышел за пределы экрана
		if (bulls.size() > 0)
			clearOOBBullets(900, 0, 1100, 0);
		//System.out.println("Отрисовано выстрелов:"+bulls.size());
	}

	private void clearOOBBullets(int MAX_BOTTOM_POSITION, int MAX_TOP_POSITION,
			int MAX_RIGHT_POSITION, int MAX_LEFT_POSITION) {

		Iterator<Shot> iter = bulls.iterator();

		while (iter.hasNext()) {
		
		//it( iter.next().getBulletX() instanceof Integer)
		Shot pill = iter.next();		 
	//System.out.println("координата х ="+pill.getBulletX()+"координата Y ="+pill.getBulletY());				

			
			if	(pill.getBulletX() > MAX_BOTTOM_POSITION ||
				pill.getBulletX() < MAX_TOP_POSITION	 || 
				pill.getBulletY() < MAX_LEFT_POSITION 	 || 
				pill.getBulletY() > MAX_RIGHT_POSITION) 
				{
					iter.remove();
				}

		}

	}
}