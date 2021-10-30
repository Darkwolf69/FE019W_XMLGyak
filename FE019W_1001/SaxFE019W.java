import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SaxFE019W extends DefaultHandler {

	private static final String FILENAME = "src/cats.xml";

    public static void main(String[] args) {

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {

            SAXParser saxParser = factory.newSAXParser();

            SaxFE019W handler = new SaxFE019W();
            saxParser.parse(FILENAME, handler);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

    }
	
	
	private StringBuilder currentValue = new StringBuilder();

	@Override
	public void startDocument() {
		System.out.println("Start Document");
	}

	@Override
	public void endDocument() {
		System.out.println("End Document");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) {
		currentValue.setLength(0);
		
		if (qName.equalsIgnoreCase("cat")) {
			String indented = qName.indent(3);
			String id = attributes.getValue("id");
			String output = indented.substring(0, indented.length()-1);
	          System.out.println(output + " {id:" + id + "}"  + " start");
	    }
		
		if (qName.equalsIgnoreCase("name") || qName.equalsIgnoreCase("age") || qName.equalsIgnoreCase("breed")) {
			String indented = qName.indent(6);
			String output = indented.substring(0, indented.length()-1);
	          System.out.println(output + " start");
	    }
		
	}

	@Override
	public void endElement(String uri, String localName, String qName) {
		if (qName.equalsIgnoreCase("cat")) {
			String indented = qName.indent(3);
			String output = indented.substring(0, indented.length()-1);
	          System.out.println(output + " end");
	    }
		
		if (qName.equalsIgnoreCase("name") || qName.equalsIgnoreCase("age") || qName.equalsIgnoreCase("breed")) {
			String currVal = currentValue.toString().indent(9);
			System.out.print(currVal);
			String indented = qName.indent(6);
			String output = indented.substring(0, indented.length()-1);
	          System.out.println(output + " end");
	    }
	}
	
	@Override
	public void characters(char ch[], int start, int length) {
		currentValue.append(ch, start, length);
	}

}