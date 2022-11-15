package lotto.domain.score;

import java.util.List;
import lotto.constant.LottoRank;

public class LottoScore {


  private final List<Integer> winNumbers;
  private final Integer bonusNumber;

  public LottoScore(List<Integer> winNumbers, Integer bonusMumber){
    this.winNumbers = winNumbers;
    this.bonusNumber = bonusMumber;
  }

  public LottoRank CompareMatchingRank(List<Integer> purchasedLotto) {
    int matchingNumberCount = getMatchingCountFrom(purchasedLotto);
    int matchingBonusNumberCount = getMatchingBonusCountFrom(purchasedLotto);
    return LottoRank.findRank(matchingNumberCount, matchingBonusNumberCount);
  }

  public Integer getMatchingCountFrom(List<Integer> purchasedLotto) {
    return (int) purchasedLotto.stream().filter( winNumbers::contains ).count();
  }

  public Integer getMatchingBonusCountFrom(List<Integer> purchasedLotto) {
    return (int) purchasedLotto.stream().filter(num -> num.equals( bonusNumber ) ).count();
  }
}
