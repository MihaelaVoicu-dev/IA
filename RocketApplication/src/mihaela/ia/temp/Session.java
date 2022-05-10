package mihaela.ia.temp;

import mihaela.ia.CustomLocality;
import rocket.math.Rocket;

public class Session {

	private float launchingAngle;
	private double launchingSpeed;
	private Rocket rocket;

	public static double computeDistanceOfTwoLocalities(CustomLocality A, CustomLocality B) {
		final float R = 6371;// Earth`s radius in km
		final float latitudeA = (float) (A.computeLatitudeToDegrees() * Math.PI / 180);// transform to radians
		final float latitudeB = (float) (B.computeLatitudeToDegrees() * Math.PI / 180);
		final float longitudeA = (float) (A.computeLongitudeToDegrees() * Math.PI / 180);
		final float longitudeB = (float) (B.computeLongitudeToDegrees() * Math.PI / 180);
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

	public double computeAngleBetweenTwoLocalities(CustomLocality a, CustomLocality b) {
		
		float differenceLongitude = (b.computeLongitudeToDegrees() - a.computeLongitudeToDegrees());
	    double y = Math.sin(differenceLongitude) * Math.cos(b.computeLatitudeToDegrees());
	    double firstPart= Math.cos(a.computeLatitudeToDegrees()) * Math.sin(b.computeLatitudeToDegrees());
	    double x = firstPart - Math.sin(a.computeLatitudeToDegrees())* Math.cos(b.computeLatitudeToDegrees()) * Math.cos(differenceLongitude);
	    double angle = Math.atan2(y, x);
	    angle = Math.toDegrees(angle);
	    angle = (angle + 360) % 360;
	    return 360 - angle; // count degrees counter-clockwise - remove to make clockwise
	}
	
    public void minimumSpeedOfLaunching() {}
    
	public void optimAngle(CustomLocality a, CustomLocality b) {
		
	}

}
