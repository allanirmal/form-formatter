package com.csProject.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.csProject.main.Main.SCREEN;

public class Menu extends MouseAdapter{
	
	private Main main;
	
	public Menu(Main main)
	{
		this.main = main;
	}
	
	public void mousePressed(MouseEvent e)
	{
		int mouseX = e.getX();
		int mouseY = e.getY();
		
		if (main.getScreen() == SCREEN.Home)
		{
			if (mouseOver(mouseX, mouseY, 225, 300, 200, 75))
			{
				main.setScreen(SCREEN.Input);
			}
		}
		
		else if (main.getScreen() == SCREEN.Input)
		{
			if (mouseOver(mouseX, mouseY, 225, 350, 200, 75))
			{
				main.setScreen(SCREEN.Download);
			}
			
			if (mouseOver(mouseX, mouseY, 0, 0, 70, 40))
			{
				main.setScreen(SCREEN.Home);
			}
		}
		
		else if (main.getScreen() == SCREEN.Download)
		{
			if (mouseOver(mouseX, mouseY, 0, 0, 70, 40))
			{
				main.setScreen(SCREEN.Input);
			}
		}
		
	}
	
	public void mouseReleased(MouseEvent e)
	{
		
	}
	
	private boolean mouseOver(int mouseX, int mouseY, int x, int y, int width, int height)
	{
		if (mouseX >= x && mouseX <= x + width)
		{
			if (mouseY >= y && mouseY <= y + height)
			{
				return true;
			}
		}
		return false;
	}
	
	public void tick()
	{
		
	}
	
	public void render(Graphics g)
	{
		Font large = new Font("Arial", 1, 30);
		Font medium = new Font("Arial", 1, 20);
		
		g.setFont(large);
		g.setColor(Color.black);
		
		
		if (main.getScreen() == SCREEN.Home)
		{
			g.drawString("Home Screen", 225, 100);
			
			//start button box
			g.fillRect(225, 300, 200, 75);
			g.setColor(Color.gray);
			g.fillRect(229, 304, 192, 67);
			
			//start button text
			g.setColor(Color.black);
			g.drawString("START", 275, 350);
		}
		else if (main.getScreen() == SCREEN.Input)
		{
			g.drawString("Input Screen", 225, 50);
			g.setFont(medium);
			g.drawString("*Place page content here*", 200, 100);
			
			//finish button box
			g.fillRect(225, 350, 200, 75);
			g.setColor(Color.gray);
			g.fillRect(229, 354, 192, 67);
			
			//finish button text
			g.setColor(Color.black);
			g.setFont(large);
			g.drawString("Finish", 275, 400);
		}
		else if (main.getScreen() == SCREEN.Download)
		{
			g.drawString("Download Screen", 200, 50);
			g.setFont(medium);
			g.drawString("*Place download stuff here (idk lol)*", 150, 100);
			
			//download button box
			g.fillRect(225, 350, 200, 75);
			g.setColor(Color.gray);
			g.fillRect(229, 354, 192, 67);
			
			//download button text
			g.setColor(Color.black);
			g.setFont(large);
			g.drawString("Download", 250, 400);
		}
		
		if (main.getScreen() != SCREEN.Home)
		{
			int[] xPoints = {10, 30, 30};
			int[] yPoints = {20, 10, 30};
			g.fillRect(30, 15, 30, 10);
			g.fillPolygon(xPoints, yPoints, 3);
		}
		
	}
	
}
