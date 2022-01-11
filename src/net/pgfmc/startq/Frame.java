package net.pgfmc.startq;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame {
	
	private JFrame frame;
	private JLabel progress;
	
	public final void createFrame()
	{
		frame = new JFrame("StartQ");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,100);
		
		JPanel panel = new JPanel(); // the panel is not visible in output
		progress = new JLabel("0");
		JButton cancel = new JButton("Cancel");
		
		/**
		 * An ActionListener that closes the program if the button is clicked
		 */
		cancel.addActionListener(new ActionListener() {
			
			@Override
		    public void actionPerformed(ActionEvent e) {
		        System.out.println("User cancelled the operation.");
		        Main.id = ID.DONE;
		    }
			
		});;
		
		panel.add(progress); // Components Added using Flow Layout
		panel.add(cancel);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}
	
	public final void addProgress(double percent)
	{
		progress.setText(String.valueOf(
				Math.round(
						getProgress() + Math.min(percent, 1.0) * 100
						)
				));
	}
	
	public final Double getProgress()
	{
		return Double.parseDouble(progress.getText());
	}

}
