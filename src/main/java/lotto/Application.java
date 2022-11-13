package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> numbers;
        System.out.println("로또 프로그램입니다. \n금액을 입력해 주세요");
        String purchase = Console.readLine();           // 구매 금액

        if(!isValidPurchase(purchase)){
            System.out.println("잘못된 입력입니다! 수량에 맞는 금액을 입력해 주세요!");
            purchase = Console.readLine();
        }
    }
    static boolean isValidPurchase(String purchase) {
        if (Integer.parseInt(purchase) % 1000 != 0) {
            return false;
        }return true;
    }
}
