package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UserInterface {
    public static void printPurchaseMoneyMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static int inputPurchaseMoney() {
        return Integer.parseInt(Console.readLine());
    }
}
