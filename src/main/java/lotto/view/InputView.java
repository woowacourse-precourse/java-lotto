package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_TYPE_IS_NOT_PROPER = "[ERROR] 잘못된 입력 형식입니다.";
    public static String inputWinningLotto() {
        String lotto = Console.readLine();
        validateLottoType(lotto);
        return lotto;
    }

    private static void validateLottoType(String lotto) {
        try {
            String.format("%d,%d,%d,%d,%d,%d", lotto.charAt(0), lotto.charAt(2), lotto.charAt(4), lotto.charAt(6), lotto.charAt(8), lotto.charAt(10));
        } catch (RuntimeException e) {
            throw new RuntimeException(INPUT_TYPE_IS_NOT_PROPER);
        }
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
            throw new RuntimeException(INPUT_TYPE_IS_NOT_PROPER);
        }
    }

    public static Integer inputBonusNumber() {
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