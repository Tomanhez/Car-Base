package main;

import java.awt.EventQueue;

import front.MainFrame;


public class MainClass {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new MainFrame();				
			}
		});
	}
}
