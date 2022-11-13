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

    public void createLottoResult(List<Lotto> lottos, List<Integer> winnerNumber, int bonusNum){
        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            createLottoResultCount(winnerNumber, bonusNum, lottoNumbers);
        }
    }

    public void createLottoResultCount(List<Integer> winnerNumber, int bonusNum, List<Integer> lottoNumbers) {
        int correctCount = correctCountLottoNumberAndWinnerNum(lottoNumbers, winnerNumber);
        boolean foundBonus = isBonusNumberInLottoNumber(winnerNumber, bonusNum);
        putLottoResultCount(correctCount,foundBonus);
    }

    public int correctCountLottoNumberAndWinnerNum(List<Integer> lottoNumber, List<Integer> winnerNumber) {
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (winnerNumber.contains(lottoNumber.get(i))) {
                count++;
            }
        }
        return count;
    }

    public boolean isBonusNumberInLottoNumber(List<Integer> winningNumber, int bonusNum) {
        return winningNumber.contains(bonusNum);
    }

    public void putLottoResultCount(int correctCountLottoAndWinner, boolean foundBonus) {
        LottoRank rank = findLottoRank(correctCountLottoAndWinner, foundBonus);
        if(rank!=null) {
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
