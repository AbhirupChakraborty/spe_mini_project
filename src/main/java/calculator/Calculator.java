package calculator;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.Math;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Calculator {
    private static final Logger logger = LogManager.getLogger(Calculator.class);
    public Calculator(){
    }
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        double num1, num2;
        do {
            System.out.println(":: Scientific Calculator ::\n");
            System.out.println("Choose operation:\n");
            System.out.println("1. Factorial \n");
            System.out.println("2. Square Root \n");
            System.out.println("3. Power \n");
            System.out.println("4. Natural Logarithm(base e)\n");
            System.out.println("5. Exit\n");
            System.out.println("Enter Your Choice: ");

            int choice;
            try{
                choice = scanner.nextInt();
            }
            catch (InputMismatchException error){
                return;
            }
            if(choice==1){
                //{FACTORIAL OF A NUMBER}
                System.out.println("Enter a number: ");
                num1=scanner.nextDouble();
                System.out.println("Factorial of " + num1 + " is: "+ calculator.factorial(num1) + "\n");
            }
            else if(choice==2){
                //{SQUARE ROOT OF A NUMBER}
                System.out.println("Enter a number: ");
                num1=scanner.nextDouble();
                System.out.println("Factorial of " + num1 + " is: "+ calculator.square_root(num1) + "\n");
            }
            else if(choice==3){
                //{POWER Function}
                System.out.println("Enter the first number: ");
                num1=scanner.nextDouble();
                System.out.println("Enter the second number: ");
                num2=scanner.nextDouble();
                System.out.println(num1+" raised to power "+num2+ "is: "+calculator.power(num1,num2)+"\n");
            }
            else if(choice==4){
                //{NATURAL LOGARITHM OF A NUMBER}
                System.out.println("Enter a number: ");
                num1=scanner.nextDouble();
                System.out.println("Natural log of " + num1 + " is: "+ calculator.log(num1) + "\n");
            }
            else{
                System.out.println("EXIT");
                return;
            }
        }while(true);
    }

    public double factorial( double num1){
        logger.info("{FACTORIAL} - "+ num1);
        double fact = 1;
        for(int i=1;i<=num1;i++){
            fact *= i;
        }
        logger.info("{RESULT - FACTORIAL} - "+ fact);
        return fact;
    }
    public double square_root( double num1){
        logger.info("{SQUARE ROOT} - "+ num1);
        double res = Math.sqrt(num1);
        logger.info("{RESULT - SQUARE ROOT} - "+ res);
        return res;
    }
    public double power( double num1, double num2){
        logger.info("{POWER - "+ num1+"RAISED TO}" + num2);
        double res= Math.pow(num1,num2);
        logger.info("{RESULT - POWER} - "+ res);
        return res;
    }
    public double log( double num1){
        logger.info("{NATURAL LOGARITHM} - "+ num1);
        double result = 0;
        try{
            if(num1<0){
                result = Double.NaN;
                throw new ArithmeticException("Case of NaN 0/0");
            }
            else{
                result=Math.log(num1);
            }
        }
        catch(ArithmeticException error){
            System.out.println("{Exception-LOG} - Can n't found log of negative(-ve) numbers "+ error.getLocalizedMessage());
        }
        logger.info("{RESULT - NATURAL LOGARITHM} - "+ result);
        return result;
    }
}