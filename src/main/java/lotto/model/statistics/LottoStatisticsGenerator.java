package lotto.model.statistics;

import lotto.model.payment.Payment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatisticsGenerator {
    private final Payment payment;
    private List<LottoResult> results;

    public LottoStatisticsGenerator(Payment payment) {
        this.payment = new Payment(payment);
    }

    public void setResult(List<LottoResult> results) {
        this.results = new ArrayList<>(results);
    }

    public LottoStatistics generate() {
        if(results == null) {
            throw new IllegalCallerException("당첨 결과를 설정 하기 전에 generate 를 할 수 없습니다.");
        }

        Map<LottoResult, Integer> resultMap = new HashMap<>();
        for(LottoResult result: results) {
            int resultCount = resultMap.getOrDefault(result, 0) + 1;
            resultMap.put(result, resultCount);
        }
        return new LottoStatistics(payment, resultMap);
    }
}
