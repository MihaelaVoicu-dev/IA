package mihaela.ia;

public class Locality implements Observer {
	
	private int state;

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
		this.longitude.setDegrees(g);
		this.longitude.setMinutes(m);
		this.longitude.setVest(v);
		this.latitude.setDegrees(g1);
		this.latitude.setMinutes(m1);
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
		this.longitude.setDegrees(g);
		this.longitude.setMinutes(min);
		this.longitude.setVest(v);
	}
	public Latitude getLatitude() {
		return latitude;
	}
	public void setLatitude(int g,int min,LatitudeOrientation o) {
		this.latitude.setDegrees(g);
		this.latitude.setMinutes(min);
		this.latitude.setOrientation(o);
	}
	
	public String toString() {
	if((longitude.isVest())&&(latitude.isNord))
	{
		return name+separator+longitude.getDegrees()+separator+longitude.getMinutes()+ "West"+separator+latitude.getDegrees()+separator+latitude.getMinutes()+"North";
	}
	else if((longitude.isVest()==false)&&(latitude.isNord==false)) {
		return name+separator+longitude.getDegrees()+separator+longitude.getMinutes()+ "East"+separator+latitude.getDegrees()+separator+latitude.getMinutes()+"South";
	}
	else if((longitude.isVest()==false)&&(latitude.isNord==true)) {
		return name+separator+longitude.getDegrees()+separator+longitude.getMinutes()+ "East"+separator+latitude.getDegrees()+separator+latitude.getMinutes()+"North";
	}
	else 
		return name+separator+longitude.getDegrees()+separator+longitude.getMinutes()+ "West"+separator+latitude.getDegrees()+separator+latitude.getMinutes()+"South";
	
	}
	
	public float computeLatitudeToDegrees() {
		float degreesL;
		degreesL= (float) (this.latitude.getMinutes()/60+this.latitude.getDegrees());
		return degreesL;
	}
	public float computeLongitudeToDegrees() {
		float degreesl;
		degreesl= (float) (this.longitude.getMinutes()/60+this.longitude.getDegrees());
		return degreesl;
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

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
}

