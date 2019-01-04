import java.util.concurrent.locks.StampedLock;

public class Point {
	private double x, y;
	private final StampedLock sl = new StampedLock();

	void move(double deltaX, double deltaY) {
		long stamp = this.sl.writeLock();
		try {
			x += deltaX;
			y += deltaY;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.sl.unlockWrite(stamp);
		}
	}

	double distanceFromOrigin() {
		long stamp = this.sl.tryOptimisticRead();
		double currentX = x, currentY = y;
		if (!sl.validate(stamp)) {
			stamp = sl.readLock();
			try {
				currentX = x;
				currentY = y;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				sl.unlockRead(stamp);
			}
		}
		return Math.sqrt(currentX * currentX + currentY * currentY);
	}

}
