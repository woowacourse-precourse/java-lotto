package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.printer.RequestInputPrinter;

public class LottoPurchaseService {

    private Integer enterPaymentAmount() {
        RequestInputPrinter.paymentAmountInputGuide();
        return Integer.parseInt(Console.readLine());
    }

}
