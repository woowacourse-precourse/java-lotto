package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInterface {
    public static void printPurchaseMoneyMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static int inputPurchaseMoney() {
        return Integer.parseInt(Console.readLine());
    }

    public static void printWinNumbersMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static List<Integer> inputWinNumbers() {
        String inputNumbers = Console.readLine();
        List<Integer> winNumbers = new ArrayList<>();
        for (String number : inputNumbers.split(",")) {
            winNumbers.add(Integer.parseInt(number));
        }
        return winNumbers;
    }

    public static void printBonusNumberMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
