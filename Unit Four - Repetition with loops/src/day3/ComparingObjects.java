package day3;

public class ComparingObjects {
   public static void main(String[] args) {
      exampleOne();
      exampleTwo();
      exampleThree();

   }

   private static void exampleThree() {
   }

   private static void exampleTwo() {
    //compareTo

    String s1 = "hello";
    String s2 = "alphabet";

    System.out.println(s1.compareTo(s2));
    System.out.println(s2.compareTo(s1));







   }

   private static void exampleOne() {
    String s1 = new String("Hello");
    String s2 = new String("Hello");

    Dog dog1 = new Dog("Marty");

    System.out.println(s1.equals(dog1));
    System.out.println(dog1.equals(s1));
   }
}