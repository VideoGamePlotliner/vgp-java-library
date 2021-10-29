package vgp.dispose;

/**
 * An object that will permanently, flawlessly, idempotently
 * release resources.
 * <p>
 * A disposed object should disallow all method calls that would
 * access or modify its attributes.
 * <p>
 * As mentioned above, this disposal must be...
 * <ol>
 * <li>Permanent: this object cannot be un-disposed.
 * <li>Flawless: the {@link #dispose()} method cannot throw any instances of {@link Throwable}.
 * <li>Idempotent: if called a second time, the {@link #dispose()} method does nothing.
 * </ol>
 * <p>
 * Example:
 * <pre>
 * import java.util.Objects;
 *
 * public class Matrix implements Disposable {
 *
 *     private double[][] data;
 *
 *     public Matrix(int rowCount, int colCount) {
 *         if (rowCount &lt;= 0) {
 *             throw new IllegalArgumentException("Nonpositive row count: " + rowCount);
 *         }
 *         if (colCount &lt;= 0) {
 *             throw new IllegalArgumentException("Nonpositive column count: " + colCount);
 *         }
 *         try {
 *             data = new double[rowCount][colCount];
 *         } catch (RuntimeException | Error e) {
 *             // No need to let this object hog any memory
 *             // if its constructor didn't even finish!
 *             this.dispose();
 *             throw e;
 *         }
 *     }
 *
 *     &#64;Override
 *     public void dispose() {
 *         if (data != null) {
 *             for (int i = 0; i &lt; data.length; i++) {
 *                 data[i] = null;
 *             }
 *             data = null;
 *         }
 *     }
 *
 *     &#64;Override
 *     public boolean isDisposed() {
 *         return data == null;
 *     }
 *
 *     // This class uses ZERO-based indices.
 *     public double get(int row, int col) throws IndexOutOfBoundsException {
 *
 *         verifyNotDisposed(); // IMPORTANT!!!
 *
 *         final int ROW_COUNT = data.length;
 *         final int COL_COUNT = data[0].length;
 *         Objects.checkIndex(row, ROW_COUNT);
 *         Objects.checkIndex(col, COL_COUNT);
 *         return data[row][col];
 *     }
 * }
 * </pre>
 *
 * @author John Bues
 * @version 1.4
 * @since 1.4
 */
public interface Disposable {

	/**
	 * Delete all of this object's fields' values.
	 * <p>
	 * As mentioned in this class's description, this disposal must be...
	 * <ol>
	 * <li>Permanent: this object cannot be un-disposed.
	 * <li>Flawless: this method cannot throw any instances of {@link Throwable}.
	 * <li>Idempotent: if called a second time, this method does nothing.
	 * </ol>
	 */
	void dispose();

	/**
	 * Find out whether this object can be used at all anymore.
	 * <p>
	 * If not, then it is disposed. If so, then it is not disposed.
	 *
	 * @return {@code true} if this object is disposed as defined above; {@code false} otherwise
	 */
	boolean isDisposed();

	/**
	 * Verify that this object can be used at all anymore.
	 * <p>
	 * If not, then throw an exception. If so, then do nothing.
	 *
	 * @throws IllegalStateException if this object is disposed as defined above
	 */
	default void verifyNotDisposed() {
		if (this.isDisposed()) {
			throw new IllegalStateException("This object is disposed");
		}
	}

}




/*

// A mere example
class Matrix implements Disposable {

	private double[][] data;

	public Matrix(int rowCount, int colCount) {
		if (rowCount <= 0) {
			throw new IllegalArgumentException("Nonpositive row count: " + rowCount);
		}
		if (colCount <= 0) {
			throw new IllegalArgumentException("Nonpositive column count: " + colCount);
		}
		try {
			data = new double[rowCount][colCount];
		} catch (RuntimeException | Error e) {
			// No need to let this object hog any memory
			// if its constructor didn't even finish!
			this.dispose();
			throw e;
		}
	}

	@Override
	public void dispose() {
		if (data != null) {
			for (int i = 0; i < data.length; i++) {
				data[i] = null;
			}
			data = null;
		}
	}

	@Override
	public boolean isDisposed() {
		return data == null;
	}

	// This class uses ZERO-based indices.
	public double get(int row, int col) throws IndexOutOfBoundsException {

		verifyNotDisposed(); // IMPORTANT!!!

		final int ROW_COUNT = data.length;
		final int COL_COUNT = data[0].length;
		Objects.checkIndex(row, ROW_COUNT);
		Objects.checkIndex(col, COL_COUNT);
		return data[row][col];
	}
}

*/