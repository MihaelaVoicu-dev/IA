package mihaela.ia.temp;

import mihaela.ia.CustomLocality;
import rocket.math.Rocket;

public class Session {
    private CustomLocality localityStart;
    private CustomLocality localityDestination;
	private double launchingAngle;
	private double launchingSpeed;
	private double heightOfLaunching;
	public Session(CustomLocality localityStart,CustomLocality localityDestination,double launchingAngle, double launchingSpeed, double heightOfLaunching, Rocket rocket) {
		this.localityStart=localityStart;
		this.localityDestination=localityDestination;
		this.launchingAngle = launchingAngle;
		this.launchingSpeed = launchingSpeed;
		this.heightOfLaunching = heightOfLaunching;
		this.rocket = rocket;
	}

	public Session() {
		// TODO Auto-generated constructor stub
	}

	public CustomLocality getLocalityStart() {
		return localityStart;
	}

	public void setLocalityStart(CustomLocality localityStart) {
		this.localityStart = localityStart;
	}

	public CustomLocality getLocalityDestination() {
		return localityDestination;
	}

	public void setLocalityDestination(CustomLocality localityDestination) {
		this.localityDestination = localityDestination;
	}

	public double getLaunchingAngle() {
		return launchingAngle;
	}

	public void setLaunchingAngle(double launchingAngle) {
		this.launchingAngle = launchingAngle;
	}

	public double getLaunchingSpeed() {
		return launchingSpeed;
	}

	public void setLaunchingSpeed(double launchingSpeed) {
		this.launchingSpeed = launchingSpeed;
	}

	public double getHeightOfLaunching() {
		return heightOfLaunching;
	}

	public void setHeightOfLaunching(double heightOfLaunching) {
		this.heightOfLaunching = heightOfLaunching;
	}

	public Rocket getRocket() {
		return rocket;
	}

	public void setRocket(Rocket rocket) {
		this.rocket = rocket;
	}

	private Rocket rocket;
	private static int optimAngle=45; 
	
//https://www.telework.ro/ro/miscarea-proiectilelor-proiectile-lansate-sub-un-anumit-unghi/
	public  double computeDistanceOfTwoLocalities() {
		final float R = 6371;// Earth`s radius in km
		final float latitudeA = (float) (this.localityStart.computeLatitudeToDegrees() * Math.PI / 180);// transform to radians
		final float latitudeB = (float) (this.localityDestination.computeLatitudeToDegrees() * Math.PI / 180);
		final float longitudeA = (float) (this.localityStart.computeLongitudeToDegrees() * Math.PI / 180);
		final float longitudeB = (float) (this.localityDestination.computeLongitudeToDegrees() * Math.PI / 180);
		final float differenceLatitude = latitudeB - latitudeA;
		final float differenceLongitude = longitudeB - longitudeA;
		final double a = Math.sin(differenceLatitude) * Math.sin(differenceLatitude) + Math.cos(latitudeA)
				* Math.cos(latitudeB) * Math.sin(differenceLongitude / 2) * Math.sin(differenceLongitude / 2);// modificare
		final double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		final double distance = R * c;
		return distance;
	}
	/*
	 * Haversine const R = 6371e3; // metres
	 * 
	 * const φ1 = lat1 * Math.PI/180; // φ, λ in radians const φ2 = lat2 *
	 * Math.PI/180; const Δφ = (lat2-lat1) * Math.PI/180; const Δλ = (lon2-lon1)
	 * * Math.PI/180;
	 * 
	 * const a = Math.sin(Δφ/2) * Math.sin(Δφ/2) + Math.cos(φ1) * Math.cos(φ2)
	 * * Math.sin(Δλ/2) * Math.sin(Δλ/2); const c = 2 * Math.atan2(Math.sqrt(a),
	 * Math.sqrt(1-a)); const d = R * c; // in metres
	 * https://www.movable-type.co.uk/scripts/latlong.html
	 */

	public double computeAngleBetweenTwoLocalities() {
		
		float differenceLongitude = (this.localityDestination.computeLongitudeToDegrees() - this.localityStart.computeLongitudeToDegrees());
	    double y = Math.sin(differenceLongitude) * Math.cos(this.localityDestination.computeLatitudeToDegrees());
	    double firstPart= Math.cos(this.localityStart.computeLatitudeToDegrees()) * Math.sin(this.localityDestination.computeLatitudeToDegrees());
	    double x = firstPart - Math.sin(this.localityStart.computeLatitudeToDegrees())* Math.cos(this.localityDestination.computeLatitudeToDegrees()) * Math.cos(differenceLongitude);
	    double angle = Math.atan2(y, x);
	    angle = Math.toDegrees(angle);
	    angle = (angle + 360) % 360;
	    return 360 - angle; // count degrees counter-clockwise - remove to make clockwise
	}
	public double computeTime() {
		double time;
	    return time= 2* this.launchingSpeed* Math.sin(launchingAngle)/9.8;
	}
    public double minimumSpeedOfLaunching() {
    	
    	final float R = 6371;// Earth`s radius in km
    	double minimumSpeed;
		return   minimumSpeed=Math.sqrt(10*rocket.getMassOfRocket()/R+this.computeAngleBetweenTwoLocalities());
	 	
    }
    
    public double maximumHeight() {
    	
    	double height;
    	return height= Math.pow(this.heightOfLaunching, 2)* Math.pow(Math.sin(launchingAngle), 2)/20;
    }
    
    public double computeSpeedOfLaunching() {
    	double initialSpeed;
		return initialSpeed= Math.pow(this.launchingSpeed*Math.cos(launchingAngle),2)+Math.pow(this.launchingSpeed*Math.cos(launchingAngle)-9.8*this.computeTime(),2);
    	
    }
    
}
