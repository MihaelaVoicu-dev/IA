package rocket.math;

public class Longitude {

	private float degrees;
	private float minutes;
	private boolean isVest;
	private LongitudeOrientation orientation;

	public Longitude() {
		setDegrees(0);
		setMinutes(0);
	}

	public LongitudeOrientation getOrientation() {
		return orientation;
	}

	public Longitude(int g, int m, LongitudeOrientation o) {
		this.setDegrees(g);
		this.setMinutes(m);
		this.orientation=o;
	}

	public void setOrientation(LongitudeOrientation orientation) {
		this.orientation = orientation;
	}

	public String toString() {
		if (this.orientation.WEST!=null) {
			return "grade: " + this.getDegrees() + " minutes: " + this.getMinutes() + " West";
		} else if(this.orientation.EASTH!=null){
			return "grade: " + this.getDegrees() + " minutes: " + this.getMinutes() + " East";
		}
		return null;
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

	
}