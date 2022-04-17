package mihaela.ia;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.transform.TransformerException;

public class LocalityManagement {

	public static void main(String[] args) throws TransformerException  {
		 
		Localities l = Localities.getInstance();
		//l.ReadXml();
		LatitudeOrientation n = null;
		Latitude lat1 = new Latitude(46, 47, n.NORTH);
		Latitude lat2 = new Latitude(44, 14, n.SOUTH);
		Latitude lat3 = new Latitude(23, 54, n.NORTH);
		Longitude long1 = new Longitude(23, 38, false);
		Longitude long2 = new Longitude(28, 38, false);
		Longitude long3 = new Longitude(42, 53, true);
		Locality l1 = new Locality("Cluj", long1, lat1);
		Locality l2 = new Locality("Constanta", long2, lat2);
		Locality l3 = new Locality("Craiova", long3, lat3);
        l.register(l1);
        l.register(l2);
        l.register(l3);
        l.readXml();
        l.showTheLocalities();
       EventAlert eventAlert=new EventAlert();
       eventAlert.AlertEveryone(l);
       
		Session st1 = new Session();
		System.out.println("Distance between two localities: " + st1.computeDistanceOfTwoLocalities(l1, l2));// acordat cu google e 685 vs rezultat 688//greseli
		System.out.println("Angle " + st1.computeAngleBetweenTwoLocalities(l1, l2));//118 google
		/*														
		System.out.println(st1.DistanceOfTwoLocalities(l.getLocalities().get(1), l.getLocalities().get(2)));
		l.ShowTheLocalities();
*/	
        ReactorFactory reactorFactory= new ReactorFactory();
      		Reactor thisReactor= reactorFactory.getReactor("Nuclear");
              RocketBody rb = new RocketBody(2, 5);

              Rocket rocket= new Builder()
              		  .setName("racheta1")
              		  .setReactor( thisReactor)
              		  .setRocketBody(rb)
              		  .build();
		System.out.println(rocket.getName());
 
	}
	
	}

