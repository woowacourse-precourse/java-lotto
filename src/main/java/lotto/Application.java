package lotto;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int purchase = sc.nextInt();
        validate(purchase);
        
        sc.close();
    }

    private static void validate(Integer purchase){
        if (purchase % 1000 != 0 || purchase <= 0){
            System.out.println("[ERROR] 금액은 반드시 1,000원 이상, 1,000원 단위로 입력하세요.");
            throw new IllegalArgumentException();
        }
    }
}
