package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Statistics {
    private final List<LottoResult> kindOfResult =generateKindOfResult();
    private final Map<String, Long> lottoResultMap = generateLottoResultMap();

    private final Double benefitRatio;

    public Statistics(LottoList lottoList, AnswerNumberList answerNumbers, Money input) {
        checkWinningsInLottoList(lottoList.getLottoList(), answerNumbers);
        Money benefit = new Money(getResultCompensation());
        benefitRatio = input.getRatio(benefit);
    }

    public void printStatistics(){
        printResultMap();
        printBenefitRatio();
    }

    private Map<String, Long> generateLottoResultMap() {
        HashMap<String, Long> map = new HashMap<>();
        for (var kind : Objects.requireNonNull(kindOfResult)) {
            map.put(kind.name(), 0L);
        }
        map.put(LottoResult.NOTHING.name(), 0L);
        return map;
    }

    private List<LottoResult> generateKindOfResult(){
        return List.of(LottoResult.FIFTH, LottoResult.FOURTH, LottoResult.THIRD,
                LottoResult.SECOND, LottoResult.FIRST);
    }

    private void checkWinningsInLottoList(List<Lotto> lottoList, AnswerNumberList answerNumbers) {
        for (var lotto : lottoList) {
            LottoResult lottoResult = answerNumbers.checkLottoWinning(lotto);
            lottoResultMap.replace(lottoResult.name(), lottoResultMap.get(lottoResult.name()) + 1);
        }
    }

    private void printResultMap() {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (var kind : kindOfResult) {
            System.out.println(kind.getMessage() + " - " + lottoResultMap.get(kind.name()) + "개");
        }
    }

    private Long getResultCompensation() {
        long sum = 0L;
        for (var kind : kindOfResult) {
            sum += kind.getCompensation() * lottoResultMap.get(kind.name());
        }
        return sum;
    }

    private void printBenefitRatio() {
        System.out.println("총 수익률은 " + Math.round(benefitRatio * 10) / 10.0 + "%입니다.");
    }
}
