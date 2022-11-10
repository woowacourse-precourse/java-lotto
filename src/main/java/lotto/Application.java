package lotto;

import camp.nextstep.edu.missionutils.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현c
    }

    static String inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    static int transformStringNumberToInteger(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount);
    }

}
