/**
 * This file is part of a testing process of a Conversion application MARC4J_XML to JSON 
 * 
 * testMarcXmlReader is a method under the class named DDCMARCConverterTest which 
 * extends from the TestCase.
 */

package test.java.de.gbv.jskos.converter;

import java.io.InputStream;

import org.marc4j.MarcReader;
import org.marc4j.MarcXmlReader;
import org.marc4j.marc.Record;
import org.xml.sax.InputSource;

import de.gbv.jskos.converter.DDCMARCConverter;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**   
 * Inside the method source of the MARC_XML data file is given which is stored in 
 * the folder named 'resource' from where it can be accessible.
 * It tests if the data file is parsing properly or not? If the parsing is 
 * successful it will print the object into JSON format.
 * Also through the assertEquals it checks the highest number of line for one 
 * tagged display formated data.  
 *  
 * @author M. Akter 
 * @version $ $ 
 *  
 */

public class DDCMARCConverterTest extends TestCase {
	
	public void testMarcXmlReader() throws Exception {
		DDCMARCConverter converter = new DDCMARCConverter();
		int i = 0; 
		// Providing the MARC_XML data source
		String systemId = "resource/DDC_test.xml";
	    InputSource input = new InputSource(systemId);
	    MarcReader reader = new MarcXmlReader(input);
	    
		while (reader.hasNext()) { 
			Record record = reader.next(); 
			converter.convertConcept(record);
			System.err.println(converter.convertConcept(record)); 
			i++; 
		} 
    //input.close();
	
	// checks the highest number of line	
    assertEquals(24, i); 
	}
	
	public static Test suite() { 
	     return new TestSuite(DDCMARCConverterTest.class); 
	} 
	  
	public static void main(String args[]) { 
	     TestRunner.run(suite()); 
	}

}
