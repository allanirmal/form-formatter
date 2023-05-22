package com.csProject.main;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HomeScreen extends JFrame implements ActionListener
{
	
	private static final long serialVersionUID = -7013173759384010995L;
	
	private JLabel labelQuestion;
	private JLabel labelAnswer;
	private JTextField field;
	private JButton startButton;

	public HomeScreen()
	{
		super("Form Formatter");
		initHomeScreen();
		
		setSize(200, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	private void initHomeScreen()
	{
		labelQuestion = new JLabel("Form Formatter");
		labelAnswer = new JLabel("Home Screen");
		startButton = new JButton("Start");
		
		setLayout(new FlowLayout());
		
		add(labelQuestion);
		add(labelAnswer);
		add(startButton);
		
		
		startButton.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent event) 
	{
		System.out.println("clicked");
		new InputScreen().setVisible(true);
		
	}
	
	
	public static void main(String[] args)
	{
		new HomeScreen().setVisible(true);
	}

	

	
}
