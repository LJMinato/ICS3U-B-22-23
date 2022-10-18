/**
 * BayviewGlenPools
 */
import java.util.Scanner;

public class BayviewGlenPools {
    
    public static void main(String[] args) {


        //pool dimensions

        Scanner pool = new Scanner(System.in);

        System.out.println("Enter a pool width in meters: ");
        double width = pool.nextDouble();

        System.out.println("Enter a pool length in meters: ");
        double length = pool.nextDouble();

        System.out.println("Enter a shallow end depth in meters: ");
        double shallow = pool.nextDouble();
        
        System.out.println("Enter a deep end depth in meters: ");
        double deep = pool.nextDouble();

       

        System.out.println("Enter a shallow end length ");
        double lengthShallow = pool.nextDouble();

        System.out.println("Enter a price of pool lining per meter squared: ");
        double liningPrice = pool.nextDouble(); 

        System.out.println("Enter a shallow to deep end transition length in meters: ");
        double transitionLength = pool.nextDouble();

        double transitionHeight = deep - shallow; 

        double transitionWidth = Math.sqrt(Math.pow(transitionLength,2) - (Math.pow(transitionHeight,2)));

        double lengthDeep = length - lengthShallow - transitionWidth;




        //pool volume

        double shallowVolume = shallow * lengthShallow * width;

        double deepVolume = deep * lengthDeep * width;

        double transitionVolume = (transitionWidth * shallow * width) + (((transitionWidth * transitionHeight)/2)*width);

        double poolVolume = shallowVolume + deepVolume + transitionVolume;

        double ninetyPercentPool = (0.9 * poolVolume);

        System.out.println("The pool volume filled to 90 percent in liters is " + Math.round((ninetyPercentPool * 1000) * 1000) / 1000.0);



        //pool surface area

        double deepEndSurface = 2*(deep * lengthDeep) + (width * lengthDeep) + (width * deep);

        double shallowEndSurface = 2*(shallow * lengthShallow) + (width * lengthShallow) + (width * shallow); 

        double transitionSurface = (2*(transitionWidth * transitionHeight)/2) + (2*(transitionWidth * shallow)) + (width * transitionLength);

        double surfaceArea = deepEndSurface + shallowEndSurface + transitionSurface;

        double liningPriceTotal = liningPrice * surfaceArea;

        System.out.println("The total surface area of the pool in meters squared is " + Math.round(surfaceArea * 1000)/1000.0);

        System.out.println("To line the surface area of the pool in meters squared, it will cost $" + Math.round(liningPriceTotal * 100) / 100.0);

    }
    
}
