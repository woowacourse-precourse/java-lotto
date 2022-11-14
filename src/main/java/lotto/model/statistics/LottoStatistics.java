package lotto.model.statistics;

import lotto.model.payment.Payment;

import java.util.Map;

public class LottoStatistics {
    private final Payment payment;
    private final Map<LottoResult, Integer> resultMap;

    LottoStatistics(Payment payment, Map<LottoResult, Integer> resultMap) {
        this.payment = payment;
        this.resultMap = resultMap;
    }

    public String getHistoryDescription() {
        // TODO 구현 필요
        return "";
    }

    public String getReturnRateDescription() {
        // TODO 구현 필요
        return "";
    }
}
