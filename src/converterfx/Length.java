package converterfx;

public enum Length {
	Meter(1.0), Kilometer(1000.0), Mile(1609.344), Foot(0.30480), Wa(2.00000),;

	private final double value;

	private Length(double value) {
		this.value = value;
	}

	public double getValue() {
		return this.value;
	}

}
