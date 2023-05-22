package com.csProject.main;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class DownloadScreen extends JFrame implements ActionListener
{
	
	private static final long serialVersionUID = -7013173759384010995L;
	
	private JLabel labelQuestion;
	private JLabel labelAnswer;
	private JTextField field;
	private JButton startButton;

	public DownloadScreen()
	{
		super("Form Formatter");
		initDownloadScreen();
		
		setSize(250, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	private void initDownloadScreen()
	{
		labelQuestion = new JLabel("Click the button to download .txt file");
		labelAnswer = new JLabel("");
		startButton = new JButton("Download");
		
		setLayout(new FlowLayout());
		
		add(labelQuestion);
		add(labelAnswer);
		add(startButton);
		
		
		startButton.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent event) 
	{
		System.out.println("Download Successful!");
		
	}
	
}
