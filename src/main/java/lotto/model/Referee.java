package lotto.model;

import java.util.*;

import static lotto.constValue.Constants.LottoInfo.COUNT_RANGE;

public class Referee {

    private static Map<LottoRank, Integer> lottoResultCount;

    public Referee() {
        this.lottoResultCount = new HashMap<>();
    }

    public Map<LottoRank, Integer> getLottoResultCount() {
        return lottoResultCount;
    }

    public void createLottoResult(List<Lotto> lottos, List<Integer> winningNumber, int bonusNum) {
        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            createLottoResultCount(lottoNumbers, winningNumber, bonusNum);
        }
    }

    public void createLottoResultCount(List<Integer> lottoNumbers, List<Integer> winningNumber, int bonusNum) {
        int correctCount = correctCountLottoNumAndWinnerNum(lottoNumbers, winningNumber);
        boolean foundBonus = isBonusNumberInWinningNumber(winningNumber, bonusNum);
        putLottoResultCount(correctCount, foundBonus);
    }

    public int correctCountLottoNumAndWinnerNum(List<Integer> lottoNumber, List<Integer> winnerNumber) {
        int correctCount = 0;
        for (int i = 0; i < COUNT_RANGE; i++) {
            correctCount = getCorrectCount(lottoNumber, winnerNumber, correctCount, i);
        }
        return correctCount;
    }

    private static int getCorrectCount(List<Integer> lottoNumber, List<Integer> winnerNumber, int correctCount, int i) {
        if (winnerNumber.contains(lottoNumber.get(i))) {
            correctCount++;
        }
        return correctCount;
    }

    public boolean isBonusNumberInWinningNumber(List<Integer> winningNumber, int bonusNum) {
        return winningNumber.contains(bonusNum);
    }

    public void putLottoResultCount(int correctCountLottoAndWinner, boolean foundBonus) {
        LottoRank rank = findLottoRank(correctCountLottoAndWinner, foundBonus);
        if (rank != null) {
            addLottoCount(rank);
        }
    }

    private static LottoRank findLottoRank(int correctCountLottoAndWinner, boolean foundBonus) {
        LottoRank rank = Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.getCorrectCount() == correctCountLottoAndWinner)
                .filter(lottoRank -> lottoRank.getBonusStatus().isBonus(foundBonus))
                .findFirst()
                .orElse(null);
        return rank;
    }

    private static void addLottoCount(LottoRank rank) {
        addLottoResultCountPresent(rank);
        addLottoResultCountNonPresent(rank);
    }

    private static void addLottoResultCountNonPresent(LottoRank rank) {
        if (!isContainRank(rank)) {
            lottoResultCount.put(rank, 1);
        }
    }

    private static void addLottoResultCountPresent(LottoRank rank) {
        if (isContainRank(rank)) {
            Integer count = lottoResultCount.get(rank);
            lottoResultCount.put(rank, count + 1);
        }
    }

    private static boolean isContainRank(LottoRank rank) {
        return lottoResultCount.containsKey(rank);
    }
}
