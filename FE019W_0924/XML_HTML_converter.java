package xml_htmlConverter;

import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

public class XML_HTML_converter {

	public static void main(String[] args) {
		
		try {
			TransformerFactory tff = TransformerFactory.newInstance();
			Transformer tf = tff.newTransformer(new StreamSource(new File("src\\xml_htmlConverter\\orarend.xsl")));
			StreamSource ss = new StreamSource(new File("src\\xml_htmlConverter\\FA_orarend.xml"));
			StreamResult sr = new StreamResult(new File("src\\xml_htmlConverter\\FA_xmltohtml.html"));
			tf.transform(ss, sr);
			System.out.println("Conversion completed.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
