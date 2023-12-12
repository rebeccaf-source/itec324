package itec324;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.*;
/**
 * this is the main window, where the checkboxes and buttons will reside
 * @author Rebecca Fonseth
 *
 */
public class MainWindow extends JFrame {
	private SubWindow sw = new SubWindow();

	/**
	 * This is the constructor for the MainWindow
	 */
	public MainWindow() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 4));

		JCheckBox bird = new JCheckBox("BIRD");
		JCheckBox rocket = new JCheckBox("ROCKET");
		JCheckBox ufo = new JCheckBox("UFO");

		// 4 buttons: show, add, pause, exit
		
		//show
		JButton show = new JButton("Show");
		// add event to show
		show.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bird.setSelected(false);
				rocket.setSelected(false);
				ufo.setSelected(false);
				sw = new SubWindow();
				sw.startFrame();
			}
		});

		//add
		JButton add = new JButton("Add");
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//checks what has been checked
				if(bird.isSelected())
				{
					sw.addBird();
				}
				if(rocket.isSelected())
				{
					sw.addRocket();
				}
				if(ufo.isSelected())
				{
					sw.addUFO();
				}
				
			}
		});
		
		//pause
		JButton pause = new JButton("Pause");
		pause.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sw.isPaused(); 
			}
		});
		
		//exit
		JButton exit = new JButton("Exit");
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//closes subwindow
				sw.closeWindow();
				//closes main window
				frame.dispose();
			}
		});
		//adding all to panel
		panel.add(show);
		panel.add(add);
		panel.add(pause);
		panel.add(exit);

		panel.add(bird);
		panel.add(rocket);
		panel.add(ufo);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setSize(500, 400);
		frame.setVisible(true);

		//System.out.println("Hello");
	}

}
