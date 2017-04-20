package fractals;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.awt.geom.*;

public class FractalViewer {

	private JFrame mainFrame;
	private JLabel imageLabel;
	private JLabel titleLabel;
	private BufferedImage canvas;
	private Graphics2D g2d;
	private double[] p1;
	private double[] p2;

	public FractalViewer() {
		p1 = new double[]{160, 180};
		p2 = new double[]{320, 180};
		prepareGUI();
		int level = 8;
		DragonCurve dragon = new DragonCurve();
		for (int i = 0; i < level; i++) {
			// System.out.println(i);
			dragon.stepUp();
		}
		System.out.println("done");
		dragon.drawTo(g2d, p1, p2);

		// Path2D.Double path = new Path2D.Double();
		// path.moveTo(0, 0);
		// path.lineTo(300, 300);
		// // System.out.println(g2d.getColor());
		// g2d.draw(path);
	}

	public static void main(String[] args) {
		FractalViewer fractalViewer = new FractalViewer();
	}

	private void prepareGUI() {
		mainFrame = new JFrame("Fractal Viewer 1.0");
		mainFrame.setSize(480, 360);
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}        
		});
		titleLabel = new JLabel("Dragon Curve", JLabel.CENTER);
		mainFrame.add(titleLabel, BorderLayout.PAGE_START);
		canvas = new BufferedImage(480, 360, BufferedImage.TYPE_INT_RGB);
		g2d = canvas.createGraphics();
		g2d.fillRect(0, 0, 480, 360);
		imageLabel = new JLabel(new ImageIcon(canvas));
		mainFrame.add(imageLabel);
		g2d.setPaint(new Color(0));
		mainFrame.setVisible(true);
	}

	private void clearGUI() {
		g2d.setPaint(new Color(0xFFFFFF));
		g2d.fillRect(0, 0, 480, 360);
	}
}