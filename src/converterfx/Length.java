package converterfx;

/**
 * Set a length of unit in ratio.
 * 
 * @author Pittayut Sothanakul
 *
 */
public enum Length {
	Meter(1.0), Kilometer(1000.0), Mile(1609.344), Foot(0.30480), Wa(2.00000), AU(149597870700.0);

	private final double value;

	/**
	 * Initialize Length.
	 * 
	 * @param value
	 *            of Length unit.
	 */
	private Length(double value) {
		this.value = value;
	}

	/**
	 * Return value of unit
	 * 
	 * @return value of unit
	 */
	public double getValue() {
		return this.value;
	}

}
