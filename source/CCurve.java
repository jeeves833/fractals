package fractals;

import java.awt.*;
import java.awt.geom.*;

public class CCurve extends Fractal {

	public Path2D.Double constructFirstIteration() {
		Path2D.Double start = new Path2D.Double();
		start.moveTo(0, 0);
		start.lineTo(1, 0);
		return start;
	}

	public Path2D.Double nextIteration() {
		Path2D.Double previous = iterations.get(iterations.size() - 1);
		Path2D.Double next = new Path2D.Double(previous);
		AffineTransform r1 = new AffineTransform(0, 1, -1, 0, 1, 0);
		AffineTransform r2 = new AffineTransform(0.5, -0.5, 0.5, 0.5, 0, 0);
		next.append(previous.getPathIterator(r1), false);
		next.transform(r2);
		return next;
	}
}