package vgp.sample;

import java.util.Objects;

/**
 * A general base class that directly extends {@code Object}.
 * This class overrides the {@code hashCode}, {@code equals},
 * and {@code toString} methods, but neither {@code clone} nor
 * {@code finalize}.
 * <p>
 * Due to Java's single inheritance structure, most subclasses
 * will actually extend a <em>different</em> base class instead
 * on <em>this</em> one. This class is more for experimentation
 * and practice with documenting and overriding than actual,
 * practical use.
 * <p>
 * This class's module's documentation specifies that this module's
 * classes should generally either "define new functionality or
 * redefine existing functionality." <em>This</em> class defines new
 * functionality by adding various fields (accessible to outsiders
 * via getters and setters) and methods that {@code Object} doesn't
 * have. Moreover, this class also redefines existing functionality
 * by overriding the {@code Object} methods mentioned above.
 * 
 * @author John Bues
 * @version 1.2
 * @since 1.2
 */
public class ObjectBase {

	/*
	 * Private instance fields
	 */

	/**
	 * The x-coordinate of this object, corresponding to
	 * an integer on the real number line.
	 * <p>
	 * Of course, given that this coordinate is defined
	 * as an {@code int}, it can be no less than {@link
	 * Integer#MIN_VALUE} and no greater than {@link
	 * Integer#MAX_VALUE}.
	 */
	private int x;

	/**
	 * If {@code true}, this object should be called "good."
	 * Otherwise, this object should be called "bad."
	 */
	private boolean good;
	
	/**
	 * The label text of this object.
	 * <p>
	 * Imagine that this object is to be used for a GUI's real
	 * number line. In that case, this text determines what the
	 * label for this object's x-coordinate should display.
	 * Furthermore, {@code null} and the empty string each will
	 * likely result in an empty label, depending on the GUI's
	 * specification.
	 */
	private String text;
	
	/*
	 * Constructors
	 */
	
	/**
	 * Constructs a new {@code ObjectBase}
	 * with the <em>default</em> x-coordinate,
	 * goodness, and label text.
	 */
	public ObjectBase() {
		super();
	}

	/**
	 * Constructs a new {@code ObjectBase}
	 * with the <em>specified</em> x-coordinate,
	 * goodness, and label text.
	 * 
	 * @param x    initial value for the x-coordinate
	 * @param good initial value for the goodness
	 * @param text initial value for the label text
	 */
	public ObjectBase(int x, boolean good, String text) {
		super();
		this.x = x;
		this.good = good;
		this.text = text;
	}
	

	/*
	 * Get methods
	 */

	/**
	 * Returns the x-coordinate of this object,
	 * corresponding to an integer on the real number line.
	 * <p>
	 * Of course, given that this coordinate is defined
	 * as an {@code int}, it can be no less than {@link
	 * Integer#MIN_VALUE} and no greater than {@link
	 * Integer#MAX_VALUE}.
	 * 
	 * @return the x-coordinate of this object
	 */
	public int getX() {
		return x;
	}

	/**
	 * Returns the goodness of this object.
	 * <p>
	 * If {@code true} is returned, this object should
	 * be called "good." Otherwise, this object should
	 * be called "bad."
	 * 
	 * @return {@code true} if this object is "good";
	 *         {@code false} if this object is "bad"
	 */
	public boolean isGood() {
		return good;
	}


	/**
	 * Returns the label text of this object.
	 * <p>
	 * Imagine that this object is to be used for a GUI's real
	 * number line. In that case, this text determines what the
	 * label for this object's x-coordinate should display.
	 * Furthermore, {@code null} and the empty string each will
	 * likely result in an empty label, depending on the GUI's
	 * specification.
	 * 
	 * @return the text suitable for a GUI label at this object's
	 *         x-coordinate
	 */
	public String getText() {
		return text;
	}

	/*
	 * Set methods
	 */

	/**
	 * Sets the x-coordinate of this object, corresponding
	 * to an integer on the real number line.
	 * <p>
	 * Of course, given that this coordinate is defined
	 * as an {@code int}, it can be no less than {@link
	 * Integer#MIN_VALUE} and no greater than {@link
	 * Integer#MAX_VALUE}.
	 * 
	 * @param x the new x-coordinate of this object
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Sets the goodness of this object.
	 * <p>
	 * If {@code true}, this object should be called "good."
	 * Otherwise, this object should be called "bad."
	 * 
	 * @param good {@code true} if this object is now "good";
	 *             {@code false} if this object is now "bad"
	 */
	public void setGood(boolean good) {
		this.good = good;
	}

	/**
	 * Sets the label text of this object.
	 * <p>
	 * Imagine that this object is to be used for a GUI's real
	 * number line. In that case, this text determines what the
	 * label for this object's x-coordinate should display.
	 * Furthermore, {@code null} and the empty string each will
	 * likely result in an empty label, depending on the GUI's
	 * specification.
	 * 
	 * @param text the new label text of this object
	 */
	public void setText(String text) {
		this.text = text;
	}


	/*
	 * Overriding methods
	 */

	@Override
	public int hashCode() {
		return Objects.hash(good, text, x);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ObjectBase)) {
			return false;
		}
		ObjectBase other = (ObjectBase) obj;
		return good == other.good
				&& Objects.equals(text, other.text)
				&& x == other.x;
	}

	@Override
	public String toString() {
		return "ObjectBase [x=" + x + ", good=" + good
				+ ", text=" + text + "]";
	}


	/*
	 * Delegate methods
	 */

	/**
	 * Returns whether this object's label text is empty.
	 * 
	 * @return {@code true} if the text has zero characters;
	 *         {@code false} otherwise
	 * @throws NullPointerException if the text is {@code null}
	 * @see java.lang.String#isEmpty()
	 */
	public boolean isEmpty() {
		return text.isEmpty();
	}

	/*
	 * Regular methods
	 */
	
	/**
	 * Sets this object's x-coordinate, goodness, and label
	 * text all at once.
	 * 
	 * @param x    the new x-coordinate of this object
	 * @param good {@code true} if this object is now "good";
	 *             {@code false} if this object is now "bad"
	 * @param text the new label text of this object
	 */
	public void setAll(int x, boolean good, String text) {
		this.x = x;
		this.good = good;
		this.text = text;
	}
	
}
