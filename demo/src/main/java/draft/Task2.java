package draft;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num1, num2, num3;
        num1 = sc.nextInt();
        num2 = sc.nextInt();
        num3 = sc.nextInt();

        if(num1 == num2 && num2 == num3){
            System.out.println("Три похожих числа");
        }else if((num1 != num2 && num2 != num3) && num1 != num3){
            System.out.println("Нет похожих чисел");
        }else System.out.println("Есть два похожих числа");




    }


}
