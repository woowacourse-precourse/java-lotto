package lotto;

import static lotto.BonusNumber.BLANK;
import static lotto.BonusNumber.INPUT_NUMBER_BLANK;

public class Money {

    private static final int BASE_AMOUNT = 1_000;

    private static final String INPUT_AMOUNT_NOT_NUMBER = "[ERROR] 입력한 금액이 숫자가 아닙니다.";
    private static final String INPUT_AMOUNT_THOUSAND_LESS = "[ERROR] 입력한 금액이 1,000원 미만 입니다.";

    private final int inputMoney;

    public Money(String inputMoney) {
        this.inputMoney = validateDivideMoney(validateModifyInputMoneyType(validateBlank(inputMoney)));
    }

    private String validateBlank(String inputMoney) {
        if (inputMoney.contains(BLANK)) {
            throw new IllegalArgumentException(INPUT_NUMBER_BLANK);
        }
        return inputMoney;
    }

    private int validateModifyInputMoneyType(String inputMoney) {
        try {
            return Integer.parseInt(inputMoney);
        } catch (IllegalArgumentException exceptionMessage) {
            throw new IllegalArgumentException(INPUT_AMOUNT_NOT_NUMBER);
        }
    }

    private int validateDivideMoney(int moneyCount) {
        if (moneyCount < BASE_AMOUNT) {
            throw new IllegalArgumentException(INPUT_AMOUNT_THOUSAND_LESS);
        }
        return moneyCount / BASE_AMOUNT;
    }

    public int getInputMoney() {
        return inputMoney;
    }

}
