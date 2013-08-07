package ru.hsm.kutuzoff;

import javax.swing.JFrame;


public class Main {
	public static final String VERSION = "0-0-00.02-pre Alpha";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame f = new JFrame("-=1812 WAR=-");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1200,1000);
		f.add(new Map ());
		f.setVisible(true);
	}

}
