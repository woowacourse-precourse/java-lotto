package lotto;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

    }

    public static Integer takeCost(){
        int cost = 0;

        Scanner sc = new Scanner(System.in);

        cost = sc.nextInt();
        CostRight(cost);

        return cost;
    }
    public static void CostRight(int cost){
        if(cost%1000 != 0)
            throw new IllegalArgumentException("[ERROR] 입력 금액 오류");
    }


}
