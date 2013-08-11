package ru.hsm.kutuzoff;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public  class InfoLayer {
	
	public static void drawAllInfoLayers(Graphics g)
	{
		drawCurrentWeaponInfo(g);
	}
	
	private static void drawCurrentWeaponInfo(Graphics g)
	{
		Image img = new ImageIcon("res/weapon1.gif").getImage();
		g.setColor(Color.GRAY);
		g.fillRect(350, 650, 40, 60);
		g.setColor(Color.blue);
		g.drawRect(350, 650, 40, 60);
		g.drawImage(img, 350, 650, null);
		
	}

}
