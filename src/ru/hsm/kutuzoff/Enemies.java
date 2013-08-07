package ru.hsm.kutuzoff;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.Date;
import java.util.Random;

import javax.swing.ImageIcon;

import troops.Detachment;
import troops.Otryad;

public class Enemies extends Otryad {

	
	private static int changeDirectionDelay = 1000; // m seconds
	private static Date startTime;
	private static Date endTime;


	private Image img_c = new ImageIcon("res/voin2.png").getImage();
	public Image img = img_c;
	
		
	public Enemies() {
		setX(900);
		setY(900);
		velocityX = 0;
		velocityY = 0;
		setHealthPoints(MAX_HEALTH_POINTS);
		reloadTimer();
	}

	@Override	
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

		Date currentTime = new Date();

		if (currentTime.after(endTime)) {
			Random rand = new Random();
			velocityY += rand.nextInt(20) - 10;
			velocityX += rand.nextInt(20) - 10;
			setY(getY() + velocityY);
			setX(getX() + velocityX);// +rand.nextInt(20)-10;
			this.reloadTimer();
		} else {
			setY(getY() + velocityY);
			setX(getX() + velocityX);
		}
	}

	private void reloadTimer() {
		startTime = new Date();
		endTime = new Date(startTime.getTime() + changeDirectionDelay);
	}

}
