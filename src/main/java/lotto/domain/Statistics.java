package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Statistics {
    private Map<PrizeMoney, Integer> winningHistory = new LinkedHashMap<>();

    public Statistics() {
        winningHistory.put(PrizeMoney.FIFTH, 0);
        winningHistory.put(PrizeMoney.FOURTH, 0);
        winningHistory.put(PrizeMoney.THIRD, 0);
        winningHistory.put(PrizeMoney.SECOND, 0);
        winningHistory.put(PrizeMoney.FIRST, 0);
        winningHistory.put(PrizeMoney.LOSING, 0);
    }

    public void countWinningLotto(List<List<Integer>> lottos, List<Integer> winningLottoNumbers, int bonusNumber) {
        for (List<Integer> lotto : lottos) {
            int countOfMatch = (int) lotto.stream()
                    .filter(number -> winningLottoNumbers.contains(number))
                    .count();
            addPrizeMoney(countOfMatch, isMatchBonusNumber(lotto, bonusNumber));
        }
    }

    private void addPrizeMoney(int countOfMatch, boolean matchBonusNumber){
        PrizeMoney prizeMoney = PrizeMoney.valueOf(countOfMatch, matchBonusNumber);
        winningHistory.put(prizeMoney, incrementCountOfWinning(prizeMoney));
    }

    private Boolean isMatchBonusNumber(List<Integer> lotto, int bonusNumber) {
        return lotto.contains(bonusNumber);
    }

    private int incrementCountOfWinning(PrizeMoney prizeMoney){
        return winningHistory.get(prizeMoney) + 1;
    }
}