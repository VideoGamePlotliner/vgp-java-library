/**
 * Container for an interface that directly extends {@code Cloneable}.
 * <p>
 * Said interface, which is called {@code CloneableBase}, is designed to
 * merely redefine the {@code clone} method of the {@code Object} class.
 * <p>
 * Currently, there are no plans to include classes or any other
 * interfaces in this package, but that could change in the future.
 * <p>
 * Lastly, for the sake of utilizing the interface, this package's module
 * should {@code export} this package to all other modules.
 * 
 * @author John Bues
 * @version 1.3
 * @see java.lang.Object#clone()
 * @see java.lang.Cloneable
 * @since 1.3
 */
package vgp.clone;