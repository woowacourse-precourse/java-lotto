package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Domain.Message;

public class InputView {
    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_MUM = 45;

    public static int inputPurchaseAmount() {
        System.out.println(Message.INPUT_LOTTO_PURCHASE_AMOUNT);
        String ans = Console.readLine();
        return checkIsDigit(ans);
    }

    public static int checkIsDigit(String purchaseAmount) {
        try {
            return Integer.parseInt(purchaseAmount);
        } catch (Exception e) {
            throw new IllegalArgumentException(Message.ERROR_PURCHASE_AMOUNT_IS_NOT_INT);
        }

    }
}
