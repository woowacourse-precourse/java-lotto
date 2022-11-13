package lotto;

import java.util.*;

public class Game {

  private List<Lotto> lotteries;
  private Lotto winningNumber;
  private int bonusNumber;

  public Game() {
    this.lotteries = new ArrayList<>();
  }

  // 맞춘 개수와 보너스 넘버 포함 여부로 랭킹 알아보기
  public Ranking valueOf(int num, boolean hasBonusNumber) {
    for (Ranking ranking : Ranking.values()) {
      if (ranking.getNumber() == num) {
        if (num == 5) {
          fiveSameNumber(hasBonusNumber);
        }
        return ranking;
      }
    }
    return null;
  }

  // 5개일 때 보너스 넘버 포함 여부 나누는 메서드
  public Ranking fiveSameNumber(boolean hasBonusNumber) {
    if (hasBonusNumber) {
      return Ranking.SECOND;
    }
    else
      return Ranking.THIRD;
  }

  public boolean hasBonusNumber(Lotto lotto, int bonusNumber) {
    return lotto.getNumbers().contains(bonusNumber);
  }

}
