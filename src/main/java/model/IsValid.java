package model;

import static model.Constant.END_INCLUSIVE;
import static model.Constant.MINIMUM_LOTTO_PRICE;
import static model.Constant.START_INCLUSIVE;
import static model.Constant.ZERO;

import controller.StartLotto;
import error.Error;

public class IsValid {
    private static final String NUMBER_REGEX = "[0-9]+";

    public static void moneyUnit(int userInput) {
        if (userInput % MINIMUM_LOTTO_PRICE.constant != ZERO.constant) {
            Error.message(Error.INADEQUATE_MONEY_UNIT);
        }
    }

    public static void repetitionNumber(int userInput) {
        if (StartLotto.winNumber.checkContainNumber(userInput)) {
            Error.message(Error.LOTTO_NUMBER_REPETITION);
        }
    }

    public static void inclusiveNumber(int userInput) {
        if (userInput < START_INCLUSIVE.constant || userInput > END_INCLUSIVE.constant) {
            Error.message(Error.NUMBER_OUT_OF_BOUNDS);
        }
    }

    public static void bonusNumber(int userInput) {
        IsValid.correctNumber(Integer.toString(userInput));
        IsValid.inclusiveNumber(userInput);
        IsValid.repetitionNumber(userInput);
    }

    public static void correctNumber(String number) {
        if (!number.matches(NUMBER_REGEX)) {
            Error.message(Error.INADEQUATE_INPUT_MONEY);
        }
    }
}