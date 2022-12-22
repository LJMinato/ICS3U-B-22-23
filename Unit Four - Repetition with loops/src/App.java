import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the original price: ");
        int price1 = input.nextInt();

        System.out.print("Enter the new price: ");
        int price2 = input.nextInt();

        System.out.print("Enter the original demand: ");
        int d1 = input.nextInt();

        System.out.print("Enter the new demand: ");
        int d2 = input.nextInt();

        int deltaQ = (((d2 - d1)/d1) * 100);

        int deltaP = (((price2 - price1)/price1) * 100);

        int elasticity = (deltaQ/deltaP);

        if (elasticity > 1){
            System.out.println("This product is elastic");
        }
        else if(elasticity < 1) {
            System.out.println("This product is inelastic");
        }
        else if(elasticity == 0){
            System.out.println("This product is perfectly inelastic");
        }
        else{
            System.out.println("This product is perfectly elastic");
        }
        
    }

}
