package mihaela.ia;

public class Session {

	public double DistanceOfTwoLocalities(Locality A, Locality B) {
		final float R = 6371;// Earth`s radius in km
		final float latitudeA = (float) (A.LatitudeToDegrees() * Math.PI / 180);// transform to radians
		final float latitudeB = (float) (B.LatitudeToDegrees() * Math.PI / 180);
		final float longitudeA = (float) (A.LongitudeToDegrees() * Math.PI / 180);
		final float longitudeB = (float) (B.LongitudeToDegrees() * Math.PI / 180);
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
	 * Math.PI/180; const Δφ = (lat2-lat1) * Math.PI/180; const Δλ = (lon2-lon1) *
	 * Math.PI/180;
	 * 
	 * const a = Math.sin(Δφ/2) * Math.sin(Δφ/2) + Math.cos(φ1) * Math.cos(φ2) *
	 * Math.sin(Δλ/2) * Math.sin(Δλ/2); const c = 2 * Math.atan2(Math.sqrt(a),
	 * Math.sqrt(1-a));
	 * const d = R * c; // in metres
	 * https://www.movable-type.co.uk/scripts/latlong.html
	 */

	public void AngleBetweenTwoLocalities(Locality a, Locality b) {
	}

	public void OptimAngle() {
	}


}
