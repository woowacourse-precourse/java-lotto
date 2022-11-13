package lotto.domain;

public class LotteryShop {

    private int lottoCnt;

    public LotteryShop (int totalPayment) {
        countLotto(totalPayment);
    }

    private void countLotto(int totalPayment) {
        validate(totalPayment);
    }

    private void validate(int totalPayment) {
    }
}
