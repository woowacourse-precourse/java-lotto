package lotto;

import static lotto.Constant.NUMBER_REGEX;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static Integer inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputValue = Console.readLine();
        if (!inputValue.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException("숫자만 입력받을 수 있습니다");
        }
        return Integer.parseInt(inputValue);
    }

    public static void inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }
}
