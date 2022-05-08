package mihaela.ia;

import java.io.File;
import java.io.OutputStream;
import java.nio.file.spi.FileSystemProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

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

import rocket.math.Latitude;
import rocket.math.LatitudeOrientation;
import rocket.math.Locality;
import rocket.math.Longitude;
import rocket.math.LongitudeOrientation;

public class CustomLocalities extends Locality implements Subject {

	private static final Logger logger = Logger.getLogger(CustomLocalities.class.getName());

	private static CustomLocalities instance;

	private List<CustomLocality> observerList;

	private CustomLocalities() {
		this.observerList = new ArrayList<CustomLocality>();
	}
	
	public static CustomLocalities getInstance() {
		if (instance == null) {
			instance = new CustomLocalities();
		}
		return instance;
	}

	public List<CustomLocality> getLocalities() {
		return observerList;
	}

	public void add(CustomLocality l) {
		observerList.add(l);
	}

	public void readXml() {

		try {
			// creating a constructor of file class and parsing an XML file
			File file = new File("D:\\Eclipse workspace\\IA\\IA2\\RocketApplication\\src\\mihaela\\ia\\ListOfLocalities.xml");

			// an instance of factory that gives a document builder
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			// an instance of builder to parse the specified xml file
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			doc.getDocumentElement().normalize();
			NodeList nodeList = doc.getElementsByTagName("Locality");

			logger.log(Level.INFO, "Iterate the localities from the DOM Object :");
			// nodeList is not iterable, so we are using for loop
			for (int itr = 0; itr < nodeList.getLength(); itr++) {
				Node node = nodeList.item(itr);

				if (node.getNodeType() == Node.ELEMENT_NODE) {
					CustomLocality currentLocality = new CustomLocality();
	                 LatitudeOrientation o=null;
	                 LongitudeOrientation o1=null;
					Element eElement = (Element) node;
					// eElement=null;
					currentLocality.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
					currentLocality.setLongitude(
							Integer.parseInt(eElement.getElementsByTagName("lgrades").item(0).getTextContent()),
							Integer.parseInt(eElement.getElementsByTagName("lminutes").item(0).getTextContent()),
							o1.valueOf(eElement.getElementsByTagName("orientationLong").item(0).getTextContent())
							);
					currentLocality.setLatitude(
							Integer.parseInt(eElement.getElementsByTagName("grades").item(0).getTextContent()),
							Integer.parseInt(eElement.getElementsByTagName("minutes").item(0).getTextContent()),
							 o.valueOf(eElement.getElementsByTagName("orientation").item(0).getTextContent())
							);
					observerList.add(currentLocality);
				}

			}
		} catch (Exception e) {
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

	public void writeXML() throws TransformerException {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder;
			docBuilder = docFactory.newDocumentBuilder();
			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("ListOfLocalities");
			doc.appendChild(rootElement);
			Element locality = doc.createElement("Locality");
			rootElement.appendChild(locality);
			Element name = doc.createElement("name");
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
			e.printStackTrace();
		}

	}

	public void showTheLocalities() {
		for (int i = 0; i < observerList.size(); i++) {
			System.out.println(observerList.get(i).toString());
		}
	}

	@Override
	public void register(Observer o) {
		observerList.add((CustomLocality) o);
	}

	@Override
	public void unregister(Observer o) {
		observerList.remove(observerList.indexOf(o));
	}

	@Override
	public void notifyAllObservers() {
		for (Iterator<CustomLocality> it = observerList.iterator(); it.hasNext();) {
			Observer o = it.next();
			o.update();
		}
	}
	public void initializeLocalitiesAndRegisterObservers() {
		CustomLocalities l = CustomLocalities.getInstance();
		LatitudeOrientation n = null;
		Latitude lat1 = new Latitude(46, 47, n.NORTH);
		Latitude lat2 = new Latitude(44, 14, n.SOUTH);
		Latitude lat3 = new Latitude(23, 54, n.NORTH);
		LongitudeOrientation m=null;
		Longitude long1 = new Longitude(23, 38, m.EASTH);
		Longitude long2 = new Longitude(28, 38, m.EASTH);
		Longitude long3 = new Longitude(42, 53, m.WEST);
		CustomLocality l1 = new CustomLocality("Cluj", long1, lat1);
		CustomLocality l2 = new CustomLocality("Constanta", long2, lat2);
		CustomLocality l3 = new CustomLocality("Craiova", long3, lat3);
        l.register(l1);
        l.register(l2);
        l.register(l3);
        l.readXml();
	}
}