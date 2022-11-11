package lotto.domain;

import lotto.validator.domain.PaymentValidator;

import java.util.List;

public class Payment {
    private static final int LOTTO_PRICE = 1000;
    
    private final int payment;
    
    public Payment(final int payment) {
        validate(payment);
        this.payment = payment;
    }
    
    private void validate(final int payment) {
        PaymentValidator.validate(payment);
    }
    
    public int countOfPurchasedLotto() {
        return payment / LOTTO_PRICE;
    }
    
    public double calculateYield(final List<LottoRank> lottoRanks) {
        return (int) Math.round((double) totalPrizeMoney(lottoRanks) / payment * 1000) / 10.0;
    }
    
    private int totalPrizeMoney(final List<LottoRank> lottoRanks) {
        return lottoRanks.stream()
                .mapToInt(LottoRank::prizeMoney)
                .sum();
    }
    
    @Override
    public String toString() {
        return "Payment{" +
                "payment=" + payment +
                '}';
    }
}
