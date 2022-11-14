package lotto.model.statistics;

import lotto.model.payment.Payment;

import java.text.DecimalFormat;
import java.util.Map;

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
                    .append("개");
        }
        return stringBuilder.toString();
    }

    public String getReturnRateDescription() {
        // TODO 구현 필요
        return "";
    }
}
