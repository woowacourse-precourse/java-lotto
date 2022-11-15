package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class InputView {
    private static final String INPUT_TYPE_IS_NOT_PROPER = "[ERROR] 잘못된 입력 형식입니다.";
    public static String inputWinningLotto() {
        String lotto = Console.readLine();
        return lotto;
    }

    public static Integer inputMoney() {
        String money = Console.readLine();
        validateMoneyType(money);
        return Integer.parseInt(money);
    }

    private static void validateMoneyType(String money) {
        try {
            Integer.parseInt(money);
        } catch (IllegalArgumentException e) {
            System.out.println(INPUT_TYPE_IS_NOT_PROPER);
            throw new NoSuchElementException(INPUT_TYPE_IS_NOT_PROPER);
        }
    }

    public static int inputBonusNumber() {
        String bonusNumber = Console.readLine();
        validateBonusNumberType(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    private static void validateBonusNumberType(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(INPUT_TYPE_IS_NOT_PROPER);
        }
    }
}