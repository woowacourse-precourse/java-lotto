package lotto.view;

import lotto.domain.OutputMessage;

public class OutputView {
    public void printQuantity(int quantity) {
        System.out.println(quantity + OutputMessage.PRINT_LOTTO_QUANTITY.toString());
    }
}
