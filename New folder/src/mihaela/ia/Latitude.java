package mihaela.ia;


public class Latitude   {

	
	int grades;
	int minutes;
    boolean isNord;
 public Latitude(int g,int m, boolean v) {
	 this.grades=g;
	 this.minutes=m;
	 this.isNord=v;
}
public Latitude() {
	grades=0;
	minutes=0;
	isNord=true;
}
public String toString() 
{ if(this.isNord==true)
{ return "grade: " + this.grades+ " minutes: "+this.minutes + " North"; 
	}
else {
	 return "grade: " + this.grades+ " minutes: "+this.minutes + " South"; 
	}
}
}
     