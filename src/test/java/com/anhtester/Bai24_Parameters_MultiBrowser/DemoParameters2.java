package com.anhtester.Bai24_Parameters_MultiBrowser;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoParameters2 {

    @Test
    @Parameters({"number1", "number2"})
    public void testSum02(int a, int b) {
        System.out.println("SUM 02: " + (a + b));
    }

    @Test
    @Parameters({"number1", "number2"})
    public void testMul02(int a, int b) {
        System.out.println("SUM 02: " + (a - b));
    }

}
