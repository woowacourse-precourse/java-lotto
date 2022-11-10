package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validateNumber(input);
        return Integer.parseInt(input);
    }

    private static void validateNumber(String input) {
        if (!input.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요");
        }

    }
}
