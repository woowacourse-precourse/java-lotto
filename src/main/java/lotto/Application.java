package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        printInputMoneyComment();
    }

    private static void printInputMoneyComment() {
        System.out.println("구입금액을 입력해 주세요.");
        Money money = new Money(toInt(Console.readLine()));
    }

    private static int toInt(String input) {
        return Integer.parseInt(input);
    }

}
