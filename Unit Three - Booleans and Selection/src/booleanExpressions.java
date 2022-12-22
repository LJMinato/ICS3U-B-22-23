public class booleanExpressions {
    public static void main(String[] args) {

        //matematical expressions evaluate to a number
        //boolean expressions evaluate to either true or false
        // >, <, >=, <=, ==, !=

        boolean exp1 = 17 > 5;      //true

        boolean exp2 = 17 == 17;        //true

        boolean isRed = true;

        boolean isHard = false;

        boolean exp3 = isHard == isRed;     //false

        int x = 7;
        boolean exp4 = (x < 3) != (x > 5);      //true

        int y = 3;
        boolean exp5 = (x < y) == (y > 7);      //false == false, this is true

        //compounr boolean expressions
        //and = &&, or = ||, not = !

        //not operator

        boolean isGreen = true;

        boolean exp6 = !isGreen;

        boolean exp7 = !true; //false

        boolean exp8 = !false; //true

        //and operator

        boolean isBlue = false;
        isHard = true;

        boolean isHardBlue = isBlue && isHard;  //&& requires both left and right side to  be true if it is going to be true

        //or operator

        boolean isHardOrBlue = isBlue || isHard;    //or requires both left and right side to  be true if it is going to be true

        x = 7;
        y = 17;

        boolean exp9 = (x  > 7) && (y < 25); //false











}
}