package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.view.ErrorMessage.ERROR_BLANK;
import static lotto.view.ErrorMessage.ERROR_LOTTO_LENGTH;
import static lotto.view.ErrorMessage.ERROR_PRICE;
import static lotto.view.Message.BONUS_NUMBER_INPUT;
import static lotto.view.Message.PURCHASE_COUNT;
import static lotto.view.Message.PURCHASE_PRICE;
import static lotto.view.Message.WINNING_NUMBER_INPUT;

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

    void validateDivideNumber() {
        if (purchaseLottoCount%1000 != 0) {
            throw new IllegalArgumentException(ERROR_PRICE);
        }
    }
}
