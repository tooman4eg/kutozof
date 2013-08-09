package ru.hsm.kutuzoff;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Shot {
	private double x;
	private double y;
	private Direction direct;// направление  выстрела
	private int velocity;
	private int damage; // - убойная сила
	private int breach;
	public Image img_c = new ImageIcon("res/bullet2.png").getImage();

	public Shot(int x, int y, Direction dir, int velocity, int damage, int breach )
	{
		this.breach =1;//breach;
		this.setDamage(7); //damage;
		this.direct = dir;
		this.velocity = velocity;
		//if(x>dir.getDeltaX()) 
			this.x = x;
		this.y = y;

		
	}
	public Rectangle getRect() {
		return new Rectangle( (int)x, (int)y, 4, 4);
	}
	
	public void draw(Graphics g)
	{
	
		g.drawImage(img_c, (int)x, (int)y, null);
	//System.out.println("пуля отрисована");
	}
	
	public double  getBulletX()
	{
		return x;
	}
	public double  getBulletY()
	{
		return y;
	}
	
	public int  getBulletVelocity()
	{
		return velocity;
	}
	
	public void move()
	{
		x  += velocity * direct.getDeltaX();
		y  += velocity* direct.getDeltaY();
		
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
}
