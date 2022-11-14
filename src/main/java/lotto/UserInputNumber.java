package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UserInputNumber {

    private final int purchaseInput;

    public UserInputNumber(String purchaseInput) {
        validatePurchaseAmount(purchaseInput);
        validateThousandUnit(Integer.parseInt(purchaseInput));
    }
    private void validatePurchaseAmount(String inputNumber) {
        try {
            int p = Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException ("숫자를 입력해주세요.");
        }
    }
    private void validateThousandUnit(Integer inputNumber) {
        if (inputNumber % 1000 !=0) {
            throw new IllegalArgumentException ("입력은 1000원 단위의 숫자만 가능합니다.");
        }
    }

}

