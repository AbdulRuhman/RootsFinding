package iniris.com.numaricalanalysis.calculations;

import java.util.ArrayList;

/**
 * Created by mac on 12/6/17.
 */

public class NewtonModified {
    static public double Calculate(String input,String inputd,String inputdd,double point){
        String sub = "";
        ArrayList<String> list = new ArrayList<String>();
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
        // String inputd = "-1sin(+1x^+1)-1x^+0";
        ArrayList<String> listd = new ArrayList<String>();
        input=inputd;
        for (int i = 0; i < input.length(); i++) {
            if (i < input.length() - 6) {
                if (input.substring(i, i + 6).contains("cos")||input.substring(i, i + 6).contains("sin")) {
                    sub = input.substring(i, i + 13);
                    listd.add(sub);
                    i += 13;
                }  if (input.substring(i, i + 6).contains("x^")&&!input.substring(i, i+6).contains("cos")&&!input.substring(i, i+6).contains("sin")) {
                    sub = input.substring(i, i + 6);
                    listd.add(sub);
                    i += 5;
                }
            }
        }
        ArrayList<String> listdd = new ArrayList<String>();
        input=inputdd;
        for (int i = 0; i < input.length(); i++) {
            if (i < input.length() - 6) {
                if (input.substring(i, i + 6).contains("cos")||input.substring(i, i + 6).contains("sin")) {
                    sub = input.substring(i, i + 13);
                    listdd.add(sub);
                    i += 13;
                }  if (input.substring(i, i + 6).contains("x^")&&!input.substring(i, i+6).contains("cos")&&!input.substring(i, i+6).contains("sin")) {
                    sub = input.substring(i, i + 6);
                    listdd.add(sub);
                    i += 5;
                }
            }
        }
        //double point=Math.PI/4;
        double fx=Parser.toTrig(list.get(0), point)+Parser.toPoly(list.get(1), point);
        double dfx=Parser.toTrig(listd.get(0), point)+Parser.toPoly(listd.get(1), point);
        double dfxx=Parser.toTrig(listdd.get(0), point)+Parser.toPoly(listdd.get(1), point);
        return point-((fx*dfx)/(((dfx*dfx))-(fx*dfxx)));

    }
}
