package day1;

public class ExampleOne {
    public static void main(String[]args){
        String student = new String("Lucca");
        String hockeyPlayer = new String("Wayne Gretzky");


        System.out.println(student);
        System.out.println("Length of student: " + student.length());
        System.out.println(hockeyPlayer);
        System.out.println("Length of player: " + hockeyPlayer.length());

        System.out.println("Substring of student 2  - 4 " + student.substring(2,4));

        //half of a string is (0,(string.length()/2));
        System. out.println(hockeyPlayer.substring(0,(hockeyPlayer.length()/2)));

    }

}
