package org.example;

import java.util.*;

public class Main {
    static double root(int x) {
        double sqrt=(double)x/2;

        double t=sqrt;
        sqrt=(t+(x/t))*0.5;
        while((t-sqrt)!= 0){
            t=sqrt;
            sqrt=(t+(x/t))*0.5;
        }
        return sqrt;
    }

    static double factorial(int x) {
        double fact=1;
        double t=x;
        while(t>0){
            fact*=t;
            t-=1;
        }
        return fact;
    }

    static double ln(double x) {
        double t=x;
        double log=0;
        double e = 2.718281828459045;
        while(t>1) {
            t=t/e;
            log+=1;
        }
        log=log+t-1;
        return log;
    }

    static double power(double x, int b) {
        if(b==0) {
            return 1;
        }

        double t = x;
        while(b>1) {
            t *= x;
            b-=1;
        }
        return t;
    }

    public static void main(String[] args) {
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
                System.out.println("\n"+opt1+"= "+root(x)+"\n");
            }

            else if(option.equals("2")) {
                System.out.println("\nOperation chosen: "+opt2);
                System.out.println("Enter value of 'x': ");
                int x = myObj.nextInt();
                // double ans = root(x);
                System.out.println("\n"+opt2+"= "+factorial(x)+"\n");
            }

            else if(option.equals("3")) {
                System.out.println("\nOperation chosen: "+opt3);
                System.out.println("Enter value of 'x': ");
                double x = myObj.nextDouble();
                // double ans = root(x);
                System.out.println("\n"+opt3+"= "+ln(x)+"\n");
            }

            else if(option.equals("4")) {
                System.out.println("\nOperation chosen: "+opt4);
                System.out.println("Enter value of 'x': ");
                double x = myObj.nextDouble();

                System.out.println("\nEnter value of 'b': ");
                int b = myObj.nextInt();
                // double ans = root(x);
                System.out.println("\n"+opt4+"= "+power(x,b)+"\n");
            }

            else if(option.equals("q")) {
                break;
            }
        }

    }
}