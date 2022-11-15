package lotto.domain;

public class InputAmountValidator {

    public static InputAmountValidator inputAmountValidator = new InputAmountValidator();

    public static InputAmountValidator getInstance() {
        return inputAmountValidator;
    }


    public static boolean isValidUnit(int money) {
        if (Math.floorMod(money, LottoConstant.PRICE.getValue()) == 0) return true;
        return false;
    }
}
