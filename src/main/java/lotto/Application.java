package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static String inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String amount = Console.readLine();

        return amount;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int amount = Integer.parseInt(inputPurchaseAmount());
        System.out.println(amount);

    }
}
