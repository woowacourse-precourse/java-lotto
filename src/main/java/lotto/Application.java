package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int money = toInteger(Console.readLine());

    }

    private static int toInteger(String input) {
        int money = Integer.parseInt(input);
        if (money < 1000) {
            throw new IllegalArgumentException("[ERROR] 1,000원 이상을 입력해 주세요.");
        }

        if (money%1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원으로 나누어 떨어지는 금액만 입력해 주세요.");
        }

        return money;
    }
}
