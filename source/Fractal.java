package fractals;

import java.awt.geom.*;
import java.util.ArrayList;
import java.awt.*;

public abstract class Fractal {

	protected ArrayList<Path2D.Double> iterations;
	protected int currIteration;

	public Fractal() {
		iterations = new ArrayList<Path2D.Double>();
		currIteration = 0;
		iterations.add(constructFirstIteration());
	}

	public void drawTo(Graphics2D g2d, double[] p1, double[] p2) {
		AffineTransform t = new AffineTransform(p2[0]-p1[0], p2[1]-p1[1], p2[1]-p1[1], p1[0]-p2[0], p1[0], p1[1]);
		g2d.draw(new Path2D.Double(iterations.get(currIteration), t));
	}

	public void stepDown() {
		if (currIteration > 0) {
			currIteration--;
		} 
		// System.out.println(currIteration);
	}

	public void stepUp() {
		currIteration++;
		if (iterations.size() <= currIteration) {
			iterations.add(nextIteration());
		}
		// System.out.println(currIteration);
	}

	abstract Path2D.Double constructFirstIteration();
	abstract Path2D.Double nextIteration();
}