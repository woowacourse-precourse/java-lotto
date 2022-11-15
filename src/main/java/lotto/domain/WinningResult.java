package lotto.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class WinningResult {
    List<List<Integer>> lottos;
    LinkedHashMap<LottoRank, Integer> statistics;

    public WinningResult(List<List<Integer>> lottos) {
        this.lottos = lottos;
    }

    public LinkedHashMap<LottoRank, Integer> getStatistics(List<Integer> winningNumber, int bonusNumber) {
        return this.statistics = statistics(winningNumber, bonusNumber);
    }

    //통계
    private LinkedHashMap<LottoRank, Integer> statistics(List<Integer> winningNumber, int bonusNumber) {
        List<Integer> winningMatchNumber = getWinningMatchNumbers(winningNumber, bonusNumber);
        return getMatchLottoRanks(winningMatchNumber);
    }

    //초기 세팅한 로또 맵에 로또 개수 반환
    private LinkedHashMap<LottoRank, Integer> getMatchLottoRanks(List<Integer> winningMatchNumber) {
        LinkedHashMap<LottoRank, Integer> ranks = createLottoRanks();
        for (LottoRank lottoRank : ranks.keySet()) {
            if (getMatchRank(winningMatchNumber, lottoRank) >= 3) {
                ranks.put(lottoRank, ranks.get(lottoRank) + 1);
            }
        }
        return ranks;
    }

    private Integer getMatchRank(List<Integer> winningMatchNumber, LottoRank lottoRank) {
        return winningMatchNumber.stream().
                filter(number -> lottoRank.getCount() == number)
                .findAny()
                .orElse(LottoRank.MISS_MATCH.getCount());
    }

    //로또 랭크 맵 초기 세팅
    private LinkedHashMap<LottoRank, Integer> createLottoRanks() {
        LinkedHashMap<LottoRank, Integer> ranks = new LinkedHashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            if (rank == LottoRank.MISS_MATCH) {
                continue;
            }
            ranks.put(rank, 0);
        }
        return ranks;
    }

    //일치하는 당첨번호 반환
    private List<Integer> getWinningMatchNumbers(List<Integer> winningNumber, int bonusNumber) {
        List<Integer> winningMatchNumbers = new ArrayList<>();
        for (List<Integer> lotto : lottos) {
            int winningMatchCount = getWinningMatchCount(winningNumber,lotto);
            if (winningMatchCount >= LottoRank.FIVE_MATCH.getCount() && lotto.contains(bonusNumber)) {
                winningMatchNumbers.add(LottoRank.FIVE_MATCH_AND_BONUS_MATCH.getCount());
                continue;
            }
            if (winningMatchCount >= LottoRank.THREE_MATCH.getCount()) {
                winningMatchNumbers.add(winningMatchCount);
            }
        }
        return winningMatchNumbers;
    }

    private int getWinningMatchCount(List<Integer> winningNumber, List<Integer> lotto) {
        return (int) winningNumber.stream()
                .filter(lotto::contains)
                .count();
    }

    //계산하는 로직
    public float revenueCalculation(int amount) {
        int revenue = getRevenue();
        return ((float) revenue / (float) amount) * 100;
    }

    private int getRevenue() {
        int sum = 0;
        for (LottoRank lottoRank : statistics.keySet()) {
            for (int i = 0; i < statistics.get(lottoRank); i++) {
                sum += lottoRank.getMoney();
            }
        }
        return sum;
    }

}
