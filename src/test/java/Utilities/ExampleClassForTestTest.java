package Utilities;

import junit.framework.TestCase;

public class ExampleClassForTestTest extends TestCase {

    public void testTestOfTestsGets1() {
        ExampleClassForTest exampleClassForTest = new ExampleClassForTest();
        assertEquals(exampleClassForTest.testOfTests(1), "Yes");
    }

    public void testTestOfTestsGetsOtherThen1() {
        ExampleClassForTest exampleClassForTest = new ExampleClassForTest();
        assertEquals(exampleClassForTest.testOfTests(5), "No");
    }
}