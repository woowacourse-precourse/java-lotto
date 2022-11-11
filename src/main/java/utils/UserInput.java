package utils;

import camp.nextstep.edu.missionutils.Console;
import lotto.LottoNumber;

import static constant.Constant.*;
import static constant.ErrorMessage.NOT_NUMBER;
import static constant.Messages.*;

public class UserInput {


    public static int inputPrice() {
        System.out.println(INPUT_PRICE_MESSAGE);
        String price = Console.readLine();
        validPriceOfLotto(price);
        validMoneyUnit(Integer.parseInt(price));
        return calculateNumOfLotto(Integer.parseInt(price));
    }

    public static LottoNumber inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUM_MESSAGE);
        String winningNumbers = Console.readLine();

        System.out.println(INPUT_BONUS_NUM_MESSAGE);
        String bonusNumber = Console.readLine();
        return new LottoNumber(winningNumbers, bonusNumber);
    }

    private static void validPriceOfLotto(String price) {
        if (price.equals(EMPTY)){
            System.out.println(NOT_NUMBER);
            throw new IllegalArgumentException(NOT_NUMBER);
        }
        for (int i = INITIAL_NUMBER; i < price.length(); i++) {
            if (!Character.isDigit(price.charAt(i))) {
                System.out.println(NOT_NUMBER);
                throw new IllegalArgumentException(NOT_NUMBER);
            }
        }
    }

    private static void validMoneyUnit(int price) {
        if (price%MONEY_UNIT!=REMAINDER_ZERO) {
            System.out.println("[ERROR] 1,000원 단위로 입력해주세요.");
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해주세요.");
        }
    }

    private static int calculateNumOfLotto(int price) {
        return price/MONEY_UNIT;
    }
}
