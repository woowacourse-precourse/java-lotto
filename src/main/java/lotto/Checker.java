package lotto;

import constance.Texts;

import java.util.ArrayList;
import java.util.List;

public class Checker {
    public int checkNumber(String input) {

        int number = checkNumeric(input);

        this.checkNegative(number);

        return number;

    }

    public int checkAmountInput(String input) {

        int amount = checkNumber(input);

        this.checkPayment(amount);
        this.checkRemain(amount);

        return amount;
    }

    public List<Integer> checkNumbersInput(String input) {

        List<Integer> numbers=new ArrayList<>();
        String[] inputs = input.split(",");

        for(String s:inputs){
            int number=this.checkNumber(s);
            numbers.add(number);
        }

        return numbers;
    }

    public int checkNumeric(String input) {
        int result;
        try {
            result = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format(Texts.LOTTO_CHECKER_ERROR, input, Texts.LOTTO_CHECKER_ERROR_NON_NUMERIC));
        }
        return result;
    }

    public void checkNegative(int input) {
        if (input < 0) {
            throw new IllegalArgumentException(String.format(Texts.LOTTO_CHECKER_ERROR, input, Texts.LOTTO_CHECKER_ERROR_NEGATIVE));
        }
    }

    public void checkPayment(int input) {
        if (input < 1000) {
            throw new IllegalArgumentException(String.format(Texts.LOTTO_CHECKER_ERROR, input, Texts.LOTTO_CHECKER_ERROR_LACK_OF_AMOUNT));
        }
    }

    public int checkRemain(int input) {
        int remain;
        if (input % 1000 > 0) {
            remain = input % 1000;
            System.out.println(String.format(Texts.LOTTO_CHECKER_EXCEPTION_AMOUNT_REMAIN, input, remain));
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
