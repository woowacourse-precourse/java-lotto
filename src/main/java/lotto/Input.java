package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static int purchaseAmount() {
        try {
            int input = Integer.parseInt(input());
            checkLottoAmount(input);
            return input / 1000;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }

    private static void checkLottoAmount(int input) {
        if (input % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력하세요.");
        }
    }

    private static String input() {
        return Console.readLine();
    }
}
