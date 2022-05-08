package mihaela.ia;

import rocket.math.Latitude;
import rocket.math.LatitudeOrientation;
import rocket.math.Locality;
import rocket.math.Longitude;
import rocket.math.LongitudeOrientation;

public class CustomLocality extends Locality implements Observer {
    
	public CustomLocality() {
		super();
	}
	
	public CustomLocality(String n, Longitude longit, Latitude lat) {
		super();
	}
	
	@Override
	public void update() 
	{
	   
		if(this.getState()==1) {
		System.out.println(this.getName()+ " has been launched the rocket!!");
		}
		else {
		
	     System.out.println(this.getName()+"  hasn t been launched the rocket!");}
	}



}

