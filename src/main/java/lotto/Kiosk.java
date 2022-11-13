package lotto;

import ExceptionCollections.CommonException;
import ExceptionCollections.PaymentException;
import View.Input;
import View.Output;

import java.util.List;

public class Kiosk {
    static final int LOTTO_PRICE = 1000;
    static protected List<Integer> winningNumbers;
    static protected int bonusNumber;
    static protected Integer[] resultStatistics = {0, 0, 0, 0, 0};
    static protected Buyer buyer;

    static public void start(Buyer buyer) {
        int payment = getPurchaseAmount();
        int numberOfLottos = countLottos(payment);
        buyer = new Buyer(Generator.generate(numberOfLottos));
    }

    static private int getPurchaseAmount() {
        Output.getPurchaseAmount();
        String payment = Input.getPurchaseMoney();
        PaymentException.validate(payment);
        return Integer.valueOf(payment);
    }

    static private int countLottos(int payment) {
        return payment / LOTTO_PRICE;
    }


}
