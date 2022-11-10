package lotto;

import java.util.Scanner;

public class Application {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int payment = sc.nextInt();
        validatePayment(payment);
    }
    public static void validatePayment(int payment){
        if(payment <= 0 || payment%1000 != 0)
            throw new IllegalArgumentException();
    }
}
