package com.csProject.main;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;

public class DownloadScreen extends JFrame
{
	
	private static final long serialVersionUID = -7013173759384010995L;
	
	private JLabel labelQuestion;
	private JLabel labelAnswer;
	private JLabel[] fileLine = new JLabel[5];
	private JButton startButton;

	public DownloadScreen()
	{
		super("Form Formatter");
		
		File file = new File("form.txt");
		try 
		{
			Scanner scanner = new Scanner(file);
			for (int i = 0; i < 5; i++)
			{
				fileLine[i] = new JLabel(scanner.nextLine());
			}
			
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		initDownloadScreen();
		
		setSize(400, 200);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	private void initDownloadScreen()
	{
		labelQuestion = new JLabel("File downloaded!");
		labelAnswer = new JLabel("File info:");
		
		setLayout(new FlowLayout());
		
		add(labelQuestion);
		add(labelAnswer);
		
		for(int i = 0; i < 5; i++)
		{
			add(fileLine[i]);
		}
	}
	
}
