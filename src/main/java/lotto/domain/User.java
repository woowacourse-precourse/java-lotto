package lotto.domain;

import java.util.List;

public class User {

    private final List<Lotto> lottoList;

    private final Integer paymentAmount;

    public User(final List<Lotto> lottoList, final int paymentAmount) throws IllegalArgumentException{
        if (!paymentAmountNotZero(paymentAmount)) {
            throw new IllegalArgumentException();
        }
        if (!validatePaymentAmount(paymentAmount)) {
            throw new IllegalArgumentException();
        }
        this.lottoList = lottoList;
        this.paymentAmount = paymentAmount;
    }

    public List<Lotto> getLottoList() {
        return this.lottoList;
    }

    public Integer getPaymentAmount() {
        return this.paymentAmount;
    }

    private boolean validatePaymentAmount(Integer paymentAmount) {
        return (paymentAmount % 1000) == 0;
    }

    private boolean paymentAmountNotZero(Integer paymentAmount) {
        return paymentAmount != 0;
    }

}
