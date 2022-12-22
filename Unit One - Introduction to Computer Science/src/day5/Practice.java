package day5;

import java.util.Scanner;

public class Practice {
    public static void main(String[] args){



        Scanner in = new Scanner(System.in);

        System.out.print("Please enter a length in feet: ");

        double length = in.nextDouble();

        System.out.print("Please enter a width in feet: ");

        double width = in.nextDouble();



        double perimeter = (width * 2) + (length * 2);

        System.out.println(perimeter);



    }
}
