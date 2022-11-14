package lotto.io;

import static lotto.io.Message.BOUGHT_N;
import static lotto.io.Message.ERROR;
import static lotto.io.Message.INPUT_BONUS_NUMBER;
import static lotto.io.Message.INPUT_PURCHASE_AMOUNT;
import static lotto.io.Message.INPUT_WINNING_NUMBERS;
import static lotto.io.Message.LF;

import lotto.domain.IssuedLotto;

public class Writer {

    private Writer() {

    }

    public static void inputPurchaseAmount() {
        write(INPUT_PURCHASE_AMOUNT);
    }

    public static void sendErrorMessage(String message) {
        write(ERROR + message);
    }

    public static void printIssuedLottoList(IssuedLotto issuedLotto) {
        StringBuilder sb = new StringBuilder();
        sb.append(issuedLotto.getAmount())
          .append(BOUGHT_N).append(LF)
          .append(issuedLotto);

        write(sb.toString());
    }

    public static void inputWinningNumber() {
        write(INPUT_WINNING_NUMBERS);
    }

    public static void inputBonusNumber() {
        write(INPUT_BONUS_NUMBER);
    }

    private static void write(String message) {
        System.out.println(message + LF);
    }

}
