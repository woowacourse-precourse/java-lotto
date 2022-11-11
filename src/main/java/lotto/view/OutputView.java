package lotto.view;

import lotto.util.LottoMessage;

public class OutputView {
    public static void printQuantity(int quantity) {
        System.out.println(quantity + LottoMessage.QUANTITY.getMessage());
    }
}
