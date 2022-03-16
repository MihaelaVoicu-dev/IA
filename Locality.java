package mihaela.ia;

public class Locality {
	
	String name;
	Longitude longitude;
	Latitude latitude;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Longitude getLongitude() {
		return longitude;
	}
	public void setLongitude(Longitude longitude) {
		this.longitude.grades = longitude.grades;
		this.longitude.minutes = longitude.minutes;
		this.longitude.isVest = longitude.isVest;
	}
	public Latitude getLatitude() {
		return latitude;
	}
	public void setLatitude(Latitude latitude) {
		this.latitude.grades = latitude.grades;
		this.latitude.minutes = latitude.minutes;
		this.latitude.isNord = latitude.isNord;
	}
	
     static  String separator="  ";
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
	public Locality(String n, int g,int m,boolean v,int g1,int m1,boolean v1)
	{
		this.name=n;
		this.longitude.grades=g;
		this.longitude.minutes=m;
		this.longitude.isVest=v;
		this.latitude.grades=g1;
		this.latitude.minutes=m1;
		this.latitude.isNord=v1;
	};
	public String toString() {
	if((longitude.isVest)&&(latitude.isNord))
	{
		return name+separator+longitude.grades+separator+longitude.minutes+ "West"+separator+latitude.grades+separator+latitude.minutes+"North";
	}
	else if((longitude.isVest==false)&&(latitude.isNord==false)) {
		return name+separator+longitude.grades+separator+longitude.minutes+ "East"+separator+latitude.grades+separator+latitude.minutes+"South";
	}
	else if((longitude.isVest==false)&&(latitude.isNord==true)) {
		return name+separator+longitude.grades+separator+longitude.minutes+ "East"+separator+latitude.grades+separator+latitude.minutes+"North";
	}
	else 
		return name+separator+longitude.grades+separator+longitude.minutes+ "West"+separator+latitude.grades+separator+latitude.minutes+"South";
	

	}

<<<<<<< HEAD

	}
=======
 
}
>>>>>>> main
