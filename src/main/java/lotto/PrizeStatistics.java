package lotto;

import java.util.List;

public class PrizeStatistics {
  private PrizeRank[] prizeRankArray;
  private final Lotto prizeLotto;
  private final int bonusNumber;

  public PrizeStatistics(Lotto prizeLotto, int bonusNumber) {
    this.prizeRankArray = PrizeRank.values();
    this.prizeLotto = prizeLotto;
    this.bonusNumber = bonusNumber;
  }

  public int calculatePrizeMoney() {
    int prizeMoney = 0;
    for (PrizeRank prizeRank : prizeRankArray) {
      prizeMoney += prizeRank.getPrizeCount() * prizeRank.getPrizeMoney();
    }
    return prizeMoney;
  }

  public void setPrizeRankArrayByLottoList(List<Lotto> myLottoList) {
    PrizeRank.resetAllCount();
    for (Lotto lotto : myLottoList) {
      updatePrizeRankArray(lotto);
    }
  }

  private void updatePrizeRankArray(Lotto myLotto) {
    List<Integer> myLottoNumbers = myLotto.getLottoNumbers();
    int count = 0;
    for (int number : myLottoNumbers) {
      if (prizeLotto.isNumberContained(number)) {
        count++;
      }
    }
    updateMatchingPrizeRank(count, isBonusNumberContained(myLotto));
  }

  private boolean isBonusNumberContained(Lotto myLotto) {
    return myLotto.isNumberContained(bonusNumber);
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
