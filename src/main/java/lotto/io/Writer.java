package lotto.io;

import static lotto.io.Message.ERROR;
import static lotto.io.Message.INPUT_PURCHASE_AMOUNT;
import static lotto.io.Message.LF;

public class Writer {

    private Writer() {

    }

    public static void inputPurchaseAmount() {
        write(INPUT_PURCHASE_AMOUNT);
    }

    public static void sendErrorMessage(String message) {
        write(ERROR + message);
    }

    private static void write(String message) {
        System.out.println(message + LF);
    }

}
