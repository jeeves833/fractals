package fractals;

import java.awt.*;
import java.awt.geom.*;
import java.lang.Math.*;

public class GosperCurve extends Fractal {

	private String lSystem = "A";
	private final String aReplacement = "A-B--B+A++AA+B-";
	private final String bReplacement = "+A-BB--B-A++A+B";
	private double scale = 1.0;

	public Path2D.Double constructFirstIteration() {
		Path2D.Double start = new Path2D.Double();
		start.moveTo(0, 0);
		start.lineTo(1, 0);
		return start;
	}

	public Path2D.Double nextIteration() {
		lSystem = lSystem.replaceAll("A", "%A%").replaceAll("B", "%B%").replaceAll("%A%", aReplacement).replaceAll("%B%", bReplacement);
		scale /= 2;
		// System.out.println(lSystem);
		return parseSystem();
	}

	private Path2D.Double parseSystem() {
		Path2D.Double result = new Path2D.Double();
		double[] currPoint = new double[]{0,0};
		result.moveTo(0, 0);
		double direction = 0;
		for (int i = 0; i < lSystem.length(); i++) {
			char c = lSystem.charAt(i);
			switch (c) {
				case 'A':
				case 'B':
					currPoint[0] += scale * Math.cos(Math.toRadians(direction));
					currPoint[1] += scale * Math.sin(Math.toRadians(direction));
					result.lineTo(currPoint[0], currPoint[1]);
					break;
				case '-':
					direction = (direction - 60) % 360;
					break;
				case '+':
					direction = (direction + 60) % 360;
					break;
			}
		}
		
		return result;
	}
}