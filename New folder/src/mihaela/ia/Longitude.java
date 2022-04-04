package mihaela.ia;

public class Longitude  {
	
	
	float degrees;
	float minutes;
    boolean isVest;
    private LongitudeOrientation orientation;
  
 public Longitude() {
	degrees=0;
	minutes=0;
	isVest=true;
}
 public Longitude(int g,int m, boolean v) {
   	 this.degrees=g;
   	 this.minutes=m;
   	 this.isVest=v;
   }
 public String toString() 
 { if(this.isVest==true)
 { return "grade: " + this.degrees+ " minutes: "+this.minutes + " West"; 
 	}
 else {
 	 return "grade: " + this.degrees+ " minutes: "+this.minutes + " East"; 
 	}
 }
}