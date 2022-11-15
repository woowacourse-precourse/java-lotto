package lotto.util;

import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class ParserUtil {

    final static int MIN_PURCHASE_AMOUNT = 1000;
    final static int SIZE_OF_LOTTO_NUMBER = 6;

    public static void parsePurchaseAmountInput(String input) throws IllegalArgumentException {
        if (ValidationUtil.validateEmpty(input)) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 입력입니다.");
        }
        if (!ValidationUtil.validateIsDigit(input)) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
        int purchaseAmount = Integer.parseInt(input);

        if (!ValidationUtil.validateMinNumber(purchaseAmount)) {
            throw new IllegalArgumentException("[ERROR] 1000원 이상 금액을 입력해주세요.");
        }
        if (!ValidationUtil.validateRemainder(purchaseAmount)) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
        }
    }

    public static void parseWinningNumbersInput(String winningNumInput) throws IllegalArgumentException {
        if (ValidationUtil.validateEmpty(winningNumInput)) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 입력입니다.");
        }
        if (!ValidationUtil.validateIsDigitAndComma(winningNumInput)) {
            throw new IllegalArgumentException("[ERROR] 숫자와 콤마 이외에 문자를 입력할 수 없습니다.");
        }
        if (!ValidationUtil.invalidComma(winningNumInput)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 콤마(',') 입력입니다.");
        }
    }

    public static void parseBonusNumberInput(String bonusNumInput) throws IllegalArgumentException {
        if (ValidationUtil.validateEmpty(bonusNumInput)) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 입력입니다.");
        }
        if (!ValidationUtil.validateIsDigit(bonusNumInput)) {
            throw new IllegalArgumentException("[ERROR] 숫자 이외에 문자를 입력할 수 없습습니다.");
        }

        int bonusNum = Integer.parseInt(bonusNumInput);
        if (!ValidationUtil.validateIsInRange(bonusNum)) {
            throw new IllegalArgumentException("[ERROR] 1부터 45까지 숫자를 입력해주세요.");
        }
    }

}
