package mihaela.ia;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.transform.TransformerException;

public class LocalityManagement {

	public static void main(String[] args) throws TransformerException  {
	// TODO Auto-generated method stub
		Logger logger  = Logger.getLogger(LocalityManagement.class.getName());
		logger.log(Level.SEVERE, "logging:",
                new RuntimeException("Error"));
     logger.log(Level.WARNING, "logging: ",
                new Exception("Exception"));
    // log messages using
   
    logger.log(Level.SEVERE, "logging: {0} ");;
    
	  ListOfLocalities l=ListOfLocalities.getInstance();
	  l.ReadXml();
	  l.ShowTheLocalities();
	  Latitude lat1= new Latitude(46,47,true);
	  Latitude lat2= new Latitude(44,14,true);
	  Latitude lat3= new Latitude(23,54,true);
	  Longitude long1=new Longitude(23,38,false);
	  Longitude long2=new Longitude(28,38,false);
	  Longitude long3=new Longitude(42,53,true);
      Locality l1=new Locality("Cluj",long1, lat1);
      Locality l2=new Locality("Constanta",long2,lat2);
      Locality l3=new Locality("Craiova",long3,lat3);
	
	  ListOfLocalities l21=ListOfLocalities.getInstance();
	   l21.ReadXml();
	   l21.ShowTheLocalities();
	 //l21.WriteXML();
   StartUp st1= new StartUp();
   System.out.println(st1.DistanceOfTwoLocalities( l1,l2));//acordat cu google e 685 vs rezultat 688//greseli aproximari
   System.out.println(st1.DistanceOfTwoLocalities( l.localities.get(1),l.localities.get(2)));
   l.ShowTheLocalities();
 
	}
	
	}

