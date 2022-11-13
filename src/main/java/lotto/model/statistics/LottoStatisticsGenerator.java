package lotto.model.statistics;

import lotto.model.payment.Payment;

import java.util.List;

public class LottoStatisticsGenerator {
    private Payment payment;
    private List<LottoResult> results;

    public LottoStatisticsGenerator(Payment payment) {
        // TODO 구현 필요
    }

    public void setResult(List<LottoResult> results) {
        // TODO 구현 필요
    }

    public LottoStatistics generate() {
        // TODO 구현 필요

        return new LottoStatistics(payment, results);
    }
}
