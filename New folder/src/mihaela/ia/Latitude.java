package mihaela.ia;

public class Latitude {

	private float degrees;
	private float minutes;

	@Deprecated
	boolean isNord;

	public LatitudeOrientation getOrientation() {
		return orientation;
	}

	public void setOrientation(LatitudeOrientation orientation) {
		this.orientation = orientation;
	}

	private LatitudeOrientation orientation;

	public float getMinutes() {
		return minutes;
	}

	public void setMinutes(float minutes) {
		this.minutes = minutes;
	}

	public float getDegrees() {
		return degrees;
	}

	public void setDegrees(float degrees) {
		this.degrees = degrees;
	}

	public Latitude(int g, int m, LatitudeOrientation o) {
		this.setDegrees(g);
		this.setMinutes(m);
		this.orientation=o;
	}

	public Latitude() {
		setDegrees(0);
		setMinutes(0);
	  
	}

	@Override
	public String toString() {
		if (this.orientation.NORTH != null) {
			return "grade: " + this.getDegrees() + " minutes: " + this.getMinutes() + " North";
		} else if(this.orientation.SOUTH!=null){
			return "grade: " + this.getDegrees() + " minutes: " + this.getMinutes() + " South";
		}
		return null;
	}
}
