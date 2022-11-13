package lotto;

import constance.Texts;

public class Checker {
    public int checkInputNumber(String input) {

        int number = checkNumeric(input);

        checkNegative(number);
        checkAmount(number);

        return number;

    }

    public int checkAmountInput(String input) {

        int amount = checkInputNumber(input);

        checkRemain(amount);

        return amount;
    }

    public int checkNumeric(String input) {
        int result;
        try {
            result = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format(Texts.LOTTO_CHECKER_ERROR, Texts.LOTTO_CHECKER_ERROR_NON_NUMERIC));
        }
        return result;
    }

    public void checkNegative(int input) {
        if (input < 0) {
            throw new IllegalArgumentException(String.format(Texts.LOTTO_CHECKER_ERROR, Texts.LOTTO_CHECKER_ERROR_NEGATIVE));
        }
    }

    public void checkAmount(int input) {
        if (input < 1000) {
            throw new IllegalArgumentException(String.format(Texts.LOTTO_CHECKER_ERROR, Texts.LOTTO_CHECKER_ERROR_LACK_OF_AMOUNT));
        }
    }

    public int checkRemain(int input) {
        int remain;
        if (input % 1000 > 0) {
            remain = input % 1000;
            System.out.println(String.format(Texts.LOTTO_CHECKER_EXCEPTION_AMOUNT_REMAIN, remain));
            input -= remain;
        }
        return input;
    }

    public void checkDuplicated(String input) {
    }

    public int checkCoincide() {
        return 0;
    }

    public float checkLotteryReturn() {
        return 0F;
    }

}
