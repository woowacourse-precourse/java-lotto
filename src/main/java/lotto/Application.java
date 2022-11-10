package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("구매금액을 입력해 주세요");
        Integer inputMoney = Integer.parseInt(sc.nextLine());
        validateMoney(inputMoney);
        Integer nums = inputMoney/1000;


    }

    static void validateMoney(Integer money){
        if(money%1000!=0){
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위여야 합니다.");
        }
    }
}
