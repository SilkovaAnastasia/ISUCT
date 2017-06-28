package duckbehavior;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ModelDuckTest {
    
    public ModelDuckTest() {
    }
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.setOut(ps);
        
    }
    
    @After
    public void tearDown() {
         baos.reset();
        
    }
    
    @Test
    public void testMallardQuack() {
        DuckBehavior mallard = new MallardDuck();
        mallard.performQuack();
        assertEquals("Quack! \r\n", baos.toString());
        // TODO review the generated test code and remove the default call to fail.
       
    }
   @Test
    public void testRubberDuck() {
        DuckBehavior readhead = new RubberDuck();
        readhead.performFly();
        assertEquals("I can't fly, sorry \r\n", baos.toString());
    }
   
       @Test
    public void testModelDuck() {
        DuckBehavior model = new ModelDuck();
        model.performQuack();
        assertEquals("Quack! \r\n", baos.toString());
    }
    
}
