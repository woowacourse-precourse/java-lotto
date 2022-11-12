package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Cash;

public class Application {
    public static void main(String[] args) {
        inputCash();
    }
    public static void inputCash(){
        System.out.println("구입금액을 입력해 주세요.");
        System.out.println(Cash.countPurchaseQuantity(Console.readLine()));
    }

}
