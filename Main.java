package com.csProject.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Main extends Canvas implements Runnable
{
	
	private static final long serialVersionUID = 7062228033778433412L;
	
	private static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9; //HEIGHT = 477
	private Thread thread;
	private boolean running = false;
	
	private Menu menu;
	
	public static enum SCREEN
	{
		Home,
		Input,
		Download
	};
	
	private SCREEN currentScreen = SCREEN.Home;

	public Main()
	{
		new Window(WIDTH, HEIGHT, "Form Formatinator", this);
		
		menu = new Menu(this);
		this.addMouseListener(menu);
		
	}
	
	public synchronized void start()
	{
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop()
	{
		try 
		{
			thread.join();
			running = false;
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void run() 
	{
		this.requestFocus();
		
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		
		while (running)
		{
			long now = System.nanoTime();
			
			delta = (now - lastTime) / ns;
			lastTime = now;
			
			while (delta >= 1)
			{
				tick();
				delta--;
			}
			
			if (running)
			{render();}
			
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000)
			{
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
	}
	
	private void tick()
	{
		render();
	}
	
	private void render()
	{
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.lightGray);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		menu.render(g);
		
		g.dispose();
		bs.show();
		
	}
	
	public SCREEN getScreen()
	{
		return currentScreen;
	}
	
	public void setScreen(SCREEN s)
	{
		if (s == SCREEN.Home || s == SCREEN.Input || s == SCREEN.Download)
		{currentScreen = s;}
		else
		{currentScreen = SCREEN.Home;}
	}
	
	
	public static void main(String[] args)
	{
		new Main();
		
	}
	
}
