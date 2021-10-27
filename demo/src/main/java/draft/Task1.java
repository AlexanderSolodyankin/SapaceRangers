package draft;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int injectA, injectB, injectC;
        injectA = sc.nextInt();
        injectB = sc.nextInt();
        injectC = sc.nextInt();

        if((injectA > 0 && injectB > 0) && injectC > 0){
            if(injectA + injectB + injectC == 180){
                System.out.println(" Все углы являются углами треугольники");
            }else System.out.println(" Это не треугольник");
        }else System.out.println(" Это не треугольник");

    }
}
