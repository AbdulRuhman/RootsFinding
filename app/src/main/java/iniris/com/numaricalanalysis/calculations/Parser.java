/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iniris.com.numaricalanalysis.calculations;

/**
 *
 * @author AbdulRuhman
 */
public class Parser {

    static double trig(float a, String type, double x, float b, float power) {
        if (type.contains("cos")) {
            return a * Math.cos(b * Math.pow(x, power));
        } else if (type.contains("sin")) {
            return a * Math.sin(b * Math.pow(x, power));
        }
        return 0;
    }

    static double poly(float a, double x, float power) {

        return a * Math.pow(x, power);
    }

    static double toPoly(String func, double x) {
        float a = 0, power = 0;
        a = Float.parseFloat(func.substring(0, 2));
        power = Float.parseFloat(func.substring(4, 6));

        return a*Math.pow(x, power);
    }

    static double toTrig(String func, double x) {
        char[] function = func.toCharArray();
        float a = 0, b = 0, power;
        if (func.charAt(0) == '+') {
            a = Float.parseFloat(func.charAt(1) + "");
        } else if (func.charAt(0) == '-') {
            a = Float.parseFloat(func.charAt(1) + "") * -1;
        }
        //+1cos(+1x^+1)
        if (func.charAt(6) == '+') {
            b = Float.parseFloat(func.charAt(7) + "");
        } else if (func.charAt(6) == '-') {
            b = Float.parseFloat(func.charAt(7) + "") * -1;
        }
        if(func.charAt(11)=='0')power=0;
        else
        power = Float.parseFloat(func.substring(10, 12));
        if (func.charAt(2) == 'c') {
            return trig(a, "cos", x, b, power);
        } else if (func.charAt(2) == 's') {
            return trig(a, "sin", x, b, power);
        }

        return 0;
    }

}
