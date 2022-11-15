package domain;

import dto.ScratchResult;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 플레이어가 발행한 전체 로또 목록을 관리하는 클래스
 */
public class LottoPocket {

    private List<Lotto> lottoGroup;

    public LottoPocket(List<Lotto> lottoGroup) {
        this.lottoGroup = lottoGroup;
    }

    public ScratchResult getScratchResult(WinningLotto winningLotto) {
        Map<LottoGrade, Integer> numberOfWinsByGrade = getNumberOfWinsByGrade(winningLotto);
        long totalEarning = getTotalEarning(numberOfWinsByGrade);
        double earningRate = getEarningRate(totalEarning);

        return new ScratchResult(numberOfWinsByGrade, totalEarning, earningRate);
    }

    private Map<LottoGrade, Integer> getNumberOfWinsByGrade(WinningLotto winningLotto) {
        Map<LottoGrade, Integer> numberOfWinsByGrade = new LinkedHashMap();

        lottoGroup.forEach((lotto) -> {
            LottoGrade grade = winningLotto.getCompareResult(lotto);
            numberOfWinsByGrade.put(grade, numberOfWinsByGrade.getOrDefault(grade, 0) + 1);
        });

        return Collections.unmodifiableMap(numberOfWinsByGrade);
    }

    private long getTotalEarning(Map<LottoGrade, Integer> numberOfWinsByGrade) {
        return numberOfWinsByGrade.keySet().stream().mapToLong((grade) -> numberOfWinsByGrade.get(grade) * grade.prize)
                .reduce(Long::sum).orElse(0);
    }

    private double getEarningRate(double totalEarning) {
        return (totalEarning * 100) / (lottoGroup.size() * LottoPublisher.LOTTO_COST);
    }
}
