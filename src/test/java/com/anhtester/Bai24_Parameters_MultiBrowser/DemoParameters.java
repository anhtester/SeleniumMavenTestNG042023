package com.anhtester.Bai24_Parameters_MultiBrowser;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoParameters {

    @Test
    @Parameters({"number1", "number2"})
    public void testSum01(@Optional("2") int a, @Optional("5")int b) {
        System.out.println("SUM 01: " + (a + b));
    }

    @Test
    @Parameters({"number1", "number2"})
    public void testMul01(@Optional("5")int a, @Optional("10")int b) {
        System.out.println("MUL 01: " + (a - b));
    }

}
