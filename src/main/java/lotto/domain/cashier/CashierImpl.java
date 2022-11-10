package lotto.domain.cashier;

public class CashierImpl implements Cashier {

    private static final int lottoPrice = 1000;


    @Override
    public int checkPublishLottoCount(int paymentAmount) {
        return paymentAmount / lottoPrice;
    }
}
