package lotto.model;

import java.util.*;

public class Referee {

    private static Map<LottoRank, Integer> lottoResultCount;

    public Referee() {
        this.lottoResultCount = new HashMap<>();
    }

    public Map<LottoRank, Integer> getLottoResultCount() {
        return lottoResultCount;
    }

    public void createLottoResult(int correctCountLottoAndWinner, boolean foundBonus) {
        Map<LottoRank, Integer> lottoResultCount = new HashMap<>();
        LottoRank rank = findLottoRank(correctCountLottoAndWinner, foundBonus);
        addLottoCount(rank);
    }

    private static LottoRank findLottoRank(int correctCountLottoAndWinner, boolean foundBonus) {
        LottoRank rank = Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.getCorrectCount() == correctCountLottoAndWinner)
                .filter(lottoRank -> lottoRank.getBonusStatus().isBonus(foundBonus))
                .findFirst()
                .get();
        return rank;
    }

    private static void addLottoCount(LottoRank rank) {
        addLottoCountPresent(rank);
        addLottoCountNotPresent(rank);
    }

    private static void addLottoCountNotPresent(LottoRank rank) {
        if (!isContainRank(rank)) {
            lottoResultCount.put(rank, 1);
        }
    }

    private static void addLottoCountPresent(LottoRank rank) {
        if (isContainRank(rank)) {
            Integer count = lottoResultCount.get(rank);
            lottoResultCount.put(rank, count + 1);
        }
    }

    private static boolean isContainRank(LottoRank rank) {
        return lottoResultCount.containsKey(rank);
    }
}
