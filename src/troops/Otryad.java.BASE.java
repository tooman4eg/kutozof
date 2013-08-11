package troops;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.ImageIcon;

import ru.hsm.kutuzoff.Direction;
import ru.hsm.kutuzoff.Map;
import ru.hsm.kutuzoff.Shot;

public class Otryad extends Detachment implements Runnable {

	Image img_crushed = new ImageIcon("res/player_crushed.png").getImage();
	Image img_c = new ImageIcon("res/voin.png").getImage();
	Image img_l = new ImageIcon("res/playerr.png").getImage();
	Image img_r = new ImageIcon("res/playerl.png").getImage();

	public Image img = img_c;

	public int layer1 = 0;
	public int layer2 = 1600;
	private int x; // дефолтовые координаты положения отряда
	private int y;// дефолтовые координаты положения отряда

	public static final int MAX_V = 10; // playerOtryad.maxVelocity();
	protected final int MAX_HEALTH_POINTS = 100;
	public final int RELOAD_TIME = 1000; //Время на перезарядку
	public  int velocityX;
	public  int velocityY;
	private int healthPoints;
	private Date reloadTime;
	private boolean reloadStatus;
	public  int bulletVelocity;

	public Otryad() {
		setX(100);
		setY(50);
		bulletVelocity = 24;
		velocityX = 0;
		velocityY = 0;
		setHealthPoints(MAX_HEALTH_POINTS);		
		setReloadStatus(false);
		reloadTime = new Date();				
	}
	

	public Rectangle getRect() {
		return new Rectangle(getX()-img.getWidth(null)/2, getY()-img.getHeight(null)/2, img.getWidth(null)/2, img.getHeight(null)/2);
	}

	
	public void run() {

		try {
			Thread.sleep(100);
			if (healthPoints < MAX_HEALTH_POINTS) {
				healthPoints++;
				System.out.println("здоровье увеличено");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void move(int MAX_BOTTOM_POSITION, int MAX_TOP_POSITION,
			int MAX_RIGHT_POSITION, int MAX_LEFT_POSITION) {

		if (velocityY < -1 * MAX_V) {
			velocityY = -1 * MAX_V;
		}
		if (velocityX < -1 * MAX_V) {
			velocityX = -1 * MAX_V;
		}

		if (velocityX >= MAX_V) {
			velocityX = MAX_V;
		}
		if (velocityY >= MAX_V) {
			velocityY = MAX_V;
		}

		if (getY() >= MAX_BOTTOM_POSITION) {
			setY(MAX_BOTTOM_POSITION);
		}
		if (getY() <= MAX_TOP_POSITION) {
			setY(MAX_TOP_POSITION);
		}
		if (getX() >= MAX_RIGHT_POSITION) {
			setX(MAX_RIGHT_POSITION);
		}
		if (getX() <= MAX_LEFT_POSITION) {
			setX(MAX_LEFT_POSITION);
		}

		setY(getY() + velocityY);
		setX(getX() + velocityX);

	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
			velocityX += 10;
		}

		if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
			velocityX -= 10;
		}

		if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
			velocityY -= 10;
			// img = img_l;
		}

		if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
			velocityY += 10;
			// img = img_r;
		}

	}
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

 

		if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_LEFT
				|| key == KeyEvent.VK_D || key == KeyEvent.VK_A) {
			velocityX = 0;
		}

		if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN
				|| key == KeyEvent.VK_W || key == KeyEvent.VK_S) {
			velocityY = 0;

		}

	}
	
	
	
	public void drawAllofPlayer(Graphics g)
	{
		// draw player
				g.drawImage(img, getX() - img.getWidth(null) / 2, getY()
						- img.getHeight(null) / 2, null);
				g.drawRect(getX()-img.getWidth(null)/2,	getY()-img.getHeight(null)/2,
						img.getWidth(null),	img.getHeight(null));
				
				int radius = img.getWidth(null) / 2;
				g.drawOval(getX()- img.getWidth(null) / 4, getY(), radius, radius);
				
	// draw.player.helth
				g.setColor(Color.GREEN);
				g.drawRect(getX() - img.getWidth(null) / 2,
						getY() - img.getHeight(null) / 2 - 12, 50, 5);
				g.fillRect(getX() - img.getWidth(null) / 2,
						getY() - img.getHeight(null) / 2 - 12,
						getHealthPoints() / 2, 5);
	//draw reload
				Date current = new Date();
				int readyToFight =(int) (RELOAD_TIME -(current.getTime() -getReloadTime().getTime()))/20;
				if (readyToFight<0) readyToFight=0;
				if (readyToFight>50) readyToFight=50;
				
				g.fillRect(getX() - img.getWidth(null) / 2,
						getY() - img.getHeight(null) / 2 - 14,readyToFight , 1);
				}
	
	
	
	
	
	
	public int getX() {
		return x;

	}

	public int getY() {
		return y;

	}

	public int getHealthPoints() {
		return healthPoints;
	}

	public void setHealthPoints(int healthPoints) {
		if (healthPoints>MAX_HEALTH_POINTS) healthPoints =MAX_HEALTH_POINTS;
		if(healthPoints<0) healthPoints =0;
		this.healthPoints = healthPoints;
	}


	public void setX(int x) {
		this.x = x;
	}


	public void setY(int y) {
		this.y = y;
	}


	public Date getReloadTime() {
		return reloadTime;
	}


	public void setReloadTime(Date reloadTime) {
		this.reloadTime = reloadTime;
	}


	public boolean isReloadStatus() {
		return reloadStatus;
	}


	public void setReloadStatus(boolean reloadStatus) {
		this.reloadStatus = reloadStatus;
	}

}
