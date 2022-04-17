package mihaela.ia;

public class Longitude {

	private float degrees;
	private float minutes;
	private boolean isVest;
	private LongitudeOrientation orientation;

	public Longitude() {
		setDegrees(0);
		setMinutes(0);
		setVest(true);
	}

	public Longitude(int g, int m, boolean v) {
		this.setDegrees(g);
		this.setMinutes(m);
		this.setVest(v);
	}

	public String toString() {
		if (this.isVest() == true) {
			return "grade: " + this.getDegrees() + " minutes: " + this.getMinutes() + " West";
		} else {
			return "grade: " + this.getDegrees() + " minutes: " + this.getMinutes() + " East";
		}
	}

	public float getDegrees() {
		return degrees;
	}

	public void setDegrees(float degrees) {
		this.degrees = degrees;
	}

	public float getMinutes() {
		return minutes;
	}

	public void setMinutes(float minutes) {
		this.minutes = minutes;
	}

	public boolean isVest() {
		return isVest;
	}

	public void setVest(boolean isVest) {
		this.isVest = isVest;
	}
}