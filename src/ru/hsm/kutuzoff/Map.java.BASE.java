package ru.hsm.kutuzoff;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import troops.Otryad;

public class Map extends JPanel implements ActionListener {

	Timer mainTimer = new Timer(20, this);
	Image img = new ImageIcon("res/defaultmap.jpg").getImage();

	Otryad p = new Otryad();
	Enemies enemy1 = new Enemies();
	public Bullets bulletsList = new Bullets();

	public Map() {
		mainTimer.start();
		Thread otryadThread = new Thread(p);
		Thread enemyThread = new Thread(enemy1);
		otryadThread.start();
		enemyThread.start();
		addKeyListener(new MyKeyAdapter());
		addMouseListener(new MyMouseAdapter());
		setFocusable(true);
	}

	public void paint(Graphics g) {
		g = (Graphics2D) g;
		g.drawImage(img, 0, 0, null);
		g.drawRect(0, 0, 1000, 1000);

		p.drawAllofPlayer(g);

		g.drawImage(enemy1.img, enemy1.getX(), enemy1.getY(), null);
		g.setColor(Color.RED);
		g.drawRect(enemy1.getX(), enemy1.getY() - 12, 50, 5);
		g.fillRect(enemy1.getX(), enemy1.getY() - 12,
				(int) (enemy1.getHealthPoints() / 2), 5);
		bulletsList.draw(g);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		p.move(900, 50, 1000, 50);
		enemy1.move(900, 50, 1000, 50);
		bulletsList.move();
		checkCollision();
		System.out.println(bulletsList.bulls.size());
		repaint();

	}

	public void checkCollision() {
		Iterator<Shot> i = bulletsList.bulls.iterator();

		while (i.hasNext()) {
			Shot pulya = i.next();
			if (pulya.getRect().intersects(p.getRect())) {
				System.out.println("Игрок получил попадание");
				p.setHealthPoints(p.getHealthPoints() - pulya.getDamage());
				 i.remove();
			}
			if (pulya.getRect().intersects(enemy1.getRect())) {
				System.out.println("Противник получил попадание");
				enemy1.setHealthPoints(enemy1.getHealthPoints()
						- pulya.getDamage());
				 i.remove();
			}

		}

	}

	
	private class MyMouseAdapter extends MouseAdapter {

		public void mouseClicked(MouseEvent e) {

			if (e.getButton() == MouseEvent.BUTTON1) {
				
				System.out.println("mouse" + e.getButton());

				int x = e.getX();
				int y = e.getY();
				int realPX;
				int realPy;

				if (x > p.getX()) {
					if (y > p.getY()) {
						realPX = p.getX() + p.img.getWidth(null) / 2 + 5;
						realPy = p.getY() + p.img.getWidth(null) / 2 + 5;
					} else {
						realPX = p.getX() + p.img.getWidth(null) / 2 + 5;
						realPy = p.getY() - p.img.getWidth(null) / 2 - 5;
					}
				} else {
					if (y > p.getY()) {
						realPX = p.getX() - p.img.getWidth(null) / 2 - 5;
						realPy = p.getY() + p.img.getWidth(null) / 2 + 5;
					} else {
						realPX = p.getX() - p.img.getWidth(null) / 2 - 5;
						realPy = p.getY() - p.img.getWidth(null) / 2 - 5;
					}

				}
				
				Direction dir = new Direction(x, y, realPX, realPy);
				Shot bullet = new Shot(realPX, realPy, dir, p.bulletVelocity, 1, 1);

				Date current = new Date();
				if( current.getTime() -p.getReloadTime().getTime() > p.RELOAD_TIME )
				{
					p.setReloadStatus(false);
				}
				
				if(!p.isReloadStatus())
				{
				bulletsList.addShot(bullet);
				p.setReloadStatus(true);// выстрелили и перезаряжаем
				p.setReloadTime(new Date());//выставляем время начала перезарядки
				
				}
				
					
				
				
			}

		}

	}

	
	private class MyKeyAdapter extends KeyAdapter {

		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			addMouseListener(new MyMouseAdapter());
			if (key == KeyEvent.VK_SPACE) {

			}
			p.keyPressed(e);
		}

		public void keyReleased(KeyEvent e) {
			p.keyReleased(e);
		}

	}

}
