package ru.hsm.kutuzoff;

public class Direction {
	private double xDelta=0; //дефолтовое направление пули
	private double yDelta=0;
	
	
	public Direction (int mouseX, int mouseY, int playerX, int playerY)
	{
		int h,l;
		 l=mouseX-playerX;
		 h=mouseY-playerY;
		 if (h<0) h= -1*h;
		 if (l<0) l= -1*l;

		 
		 if(mouseX>playerX)	
		 	{
			 	this.xDelta = (double)l/ Math.sqrt(h*h+l*l); 
			 }
		 else  if(mouseX==playerX) this.xDelta=0;
		 	else  this.xDelta = (double)(-l)/ Math.sqrt(h*h+l*l);
		 
		 if(mouseY>playerY) this.yDelta = (double)h/ Math.sqrt(h*h+l*l);
		 else  if(mouseY==playerY) this.yDelta=0;
		 	else  this.yDelta =(double) (-h)/ Math.sqrt(h*h+l*l); 
		 
		
	}
	
	
	public double getDeltaX() {
		return xDelta;
	}
	
	
	
	public double getDeltaY() {
		return yDelta;
	}
	
	
	
	

}
