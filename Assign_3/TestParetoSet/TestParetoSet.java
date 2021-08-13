package TestParetoSet;


import Pareto.*;
import BasicIO.*;
            
/*@Name: Hyejin Kim
 *@Student #6823116
 *@Date: 3/6/2020   */

public class TestParetoSet {
    
    
    private ASCIIDataFile  from;  // output stream
    private ASCIIDisplayer out;
    
    /** The constructor tests the CharStack implementation classes: ConStack and
      * LnkStack using the method testStack.                                     */
    
    public TestParetoSet () {
        
        ParetoSet  s;  // a stack
        
        out = new ASCIIDisplayer();
        
        s = new LnkParetoSet(100);
        out.writeString("Testing Linked ParetoSet");
        out.newLine();
        out.newLine();
        testPareto(s);
        out.newLine();
        out.newLine();
        
        out.close();
                
    };  // constructor
    
    
    /** This method does the actual test of a CharStack.
      *
      * @param  s  a stack to test                                               */
    
    private void testPareto ( ParetoSet s ) {
      
        int numObs;
        int numReadings;
        char label;
        double[] readings;
        
        from = new ASCIIDataFile();
        numObs = 0;
        numReadings = 0;

        out.writeString("Loading Pareto...");
        out.newLine();
        
        numObs = from.readInt();
        numReadings = from.readInt();
        
        readings = new double[numReadings];
  
        for( ; ; ){
          label = from.readChar();
          if(from.isEOF())break;
          for(int i=0; i<numReadings;i++){
            readings[i] = from.readDouble();}
          Observation obs = new Observation(label,readings);
          s.add(obs);
        
          }
         out.writeString(s.toString());
         
    };  // testPareto
    
    
    public static void main ( String[] args ) { new TestParetoSet(); };
    
    
} // TestParetoSet