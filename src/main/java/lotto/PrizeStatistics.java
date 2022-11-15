package lotto;

import java.util.List;

public class PrizeStatistics {
  private PrizeRank[] prizeRankArray;
  private final Lotto prizeLotto;
  private final int bonusNumber;

  public PrizeStatistics(Lotto prizeLotto, int bonusNumber) {
    this.prizeRankArray = new PrizeRank[PrizeRank.values().length];
    this.prizeLotto = prizeLotto;
    this.bonusNumber = bonusNumber;
  }

  public void setPrizeRankArrayByLottoList(List<Lotto> myLottoList) {
    for (Lotto lotto : myLottoList) {
      updatePrizeRankArray(lotto.getLottoNumbers());
    }
  }

  public void updatePrizeRankArray(List<Integer> myLottoNumbers) {
    int count = 0;
    for (int number : myLottoNumbers) {
      if (prizeLotto.isNumberContained(number)) count++;
    }
    updateMatchingPrizeRank(count, isBonusNumberContained());
  }

  private boolean isBonusNumberContained() {
    return prizeLotto.isNumberContained(bonusNumber);
  }

  private void updateMatchingPrizeRank(int count, boolean isBonusNumberContained) {
    for (PrizeRank prizeRank : prizeRankArray) {
      if (prizeRank.isSamePrizeRank(count, isBonusNumberContained)) {
        prizeRank.increasePrizeCount();
        break;
      }
    }
  }
}
