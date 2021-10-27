package draft;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A, N;
        A = sc.nextInt();
        N = sc.nextInt();
        if(N % A == 0 || A % N == 0){
            System.out.println("Числа делятся без остатка");
        }else System.out.println("Числа не делятся");
    }
}
