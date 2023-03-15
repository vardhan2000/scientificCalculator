package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.*;

public class Main {

    private static Logger logger;

    public Main() {
        logger  = LogManager.getLogger(Main.class);
    }
    static double root(int x) {
        if(x < 0) {
            logger.info("[SQUARE ROOT OPERATION] [FAILED] " + x);
            logger.info("[RESULT: SQUARE ROOT] [INVALID INPUT] -1");
            return -1;
        }

        double sqrt=(double)x/2;

        double t=sqrt;
        sqrt=(t+(x/t))*0.5;
        while((t-sqrt)!= 0){
            t=sqrt;
            sqrt=(t+(x/t))*0.5;
        }

        logger.info("[SQUARE ROOT OPERATION] [SUCCESS] " + x);
        logger.info("[RESULT: SQUARE ROOT] " + sqrt);
        return sqrt;
    }

    static double factorial(int x) {
        if(x < 0) {
            logger.info("[FACTORIAL OPERATION] [FAILED] " + x);
            logger.info("[RESULT: FACTORIAL] [INVALID INPUT] -1");
            return -1;
        }
        if(x==0) {
            return 1;
        }
        double fact=1;
        double t=x;
        while(t>0){
            fact*=t;
            t-=1;
        }

        logger.info("[FACTORIAL OPERATION] [SUCCESS] " + x);
        logger.info("[RESULT: FACTORIAL] " + fact);
        return fact;
    }

    static double ln(double x) {
        if(x <= 0) {
            logger.info("[LOGARITHM OPERATION] [FAILED] " + x);
            logger.info("[RESULT: LOGARITHM] [INVALID INPUT] -1");
            return -1;
        }
        double res=0;
        for (int i = 1; i <= 100; i++) {
            double t = 1.0;
            for (int j = 0; j < i; j++) {
                t *= ((x - 1) / x);
            }
            res += (1 / (double)(i)) * t;
        }

        logger.info("[LOGARITHM OPERATION] [SUCCESS] " + x);
        logger.info("[RESULT: LOGARITHM] " + res);
        return res;
    }

    static double power(double x, int b) {
        if(x==0 && b==0) {
            logger.info("[POWER OPERATION] [FAILED]");
            logger.info("[RESULT: POWER] [INVALID INPUT] NaN");
            return Double.NaN;
        }
        if(b==0) {
            return 1;
        }

        double t = x;
        while(b>1) {
            t *= x;
            b-=1;
        }

        logger.info("[POWER OPERATION] [SUCCESS] " + x);
        logger.info("[RESULT: POWER] " + t);
        return t;
    }

    public static void main(String[] args) {
        Main calc = new Main();
        while(true) {
            System.out.println("Choose one of the following operations");
            String opt1 = "root(x)"; String opt2 = "factorial(x)";
            String opt3 = "ln(x)"  ; String opt4 = "power(x,b)";
            System.out.println("1. "+opt1);
            System.out.println("2. "+opt2);
            System.out.println("3. "+opt3);
            System.out.println("4. "+opt4);
            System.out.println("Enter 1 or 2 or 3 or 4:");
            System.out.println("Enter 'q' to quit");

            Scanner myObj = new Scanner(System.in);
            String option = myObj.nextLine();

            if(option.equals("1")) {
                System.out.println("\nOperation chosen: "+opt1);
                System.out.println("Enter value of 'x': ");

                int x = myObj.nextInt();
                // double ans = root(x);
                System.out.println("\n"+opt1+"= "+calc.root(x)+"\n");
            }

            else if(option.equals("2")) {
                System.out.println("\nOperation chosen: "+opt2);
                System.out.println("Enter value of 'x': ");
                int x = myObj.nextInt();
                // double ans = root(x);
                System.out.println("\n"+opt2+"= "+calc.factorial(x)+"\n");
            }

            else if(option.equals("3")) {
                System.out.println("\nOperation chosen: "+opt3);
                System.out.println("Enter value of 'x': ");
                double x = myObj.nextDouble();
                // double ans = root(x);
                System.out.println("\n"+opt3+"= "+calc.ln(x)+"\n");
            }

            else if(option.equals("4")) {
                System.out.println("\nOperation chosen: "+opt4);
                System.out.println("Enter value of 'x': ");
                double x = myObj.nextDouble();

                System.out.println("\nEnter value of 'b': ");
                int b = myObj.nextInt();
                // double ans = root(x);
                System.out.println("\n"+opt4+"= "+calc.power(x,b)+"\n");
            }

            else if(option.equals("q")) {
                break;
            }
        }

    }
}