package lotto.domain.cashier;

public class CashierImpl implements Cashier {

    private static final int lottoPrice = 1000;


    @Override
    public int checkPublishLottoCount(int paymentAmount) {
        return paymentAmount / lottoPrice;
    }

    @Override
    public double calculateRateOfReturn(int paymentAmount, int totalPrizeMoney) {
        double rateOfReturn = (double) totalPrizeMoney / (double) paymentAmount * 100;
        return  Math.round(rateOfReturn * 10) / 10.0;
    }
}
