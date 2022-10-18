package day3;

public class ExampleThree {
    public static void main(String[]args){

        // % a number to 10^x will give you x+1 numbers from the right side.
        // / a number to 10^x will give you x+1 numbers from the left side.

        int number = 51638;
        
        int digit1 = number % 10;
        int digit2 = number % 100 / 10;
        int digit3 = number % 1000 / 100;
        int digit4 = number % 10000 / 1000;
        int digit5 = number / 10000;

        int sum = digit1 + digit2 + digit3 + digit4 + digit5;

        System.out.println(sum);







    }
    
}
