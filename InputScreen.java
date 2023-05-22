package com.csProject.main;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class InputScreen extends JFrame implements ActionListener
{
	
	private static final long serialVersionUID = -7013173759384010995L;
	
	private JLabel labelHeading;
	private JLabel[] labelQuestions = new JLabel[5];
	private JTextField[] textBoxes = new JTextField[5];
	private JButton finishButton;

	public InputScreen()
	{
		super("Form Formatter");
		initInputScreen();
		
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	private void initInputScreen()
	{
		labelHeading = new JLabel("Enter the following information: ");
		
		labelQuestions[0] = new JLabel("Customer Name: ");
		labelQuestions[1] = new JLabel("Customer Address: ");
		labelQuestions[2] = new JLabel("Date of Test: ");
		labelQuestions[3] = new JLabel("Time of Test: ");
		
		textBoxes[0] = new JTextField(14);
		textBoxes[1] = new JTextField(20);
		textBoxes[2] = new JTextField(14);
		textBoxes[3] = new JTextField(14);
				
		finishButton = new JButton("Finish");
		
		setLayout(new FlowLayout());
		
		add(labelHeading);
		for (int i = 0; i < 4; i++)
		{
			add(labelQuestions[i]);
			add(textBoxes[i]);
		}
		
		add(finishButton);
		
		
		finishButton.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent event) 
	{
		System.out.println("clicked");
		new DownloadScreen().setVisible(true);
		
	}
	
}

