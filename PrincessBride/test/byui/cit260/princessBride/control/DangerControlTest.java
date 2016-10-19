/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.control;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gina Udy
 */
public class DangerControlTest {
    
    public DangerControlTest() {
    }

    /****************************************************************************
    * Test of calcLightningSand method, of class DangerControl.
    *****************************************************************************/
    @Test
    public void testCalcLightningSand() {
        
        System.out.println("calcLightningSand");
        
        /*****************
        * Test Case #1  
        ******************/
        
        System.out.println("\tTest Case #1");
        
        double diameter = -1.0; // input values for test case #1
        
        DangerControl instance = new DangerControl(); // create instance of DangerControl class
        
        double expResult = -1.0; // expected output returned value
        
        double result = instance.calcLightningSand(diameter); // call function to run test 
        
        assertEquals(expResult, result, 0.1); // compare expected return value with actual value returned
        
        
        /*****************
        * Test Case #2  
        ******************/
        
        System.out.println("\tTest Case #2");
        
        diameter = 0.0; // input values for test case #2
        
        expResult = -1.0; // expected output returned value
        
        result = instance.calcLightningSand(diameter); // call function to run test 
        
        assertEquals(expResult, result, 0.1); // compare expected return value with actual value returned
        
        
        /*****************
        * Test Case #3  
        ******************/
        
        System.out.println("\tTest Case #3");
        
        diameter = 21.0; // input values for test case #3
        
        expResult = -1.0; // expected output returned value        
        result = instance.calcLightningSand(diameter); // call function to run test 
        
        assertEquals(expResult, result, 0.1); // compare expected return value with actual value returned
        
        
        /*****************
        * Test Case #4  
        ******************/
        
        System.out.println("\tTest Case #4");
        
        diameter = 2.0; // input values for test case #4
        
        expResult = 3.14; // expected output returned value
        
        result = instance.calcLightningSand(diameter); // call function to run test 
        
        assertEquals(expResult, result, 0.1); // compare expected return value with actual value returned
        
        
        /*****************
        * Test Case #5  
        ******************/
        
        System.out.println("\tTest Case #5");
        
        diameter = 15.0; // input values for test case #5
        
        expResult = 23.56; // expected output returned value
        
        result = instance.calcLightningSand(diameter); // call function to run test 
        
        assertEquals(expResult, result, 0.1); // compare expected return value with actual value returned
        
        
        /*****************
        * Test Case #6 
        ******************/
        
        System.out.println("\tTest Case #6");
        
        diameter = 20.0; // input values for test case #6
        
        expResult = 31.41; // expected output returned value
        
        result = instance.calcLightningSand(diameter); // call function to run test 
        
        assertEquals(expResult, result, 0.1); // compare expected return value with actual value returned
        
    }

    /******************************************************************************
    * Test of checkLightningSand method, of class DangerControl.
    *******************************************************************************/
    @Test
    public void testCheckLightningSand() {
        System.out.println("checkLightningSand");
        
        /*****************
        * Test Case #1  
        ******************/
        
        System.out.println("\tTest Case #1");
        
        double playerDistance = -2.4; // input values for test case #1 
        double diameterCalc = 3.14;
        
        DangerControl instance = new DangerControl(); // create instance of DangerControl class 
        
        double expResult = -1.0; // expected output returned value
        
        double result = instance.checkLightningSand(playerDistance, diameterCalc); // call function to run test 
        
        assertEquals(expResult, result, 0.0); // compare expected return value with actual value returned
        
        
        /*****************
        * Test Case #2  
        ******************/
        
        System.out.println("\tTest Case #2");
        
        playerDistance = -2.4; // input values for test case #2
        diameterCalc = 3.14;
        
        expResult = -1.0; // expected output returned value
        
        result = instance.checkLightningSand(playerDistance, diameterCalc); // call function to run test 
        
        assertEquals(expResult, result, 0.0); // compare expected return value with actual value returned
        
                
        /*****************
        * Test Case #3  
        ******************/
        
        System.out.println("\tTest Case #3");
        
        playerDistance = 7.85; // input values for test case #3
        diameterCalc = 7.85;
        
        expResult = 1.0; // expected output returned value
        
        result = instance.checkLightningSand(playerDistance, diameterCalc); // call function to run test 
        
        assertEquals(expResult, result, 0.0); // compare expected return value with actual value returned
        
                
        /*****************
        * Test Case #4  
        ******************/
        
        System.out.println("\tTest Case #4");
        
        playerDistance = 7.065; // input values for test case #4
        diameterCalc = 7.065;
        
        expResult = 1.0; // expected output returned value
        
        result = instance.checkLightningSand(playerDistance, diameterCalc); // call function to run test 
        
        assertEquals(expResult, result, 0.0); // compare expected return value with actual value returned
        
        
        /*****************
        * Test Case #5  
        ******************/
        
        System.out.println("\tTest Case #5");
        
        playerDistance = 11.0; // input values for test case #5
        diameterCalc = 10.99;
        
        expResult = -1.0; // expected output returned value
        
        result = instance.checkLightningSand(playerDistance, diameterCalc); // call function to run test 
        
        assertEquals(expResult, result, 0.0); // compare expected return value with actual value returned
        
    }

    /************************************************************************
    * Test of calcRodentSize method, of class DangerControl.
    *************************************************************************/
    @Test
    public void testCalcRodentSize() {
        
        System.out.println("calcRodentSize");
        
        /*****************
        * Test Case #1  
        ******************/
        
        System.out.println("\tTest Case #1");
        
        double rodentLength = -1.0; // input values for test case #1
        
        DangerControl instance = new DangerControl(); // create instance of DangerControl class 
        
        double expResult = -1.0; // expected output returned value
        
        double result = instance.calcRodentSize(rodentLength); // call function to run test
        
        assertEquals(expResult, result, 0.1); // compare expected return value with actual value returned 
        
        
        /*****************
        * Test Case #2  
        ******************/
        
        System.out.println("\tTest Case #2");
        
        rodentLength = 0.0; // input values for test case #2
        
        expResult = 0.0; // expected output returned value
        
        result = instance.calcRodentSize(rodentLength); // call function to run test
        
        assertEquals(expResult, result, 0.1); // compare expected return value with actual value returned
    
    }

    /**************************************************************************
    * Test of checkRodentSize method, of class DangerControl.
    ***************************************************************************/
    @Test
    public void testCheckRodentSize() {
        
        System.out.println("checkRodentSize");
        
        /*****************
        * Test Case #1  
        ******************/
        
        System.out.println("\tTest Case #1");
    
        double playerHeight = 1.0; // input values for test case #1
        double heightCalc = 1.5;
        
        DangerControl instance = new DangerControl(); // create instance of DangerControl class 
        
        double expResult = -1.0; // expected output returned value
        
        double result = instance.checkRodentSize(playerHeight, heightCalc); // call function to run test 
        
        assertEquals(expResult, result, 0.0); // compare expected return value with actual value returned
        
        
        /*****************
        * Test Case #2  
        ******************/
        
        System.out.println("\tTest Case #2");
    
        playerHeight = 0.0; // input values for test case #2
        heightCalc = 0.0;
        
        expResult = 0.0; // expected output returned value
        
        result = instance.checkRodentSize(playerHeight, heightCalc); // call function to run test 
        
        assertEquals(expResult, result, 0.0); // compare expected return value with actual value returned
    
    }
    
}
