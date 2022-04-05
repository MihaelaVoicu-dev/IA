package mihaela.ia;

import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;




public class Localities implements Subject {
	
	private static final Logger logger = Logger.getLogger(Localities.class.getName());
	
	private static Localities instance;
	
	private List <Locality> observerList;
	
    public static Localities getInstance() {
    	if (instance == null) {
    		instance = new Localities();
    	}
    	return instance ;
    }
   
    
    private Localities() 
    {
    	this.observerList = new ArrayList<Locality>();
    }

	public List<Locality> getLocalities()
    {
	return observerList;
    }



   public void AddLocality(Locality l) 
    {
	 observerList.add(l);
     }   
  public void ReadXml() {
	  
	   try   
	   {  
	   //creating a constructor of file class and parsing an XML file  
	   File file = new File("D:\\Eclipse workspace\\IA\\IA2\\New folder\\src\\mihaela\\ia\\ListOfLocalities.xml");
	 
	   //an instance of factory that gives a document builder  
	   DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
	   //an instance of builder to parse the specified xml file  
	   DocumentBuilder db = dbf.newDocumentBuilder();  
	   Document doc = db.parse(file);  
	   doc.getDocumentElement().normalize();
	   NodeList nodeList = doc.getElementsByTagName("Locality");
	  
	   logger.log(Level.INFO, "Iterate the localities from the DOM Object :");
	   // nodeList is not iterable, so we are using for loop  
	   for (int itr = 0; itr < nodeList.getLength(); itr++)   
	   {  
	   Node node = nodeList.item(itr);  

	         if (node.getNodeType() == Node.ELEMENT_NODE)   
	          {  
	        	 Locality currentLocality=new Locality();
	        	Element eElement = (Element) node;  
	        	//eElement=null;
	        currentLocality.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
	        currentLocality.setLongitude(Integer.parseInt(eElement.getElementsByTagName("lgrades").item(0).getTextContent()),Integer.parseInt(eElement.getElementsByTagName("lminutes").item(0).getTextContent()),Boolean.parseBoolean(eElement.getElementsByTagName("lisVest").item(0).getTextContent()));
	        currentLocality.setLatitude(Integer.parseInt(eElement.getElementsByTagName("grades").item(0).getTextContent()),Integer.parseInt(eElement.getElementsByTagName("minutes").item(0).getTextContent()),Boolean.parseBoolean(eElement.getElementsByTagName("isNord").item(0).getTextContent()));
	        observerList.add(currentLocality);
		     } 
	         
	   }
	   }catch (Exception e)   
	   {  
	  // e.printStackTrace();  
		   logger.log(Level.SEVERE, "Failed to read the data from XML!", e);
	   }  
	   
   }
 private static void writeXml(Document doc, OutputStream output) throws TransformerException {

      TransformerFactory transformerFactory = TransformerFactory.newInstance();
      Transformer transformer = transformerFactory.newTransformer();

    transformer.setOutputProperty(OutputKeys.INDENT, "yes");

   DOMSource source = new DOMSource(doc);
   StreamResult result = new StreamResult(output);

    transformer.transform(source, result);

}

    public void WriteXML() throws TransformerException {
    	try{
    		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
             DocumentBuilder docBuilder;
			docBuilder = docFactory.newDocumentBuilder();
			 // root elements
	        Document doc = docBuilder.newDocument();
	        Element rootElement = doc.createElement("ListOfLocalities");
	        doc.appendChild(rootElement);
	        Element locality=doc.createElement("Locality");
	        rootElement.appendChild(locality);
	        Element name=doc.createElement("name");
	        name.setTextContent("Arad");
	        locality.appendChild(name);
	        Element lgrades = doc.createElement("lgrades");
	        lgrades.setTextContent("50");
	        locality.appendChild(lgrades);
	        Element lminutes = doc.createElement("lminutes");
	        lminutes.setTextContent("32");
	        locality.appendChild(lminutes);
	        Element lisVest = doc.createElement("lisVest");
	         lisVest.setTextContent("true");
	        locality.appendChild(lisVest);
	        Element grades = doc.createElement("grades");
	        grades.setTextContent("32");
	        locality.appendChild(grades);
	        Element minutes = doc.createElement("minutes");
	        minutes.setTextContent("32");
	        locality.appendChild(minutes);
	        Element isNord = doc.createElement("isNord");
	        isNord.setTextContent("false");
	        locality.appendChild(isNord);
	       writeXml(doc, System.out);
	       
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

      
    }

public void ShowTheLocalities() {
	for(int i=0;i<observerList.size();i++) {
		System.out.println(observerList.get(i).toString());}
	}


@Override
public void register(Observer o) {
	observerList.add((Locality) o);
 }
	
@Override
public void unregister(Observer o) {
	 observerList.remove(observerList.indexOf(o));
}
@Override
public void notifyAllObservers() {
	 for (Iterator<Locality> it =  observerList.iterator(); it.hasNext();)
     {
         Observer o = it.next();
        o.update();
     }
}
public void SomeBusinessLogic()
{  
	for(Locality l: observerList)
{	Random rand = new Random();   
l.state = rand.nextInt(2);
 
    System.out.println("Subject: My state has just changed to: " + l.state);
   }
	this.notifyAllObservers();
}}
