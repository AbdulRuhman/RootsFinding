package iniris.com.numaricalanalysis.calculations;

import java.util.ArrayList;

/**
 * Created by mac on 12/6/17.
 */

public class SecantMethod {
    static ArrayList<String> list;
    static public double Calculate(String input,double point,double point1){
        list = new ArrayList<String>();

        String sub = "";
        for (int i = 0; i < input.length(); i++) {
            if (i < input.length() - 6) {
                if (input.substring(i, i + 6).contains("cos")||input.substring(i, i + 6).contains("sin")) {
                    sub = input.substring(i, i + 13);
                    list.add(sub);
                    i += 13;
                }  if (input.substring(i, i + 6).contains("x^")&&!input.substring(i, i+6).contains("cos")&&!input.substring(i, i+6).contains("sin")) {
                    sub = input.substring(i, i + 6);
                    list.add(sub);
                    i += 5;
                }
            }
        }
        double fx1=Parser.toTrig(list.get(0), point)+Parser.toPoly(list.get(1), point);
        double dx=Math.abs(point-point1);
        double x1=point,x2=point1;
        //return secant(point,point1,dx);
        double fx2=Parser.toTrig(list.get(0), point1)+Parser.toPoly(list.get(1), point1);
        return x2-((fx2*(x1-x2))/(fx1-fx2));


    }

}
