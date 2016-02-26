package test.java.de.gbv.jskos.converter;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.textui.TestRunner;
import junit.framework.TestSuite;

public class DDCMCAllTests extends TestCase {
	public static Test suite() { 
        TestSuite suite = new TestSuite("All Tests"); 
//        suite.addTest(LeaderTest.suite()); 
//        suite.addTest(ControlFieldTest.suite()); 
//        suite.addTest(SubfieldTest.suite()); 
//        suite.addTest(DataFieldTest.suite()); 
//        suite.addTest(RecordTest.suite()); 
        suite.addTest(DDCMARCConverterTest.suite()); 
//        suite.addTest(WriterTest.suite()); 
//        suite.addTest(RoundtripTest.suite()); 
//        suite.addTest(PermissiveReaderTest.suite()); 
        return suite; 
    } 
 
    public static void main(String args[]) { 
        TestRunner.run(suite()); 
    }
	
}
