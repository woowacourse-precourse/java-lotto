package lotto.model.statistics;

import lotto.model.payment.Payment;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class LottoStatistics {
    private static final DecimalFormat decimalFormatter = new DecimalFormat("###,###.#");
    private final Payment payment;
    private final Map<LottoResult, Integer> resultMap;

    LottoStatistics(Payment payment, Map<LottoResult, Integer> resultMap) {
        this.payment = payment;
        this.resultMap = resultMap;
    }

    public String getHistoryDescription() {
        StringBuilder stringBuilder = new StringBuilder();
        for (LottoResult lottoResult: LottoResult.values()) {
            if(lottoResult.equals(LottoResult.MISS)) {
                continue;
            }

            int resultCount = resultMap.getOrDefault(lottoResult, 0);
            stringBuilder.append(lottoResult.getDescription())
                    .append(" - ")
                    .append(resultCount)
                    .append("개\n");
        }
        return stringBuilder.toString();
    }

    public String getReturnRateDescription() {
        AtomicInteger totalPrize = new AtomicInteger();
        resultMap.forEach((lottoResult, count) -> {
            totalPrize.addAndGet(lottoResult.getPrize() * count);
        });
        float returnRate = (totalPrize.floatValue() / (float) payment.getAmount());

        return "총 수익률은 " + decimalFormatter.format(returnRate) + "%입니다.";
    }
}
