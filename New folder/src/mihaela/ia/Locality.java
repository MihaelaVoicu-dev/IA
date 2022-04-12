package mihaela.ia;

public class Locality implements Observer {
	//TODO modificare private set si get
	public int state;

	static  String separator="  ";
	
	private String name;
	private Longitude longitude;
	private Latitude latitude;
	
	public Locality() {
		name= new String();
		longitude= new Longitude();
		latitude=new Latitude();
	}
	
	public Locality(String n, Longitude longit, Latitude lat) {
		this.name=n;
		this.latitude=lat;
		this.longitude=longit;
	};
	
	public Locality(String n, int g,int m,boolean v,int g1,int m1,boolean v1) {
		this.name=n;
		this.longitude.degrees=g;
		this.longitude.minutes=m;
		this.longitude.isVest=v;
		this.latitude.degrees=g1;
		this.latitude.minutes=m1;
		this.latitude.isNord=v1;
	};
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Longitude getLongitude() {
		return longitude;
	}
	public void setLongitude(int g,int min,boolean v) {
		this.longitude.degrees = g;
		this.longitude.minutes = min;
		this.longitude.isVest = v;
	}
	public Latitude getLatitude() {
		return latitude;
	}
	public void setLatitude(int g,int min,boolean v) {
		this.latitude.degrees=g;
		this.latitude.minutes=min;
		this.latitude.isNord=v;
	}
	
	public String toString() {
	if((longitude.isVest)&&(latitude.isNord))
	{
		return name+separator+longitude.degrees+separator+longitude.minutes+ "West"+separator+latitude.degrees+separator+latitude.minutes+"North";
	}
	else if((longitude.isVest==false)&&(latitude.isNord==false)) {
		return name+separator+longitude.degrees+separator+longitude.minutes+ "East"+separator+latitude.degrees+separator+latitude.minutes+"South";
	}
	else if((longitude.isVest==false)&&(latitude.isNord==true)) {
		return name+separator+longitude.degrees+separator+longitude.minutes+ "East"+separator+latitude.degrees+separator+latitude.minutes+"North";
	}
	else 
		return name+separator+longitude.degrees+separator+longitude.minutes+ "West"+separator+latitude.degrees+separator+latitude.minutes+"South";
	
	}
	public float LatitudeToDegrees() {
		float degreesL;
		degreesL= (float) (this.latitude.minutes/60+this.latitude.degrees);
		return degreesL;
	}
	public float LongitudeToDegrees() {
		float degreesl;
		degreesl= (float) (this.longitude.minutes/60+this.longitude.degrees);
		return degreesl;
	}
	@Override
	public void update() 
	{
	   
		if(this.state==1) {
		System.out.println("Rocket has been launched!!!");
		}
		else {
		
	     System.out.println("The rocket hasn t been launched!");}
	}
}


	


	
