package mihaela.ia;


public class Longitude  {
	
	
	int grades;
	int minutes;
    boolean isVest;
  
 public Longitude() {
	grades=0;
	minutes=0;
	isVest=true;
}
 public Longitude(int g,int m, boolean v) {
   	 this.grades=g;
   	 this.minutes=m;
   	 this.isVest=v;
   }
 public String toString() 
 { if(this.isVest==true)
 { return "grade: " + this.grades+ " minutes: "+this.minutes + " West"; 
 	}
 else {
 	 return "grade: " + this.grades+ " minutes: "+this.minutes + " East"; 
 	}
 }
}