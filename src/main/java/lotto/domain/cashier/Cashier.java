package lotto.domain.cashier;

public interface Cashier {

    int checkPublishLottoCount(int paymentAmount);

    double calculateRateOfReturn(int paymentAmount, int totalPrizeMoney);

}
