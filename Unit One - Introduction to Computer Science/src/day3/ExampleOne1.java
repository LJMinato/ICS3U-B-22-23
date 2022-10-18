package day3;

/*
 * ExampleOne: Primitive data types, variables are meant to store and eventually 
 * recall data/info
 */

public class ExampleOne1 {
    
public static void main(String[] args) {
    //primitive types store the value
    //int = integer (no decimal)
    //double = decimal numbers
    //boolean = true or false




    int numberOfStudents = 14;   //number of students has been declared as int
    double testAverage = 63.7;     //declared and initialized on the same line




    final double PI = 3.14; //if the final variable CANNOT be modified after it 
    //has been initialized, then make it final  
    //naming convention for constants(final) is all upper case with underscores between words.



    boolean isHeads = false;
    boolean hasToes = true;

    System.out.println("There are " + numberOfStudents + " students in the class");
    System.out.println("5 + 3 = " + 5 + 3);

}
}
