package mihaela.ia;


public class Latitude   {

	
	float degrees;
    float minutes;

    @Deprecated
    boolean isNord;
    
    private LatitudeOrientation orientation;
    
 public Latitude(int g,int m, boolean v) {
	 this.degrees=g;
	 this.minutes=m;
	 this.isNord=v;
}
public Latitude() {
	degrees=0;
	minutes=0;
	isNord=true;
}

@Override
public String toString() 
{ if(this.isNord==true)
{ return "grade: " + this.degrees+ " minutes: "+this.minutes + " North"; 
	}
else {
	 return "grade: " + this.degrees+ " minutes: "+this.minutes + " South"; 
	}
}
}
     