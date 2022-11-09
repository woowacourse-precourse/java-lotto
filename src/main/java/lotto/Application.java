package lotto;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        int cost = 0;

        Scanner sc = new Scanner(System.in);

        cost = sc.nextInt();
        CostRight(cost);
    }
    public static void CostRight(int cost){
        if(cost%1000 != 0)
            throw new IllegalArgumentException("[ERROR] 입력 금액 오류");
    }


}
