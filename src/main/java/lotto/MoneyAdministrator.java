package lotto;

import ExceptionCollections.CommonException;

import java.util.List;

public class MoneyAdministrator {
    static final int PRICE_PER_LOTTO = 1000;

    public static int getMoney(String payment) {
        validatePayment(Integer.valueOf(payment));
        return Integer.valueOf(payment);
    }

    public static void validatePayment(int payment) {
        CommonException.validatePaymentUnit(payment);
    }

    public static int countLottos(int payment) {
        return payment / PRICE_PER_LOTTO;
    }
}
