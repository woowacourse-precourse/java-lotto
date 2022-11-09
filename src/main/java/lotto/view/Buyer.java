package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.view.ErrorMessage.ERROR_BLANK;
import static lotto.view.ErrorMessage.ERROR_LOTTO_LENGTH;
import static lotto.view.ErrorMessage.ERROR_NUMBER_RANGE;
import static lotto.view.ErrorMessage.ERROR_PRICE;
import static lotto.view.Message.BONUS_NUMBER_INPUT;
import static lotto.view.Message.PURCHASE_COUNT;
import static lotto.view.Message.PURCHASE_PRICE;
import static lotto.view.Message.WINNING_NUMBER_INPUT;

import java.util.stream.Stream;

public class Buyer {
    static int purchaseLottoCount;
    static String winningNumber;
    static String bonusNumber;

    void purchaseLotto() {
        System.out.println(PURCHASE_PRICE);
        String purchasePrice = readLine();
        purchaseLottoCount = Integer.parseInt(purchasePrice);
        System.out.println(purchaseLottoCount/1000 + PURCHASE_COUNT);
    }

    void winningNumberInput() {
        System.out.println(WINNING_NUMBER_INPUT);
        winningNumber = readLine();
    }

    void bonusNumberInput() {
        System.out.println(BONUS_NUMBER_INPUT);
        bonusNumber = readLine();
    }

    void validateDivideNumber() {
        if (purchaseLottoCount%1000 != 0) {
            throw new IllegalArgumentException(ERROR_PRICE);
        }
    }

    void validateWinningNumber(String winningNumber) {
        Integer[] WinningNumberArr = Stream.of(winningNumber.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toArray(Integer[]::new);
        for (int i = 0; i < winningNumber.length(); i++) {
            if (WinningNumberArr[i] < 1 || WinningNumberArr[i] > 45) {
                throw new IllegalArgumentException(ERROR_NUMBER_RANGE);
            }
        }
    }

    void validateWinningNumberSize(String winningNumber) {
        winningNumber.split(",");
        if (winningNumber.length() != 6) {
            throw new IllegalArgumentException(ERROR_LOTTO_LENGTH);
        }
    }

    void validateInputBlank(String winningNumber) {
        for (int i = 0; i < winningNumber.length(); i++) {
            if (winningNumber.charAt(i) == ' ') {
                throw new IllegalArgumentException(ERROR_BLANK);
            }
        }
    }
}
