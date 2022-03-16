package mihaela.ia;

import java.io.File;
import java.util.List;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ListOfLocalities  {
	List <Locality> localities;
	 Locality currentLocality;
	  
	 
	 public ListOfLocalities() 
	{
	localities= new Vector<Locality>();
    }

    public List<Locality> getLocalities()
    {
	return localities;
    }



  /*  public boolean AddLocality(Locality l) 
    {
	return localities.add(l);
     }
*/
  
   
   public void ReadXml() {
	  
	   try   
	   {  
	   //creating a constructor of file class and parsing an XML file  
	   File file = new File("D:\\Eclipse workspace\\IA\\New folder\\src\\mihaela\\ia\\ListOfLocalities.xml");
	 
	   //an instance of factory that gives a document builder  
	   DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
	   //an instance of builder to parse the specified xml file  
	   DocumentBuilder db = dbf.newDocumentBuilder();  
	   Document doc = db.parse(file);  
	   doc.getDocumentElement().normalize();  
	   System.out.println("Root element: " + doc.getDocumentElement().getNodeName());  
	   NodeList nodeList = doc.getElementsByTagName("Locality");  
	    
	   // nodeList is not iterable, so we are using for loop  
	   for (int itr = 0; itr < nodeList.getLength(); itr++)   
	   {  
	   Node node = nodeList.item(itr);  

	   System.out.println("\nNode Name :" + node.getNodeName());  
	         if (node.getNodeType() == Node.ELEMENT_NODE)   
	          {  
	           Element eElement = (Element) node;  
	     //     localities.get(itr).name=eElement.getElementsByTagName("name").item(0).getTextContent();
	        //  localities.get(itr).latitude.grades= Integer.parseInt( eElement.getElementsByTagName("grades").item(0).getTextContent());
	  
	           System.out.println("Locality name: "+ eElement.getElementsByTagName("name").item(0).getTextContent());  
	           System.out.println("Locality Latitude grades: "+ eElement.getElementsByTagName("grades").item(0).getTextContent());  
	           System.out.println("Locality Latitude minutes: "+ eElement.getElementsByTagName("minutes").item(0).getTextContent());  
	           System.out.println("Locality Latitude Vest: "+ eElement.getElementsByTagName("isVest").item(0).getTextContent());  
	           System.out.println("Locality Longitude grades: "+ eElement.getElementsByTagName("grades").item(0).getTextContent());  
	           System.out.println("Locality Longitude minutes: "+ eElement.getElementsByTagName("minutes").item(0).getTextContent());  
	           System.out.println("Locality Latitude Vest: "+ eElement.getElementsByTagName("isNord").item(0).getTextContent()); 
		       
	   
		     } 
	        
	 
	   }  
	   
	   }catch (Exception e)   
	   {  
	   e.printStackTrace();  
	   }  
	   
   }
   
    /*
 * Just Read
 * void ReadXML() {
 
	//Build XML  doc
	DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
	
	try {
		DocumentBuilder builder= factory.newDocumentBuilder();
		
		try (InputStream stream = new FileInputStream("C:\\Tools\\test.xml")) {
		    doc = builder.parse(stream);
		}
		//
		Document doc= builder.parse(new FileInputStream("D:\\Eclipse workspace\\IA\\New folder\\src\\mihaela\\ia\\ListOfLocalities.xml\\"));
		
		doc.getDocumentElement().normalize();
		NodeList listOfLocalities= doc.getElementsByTagName("Locality");
		for(int i=0;i<listOfLocalities.getLength();i++) {
			Node locality=listOfLocalities.item(i);
			if(locality.getNodeType()==Node.ELEMENT_NODE) {
				Element localityElement= (Element) locality;
				System.out.println("Locality Name: "+ localityElement.getAttribute("name"));
				NodeList localityDetails= locality.getChildNodes();
				for(int j=0;j<localityDetails.getLength();j++) {
					Node detail= localityDetails.item(j);
					if(detail.getNodeType()==Node.ELEMENT_NODE) {
						Element detailElement=(Element) detail;
						System.out.println("  "+detailElement.getTagName()+"  "+detailElement.getAttribute("value"));
						
					}
				}
			}
		}
		
	}catch(ParserConfigurationException e) {
		e.printStackTrace();
	} catch (SAXException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}*/

   /*
 * Tema1 
 * void WriteData() throws FileNotFoundException {
 
	 try {
	     FileWriter myWriter = new FileWriter("localities.txt");
	      Latitude lat1= new Latitude(23,54,false);
		  Latitude lat2= new Latitude(23,54,true);
		  Latitude lat3= new Latitude(23,54,true);
		  Longitude long1=new Longitude(42,53,true);
		  Longitude long2=new Longitude(42,53,true);
		  Longitude long3=new Longitude(42,53,true);
	      Locality l1=new Locality("Arad",long1, lat1);
	      Locality l2=new Locality("Timisoara",long2,lat2);
	      Locality l3=new Locality("Craiova",long3,lat3);
		
			ListOfLocalities l= new ListOfLocalities();

			l.AddLocality(l1);
			l.AddLocality(l2);
			l.AddLocality(l3);
          for(Locality locality : l.getLocalities()) {
        	  myWriter.write(locality.toString());
        	  myWriter.write("\n");
          }
	    
	      myWriter.close();
	      
	      System.out.println("Successfully wrote to the file.");
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	  }
public List<String> getTokens(String str) {
    List<String> tokens = new ArrayList<>();
    StringTokenizer tokenizer = new StringTokenizer(str, "  ");
    while (tokenizer.hasMoreElements()) {
        tokens.add(tokenizer.nextToken());
    }
    return tokens;
}
void ReadData(ListOfLocalities l) throws IOException {
	FileInputStream inputStream=new FileInputStream(new File("localities.txt"));
	BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
	String line= bufferedReader.readLine();
	while(line != null){ 
		Locality loc=new Locality();
	    List<String>  listTokens=  getTokens(line);
	    loc.name=listTokens.get(0);
	    loc.latitude.grades=Integer.parseInt(listTokens.get(1));
	    loc.latitude.minutes=Integer.parseInt(listTokens.get(2));
	    loc.latitude.isNord=Boolean.parseBoolean(listTokens.get(3));
	    loc.longitude.grades=Integer.parseInt(listTokens.get(4));
	    loc.longitude.minutes=Integer.parseInt(listTokens.get(5));
	    loc.longitude.isVest=Boolean.parseBoolean(listTokens.get(6));
		l.AddLocality(loc);
	  
		for(String element: listTokens ) {
			System.out.println(element);
		}	   
       	  line=bufferedReader.readLine();
	}
	
	
FileInputStream inputStream=new FileInputStream(new File("localities.txt"));
	BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
	
	StreamTokenizer streamTokenizer=new StreamTokenizer(bufferedReader);
	 ListOfLocalities l=new ListOfLocalities();
	 int tip= streamTokenizer.nextToken();
	 while(tip!=StreamTokenizer.TT_EOL) {
		 
		switch(tip){
			case StreamTokenizer.TT_EOF:
				Locality loc=new Locality(streamTokenizer.sval);
				
				break;
			
		}
		tip=streamTokenizer.nextToken();
		
	 }
	*/
	/*InputStream inputStream=new FileInputStream(new File("localities.txt"));
	try {
		
		InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
	    try {
	    	BufferedReader bufferedReader= new BufferedReader(inputStreamReader);
	    	String line= bufferedReader.readLine();
	    	while(line!=null) {
	    	System.out.println(line);
	    	line=bufferedReader.readLine();
	    	}
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	
	
}
public void ShowTheLocalities() {
	for(int i=0;i<localities.size();i++) {
		System.out.println(localities.get(i).toString());
	}
}*/
}

