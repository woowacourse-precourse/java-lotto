package utils;

import camp.nextstep.edu.missionutils.Console;
import lotto.LottoNumber;

import static constant.Constant.*;
import static constant.ErrorMessage.*;
import static constant.Messages.*;

public class UserInput {

    public static int inputPrice() {
        System.out.println(INPUT_PRICE_MESSAGE);
        String price = Console.readLine();
        validIsDigit(price);
        validMoneyUnit(Integer.parseInt(price));
        return calculateNumOfLotto(Integer.parseInt(price));
    }

    public static void inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUM_MESSAGE);
        String winningNumbers = Console.readLine();
        validWinningNumbers(winningNumbers);

        System.out.println(INPUT_BONUS_NUM_MESSAGE);
        String bonusNumber = Console.readLine();
        validIsDigit(bonusNumber);
        new LottoNumber(winningNumbers, bonusNumber);
    }

    private static void validWinningNumbers(String winningNumbers) {
        for (String num : winningNumbers.split(",")) {
            validIsDigit(num);
            validNumberRange(Integer.parseInt(num));
        }
    }

    private static void validIsDigit(String price) {
        try {
            Integer.parseInt(price);
        } catch (IllegalArgumentException e) {
            System.out.println(NOT_NUMBER);
            throw new IllegalArgumentException(NOT_NUMBER);
        }
    }

    private static void validNumberRange(int num) {
        if (num < LOTTO_NUMBER_MIN || num > LOTTO_NUMBER_MAX) {
            System.out.println(NOT_LOTTO_NUMBER_RANGE);
            throw new IllegalArgumentException(NOT_LOTTO_NUMBER_RANGE);
        }
    }

    private static void validMoneyUnit(int price) {
        if (price % MONEY_UNIT != REMAINDER_ZERO) {
            System.out.println(NOT_RADIX_1000);
            throw new IllegalArgumentException(NOT_RADIX_1000);
        }
    }

    private static int calculateNumOfLotto(int price) {
        return price / MONEY_UNIT;
    }
}
