/**
 * This file is part of a Conversion application MARC4J_XML to JSON 
 * 
 * JsonStructure convertConcept is a method under the class named DDCMARCConverter
 */


package de.gbv.jskos.converter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream; 
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonStructure;
import javax.json.JsonWriter;

import org.marc4j.MarcReader; 
import org.marc4j.MarcStreamWriter;
import org.marc4j.MarcWriter;
import org.marc4j.MarcXmlReader; 
import org.marc4j.MarcXmlWriter;
import org.marc4j.marc.DataField;
import org.marc4j.marc.MarcFactory;
import org.marc4j.marc.Record; 
import org.marc4j.marc.Subfield;
import org.marc4j.samples.ReadMarcExample;
import org.xml.sax.InputSource;


/**
 * The contents of the records has some fields like: 153, 245 etc. and subfields: a, j, h
 * which is accessible through the using of the MARC4j api. 
 * In this method it converts the data into understandable JSON Object and returns the 
 * object in JSON format.
 * Calling this method from another class is easy.   
 * The MARC_XML data format is stored in the folder named 'resource' from where it can be 
 * accessible.
 *  
 * @author M. Akter 
 * @version $ $ 
 *  
 */ 

public class DDCMARCConverter {

public JsonStructure convertConcept(Record marcRecord){
        
        // get the first field occurrence for a given tag 
        DataField dataField = (DataField) marcRecord.getVariableField("153"); 
        
        // get the subfield for that tag field
        Subfield subfield = dataField.getSubfield('a');
        Subfield subfield1 = dataField.getSubfield('j');       
        String title = subfield.getData();
        String title1 = subfield1.getData();
        
        // Converting data into a JSON object
        JsonObject ddcObject = (JsonObject) Json.createObjectBuilder()
            	.add("notation", 
                    Json.createArrayBuilder().add(title)
                    						.build()
                    )
                .add("prefLabel",
                    Json.createObjectBuilder().add("de",title1)	 
                                            .build()
                   )
                .build();
//        System.out.println(" notation: " 
//                   + title + " prefLabel: " + title1 );
		return ddcObject;
	}
}

