package com.mycompany.app;
import java.util.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    public void testFound() {
      ArrayList<String> array = new ArrayList<>(Arrays.asList("ali","yunus","emre","kepenek"));
      assertEquals(new App().search(array, 4, 6), "yunus");
    }

    public void testNotFound() {
      ArrayList<String> array = new ArrayList<>(Arrays.asList("ali","yunus","emre","kepenek"));
      assertEquals(new App().search(array, 1, 2), "");
    }

    public void testEmptyArray() {
      ArrayList<String> array = new ArrayList<>();
      assertEquals(new App().search(array, 1,2),"");
    }

    public void testNull() {
      assertEquals(new App().search(null, 1,1),"");
    }
    public void testParamControl(){
       ArrayList<String> array = new ArrayList<>(Arrays.asList("ali","yunus","emre","kepenek"));
       assertEquals(new App().search(array,5,4),"");
    }

}
