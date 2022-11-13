package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputOutput {
    public static int moneyInput() {
        int money;

        try {
            money = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 구입 금액은 숫자이어야 합니다.");
            throw new IllegalArgumentException();
        }

        if (money % 1000 != 0) {
            System.out.println("[ERROR] 구입 금액은 1000단위 이어야 합니다.");
            throw new IllegalArgumentException();
        }

        if (money <= 0) {
            System.out.println("[ERROR] 구입 금액은 1000이상만 가능합니다.");
            throw new IllegalArgumentException();
        }

        return money;
    }
}
