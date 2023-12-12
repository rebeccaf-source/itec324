package itec324;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Random;

/**
 * this is the sub window class
 * 
 * @author Rebecca Fonseth
 *
 */
public class SubWindow {
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	// for checking if the object has already been added or not
	private boolean bird = false;
	private boolean rocket = false;
	private boolean ufo = false;
	private boolean pause = false;
	// for the timers
	private Random gen = new Random();
	// timers for each object
	private Timer tBird;
	private Timer tRocket;
	private Timer tUFO;
	// for the bird
	private double bx = gen.nextDouble(400) + 100;// so it get's placed randomly
	private double by = gen.nextDouble(400) + 100;
	private double bdx;
	private double bdy;
	// for the rocket
	private double rx = gen.nextDouble(462.5) + 37.5;
	private double ry = gen.nextDouble(462.5) + 37.5;
	private double rdx;
	private double rdy;
	// for the ufo
	private double ux = gen.nextDouble(462.5) + 37.5;
	private double uy = gen.nextDouble(462.5) + 37.5;
	private double udx;
	private double udy;

	/**
	 * the constructor for SubWindow
	 */
	public SubWindow() {
		frame.setLayout(new BorderLayout());
		// exit button
		JButton exit = new JButton("Exit");
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}

		});
		exit.setPreferredSize(new Dimension(500, 40));
		panel.add(exit);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.add(panel);
		frame.setSize(500, 500);
	}

	/**
	 * constructor sets the frame up, but this makes the frame visible to the user
	 */
	public void startFrame() {

		frame.setVisible(true);
		//System.out.println("There");
	}

	/**
	 * this is used for generating random speeds for each object
	 * @return double the speed
	 */
	private double getNextSpeed() {
		return 2 * Math.PI * (0.5 + gen.nextDouble());
	}

	/**
	 * create bird, adds it to the panel, and makes it move randomly
	 */
	public void addBird() {

		if (!bird) {

			Image b = new ImageIcon("C:/Users/rebec/itec324/Project2/src/itec324/bird.png").getImage();
			//makes the image into a manageable size
			Image newB = b.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
			//add its to a label as a image icon
			JLabel label = new JLabel(new ImageIcon(newB));
			panel.add(label);
			frame.add(panel);
			bdx = getNextSpeed();
			bdy = getNextSpeed();

			//System.out.println("Bird in the sky");
			//saying that a bird has been added
			bird = true;

			tBird = new Timer(50, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					bx += bdx;
					by += bdy;
					if (bx + label.getWidth() > frame.getContentPane().getWidth()) {
						//so it wraps around
						bx = 0;
						bdx = getNextSpeed();
					} else if (bx < 0) {
						bx = 0;
						bdx = getNextSpeed();
					}

					if (by + label.getHeight() > frame.getContentPane().getHeight()) {
						by = 0;
						bdy = getNextSpeed();
					} else if (by < 0) {
						by = 0;
						bdy = getNextSpeed();
					}
					//sets the location at every instance of the timer
					label.setLocation((int) bx, (int) by);

				}

			});
			startFrame();
			tBird.start();
		}
	}

	/**
	 * add rocket to the frame
	 */
	public void addRocket() {
		if (!rocket) {
			Image r = new ImageIcon("C:/Users/rebec/itec324/Project2/src/itec324/rocket.jpg").getImage();
			Image newR = r.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
			JLabel label = new JLabel(new ImageIcon(newR));
			// label.setSize(20, 20);
			panel.add(label);
			frame.add(panel);
			//System.out.println("Rocket in the air");
			rocket = true;
			rdx = getNextSpeed();
			rdy = getNextSpeed();

			tRocket = new Timer(50, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					rx += rdx;
					ry += rdy;
					if (rx + label.getWidth() > frame.getContentPane().getWidth()) {
						rx = 0;
						rdx = getNextSpeed();
					} else if (rx < 0) {
						rx = 0;
						rdx = getNextSpeed();
					}

					if (ry + label.getHeight() > frame.getContentPane().getHeight()) {
						ry = 0;
						rdy = getNextSpeed();
					} else if (ry < 0) {
						ry = 0;
						rdy = getNextSpeed();
					}

					label.setLocation((int) rx, (int) ry);

				}

			});
			startFrame();
			tRocket.start();
		}
	}

	/**
	 * add UFO to the frame
	 */
	public void addUFO() {
		if (!ufo) {
			Image u = new ImageIcon("C:/Users/rebec/itec324/Project2/src/itec324/ufo.jpg").getImage();
			Image newU = u.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
			JLabel label = new JLabel(new ImageIcon(newU));
			// label.setSize(20, 20);
			panel.add(label);
			//System.out.println("UFO in the atmosphere");
			ufo = true;
			udx = getNextSpeed();
			udy = getNextSpeed();

			tUFO = new Timer(50, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					ux += udx;
					uy += udy;
					if (ux + label.getWidth() > frame.getContentPane().getWidth()) {
						ux = 0;
						udx = getNextSpeed();
					} else if (ux < 0) {
						ux = 0;
						udx = getNextSpeed();
					}

					if (uy + label.getHeight() > frame.getContentPane().getHeight()) {
						uy = 0;
						udy = getNextSpeed();
					} else if (uy < 0) {
						uy = 0;
						udy = getNextSpeed();
					}

					label.setLocation((int) ux, (int) uy);

				}

			});
			startFrame();
			tUFO.start();
		}
	}

	/**
	 * checks to see if they are paused already or not
	 */
	public void isPaused() {
		if (!pause) {
			//if not paused, pause
			pause = true;
			pauseShapes();
		} else {
			//if paused, start
			pause = false;
			startShapes();
		}
	}

	/**
	 * pause all the shapes in the frame
	 */
	public void pauseShapes() {
		//checks if each object is there or not
		if (bird) {
			tBird.stop();
		}
		if (rocket) {
			tRocket.stop();
		}
		if (ufo) {
			tUFO.stop();
		}
		//System.out.println("You've been paused");
	}

	/**
	 * starts all the objects in the frame
	 */
	public void startShapes() {
		//checks if each object is there or not
		if (bird) {
			tBird.start();
		}
		if (rocket) {
			tRocket.start();
		}
		if (ufo) {
			tUFO.start();
		}
		//System.out.println("You've been unpaused");
	}

	/**
	 * closes the window and disposes the frame
	 */
	public void closeWindow() {
		frame.dispose();
	}
}
