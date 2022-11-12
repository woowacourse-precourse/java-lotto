package lotto;

import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount = askPurchaseAmount();
        System.out.println(purchaseAmount);
    }

    private static int askPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
