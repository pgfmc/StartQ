package net.pgfmc.startq.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OutputWindow extends JFrame {
	
	private static final long serialVersionUID = -2413654749837794587L;
	
	private JLabel outputText;
	private JPanel panel = new JPanel();
	
	public OutputWindow()
	{
		super("StartQ");
		
		outputText = new JLabel("StartQ initializing...");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,100);
		
		JButton cancel = new JButton("Cancel");
		
		/**
		 * An ActionListener that closes the program if the button is clicked
		 */
		cancel.addActionListener(new ActionListener() {
			
			@Override
		    public void actionPerformed(ActionEvent e) {
				put("Aborting...");
				System.exit(0);
		    }
			
		});
		
		// Components Added using Flow Layout
		panel.add(cancel);
		panel.add(outputText);
		add(panel);
		
		setVisible(true);
		
		put("StartQ initialized!");
		
	}
	
	public void put(String message)
	{
		panel.add(new JLabel("\n" + message));
	}

}
