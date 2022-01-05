package net.pgfmc.startq;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.pgfmc.startq.api.StartQ;
import net.pgfmc.startq.listeners.OnServerStart;

public class Main extends StartQ {
	
	public static State state = State.ONLINE;
	
	public enum State {
		ONLINE,
		OFFLINE
	};
	
	@Override
	public void onEnable()
	{
		/*
		 * Register listeners
		 */
		getStartQManager().register(new OnServerStart());
	}
	
	public static void main(String args[])
	{
		JFrame frame = new JFrame("My First GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		//JButton button = new JButton("Press");
		/*
		frame.getContentPane().add(button); // Adds Button to content pane of frame
		frame.getContentPane().add(new JButton("Press 2"));
		frame.getContentPane().add(new JButton("Press 3"));
		frame.getContentPane().add(new JButton("Press 4"));
		*/
		
		JPanel panel = new JPanel(); // the panel is not visible in output
		JLabel label = new JLabel("Enter Text");
		JTextField tf = new JTextField(10); // accepts upto 10 characters
		JButton send = new JButton("Send");
		JButton reset = new JButton("Reset");
		panel.add(label); // Components Added using Flow Layout
		panel.add(tf);
		panel.add(send);
		panel.add(reset);
		
		frame.getContentPane().add(panel);
		
		frame.setVisible(true);
		
		// System.out.println(serverListening("192.168.1.148", 25565));
	}
}
