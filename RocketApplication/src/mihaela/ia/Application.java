package mihaela.ia;

import javax.xml.transform.TransformerException;

import mihaela.ia.temp.Session;

public class Application {

	public static void main(String[] args) throws TransformerException  {
		 
	
	
		Localities l = Localities.getInstance();
		l.initializeLocalities();
		
	    l.showTheLocalities();
        EventAlert eventAlert=new EventAlert();
        eventAlert.AlertEveryone(l);
       
		Session st1 = new Session();
		System.out.println("Distance between two localities: " + st1.computeDistanceOfTwoLocalities(l.getLocalities().get(1), l.getLocalities().get(2)));// acordat cu google e 685 vs rezultat 688//greseli
	/*	System.out.println("Angle " + st1.computeAngleBetweenTwoLocalities(l.getLocalities().get(1), l.getLocalities().get(2)));//118 google
		 ReactorFactory reactorFactory= new ReactorFactory();
		Reactor thisReactor= reactorFactory.getReactor("Nuclear");
        RocketBody rb = new RocketBody(2, 5);
        Rocket rocket= new Builder()
        		  .setName("racheta1")
        		  .setReactor( thisReactor)
        		  .setRocketBody(rb)
        		  .build();
      */
       
	}
	
	}