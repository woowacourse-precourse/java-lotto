package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INTEGER_REGEX = "-?\\\\d+";
    private static final String INPUT_TYPE_IS_NOT_PROPER = "[ERROR] 잘못된 입력 형식입니다.";

    public static Integer inputMoney() {
        String money = Console.readLine();
        validateMoneyType(money);
        return Integer.parseInt(money);
    }

    private static void validateMoneyType(String money) {
        if (!money.matches(INTEGER_REGEX)) {
            throw new RuntimeException(INPUT_TYPE_IS_NOT_PROPER);
        }
    }
}