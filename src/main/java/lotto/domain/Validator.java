package lotto.domain;

import lotto.view.IOProcessor;

public class Validator {

    public static boolean amountUnitIsValid(String userInput, int unit) {
        isNumber(userInput);
        int amount = Integer.parseInt(userInput);
        if(amount % unit != 0) {
            IOProcessor.printErrorMessage("구매금액의 단위가 " + unit + "원이 아닙니다.");
            throw new IllegalArgumentException();
        }
        return true;
    }

    public static void winningNumberIsValid() {

    }

    public static void bonusNumberIsValid() {

    }

    private static boolean isNumber(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            if (!Character.isDigit(userInput.charAt(i))) {
                IOProcessor.printErrorMessage("구매금액이 숫자로 구성되어 있지 않습니다.");
                throw new IllegalArgumentException();
            }
        }
        return true;
    }
}
