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
        return getLottoRanks(winningMatchNumber);
    }

    //초기 세팅한 로또 맵에 로또 개수 반환
    private LinkedHashMap<LottoRank, Integer> getLottoRanks(List<Integer> winningMatchNumber) {
        LinkedHashMap<LottoRank, Integer> ranks = createLottoRanks();
        for (LottoRank lottoRank : ranks.keySet()) {
            Integer count = winningMatchNumber.stream().
                    filter(number -> lottoRank.getCount() == number)
                    .findAny()
                    .orElse(LottoRank.MISS_MATCH.getCount());
            if (count >= 3) {
                ranks.put(lottoRank, ranks.get(lottoRank) + 1);
            }
        }
        return ranks;
    }

    //로또 랭크 맵 초기 세팅
    private LinkedHashMap<LottoRank, Integer> createLottoRanks() {
        LinkedHashMap<LottoRank, Integer> ranks = new LinkedHashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            if (rank.getMoney() == 0) {
                continue;
            }
            ranks.put(rank, 0);
        }
        return ranks;
    }

    //일치하는 당첨번호 반환
    private List<Integer> getWinningMatchNumbers(List<Integer> winningNumber, int bonusNumber) {
        List<Integer> winningMatchNumber = new ArrayList<>();
        for (List<Integer> lotto : lottos) {
            int count = (int) winningNumber.stream().
                    filter(lotto::contains)
                    .count();
            if (count >= 5 && lotto.contains(bonusNumber)) {
                winningMatchNumber.add(LottoRank.FIVE_MATCH_AND_BONUS_MATCH.getCount());
                continue;
            }
            if (count >= 3) {
                winningMatchNumber.add(count);
            }
        }
        return winningMatchNumber;
    }

    //계산하는 로직
    public float revenueCalculation(int amount) {
        int revenue = getRevenue();
        float yiled = ((float) revenue / (float) amount) * 100;
        return yiled;
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
