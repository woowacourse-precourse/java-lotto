package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static int purchaseAmount() {
        try {
            int input = Integer.parseInt(input());
            return input / 1000;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 최소금액은 1000원이고 1000원 단위로 입력하세요");
        }
    }

    private static String input() {
        return Console.readLine();
    }
}
