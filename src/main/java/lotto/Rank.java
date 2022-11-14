package lotto;

import java.util.Arrays;
import java.util.List;

public enum Rank {
  First(1, 6, 0, 2_000_000_000),
  Second(2, 5, 1, 30_000_000),
  Third(3 , 5, 0, 1_500_000),
  Fourth(4, 4, 0, 50_000),
  Fifth(5, 3, 0, 5_000),
  None(0, 0, 0, 0);

  private final int rank;
  private final int lotto;
  private final int bonus;
  private final int reward;

  Rank(int rank, int lotto, int bonus, int reward) {
    this.rank = rank;
    this.lotto = lotto;
    this.bonus = bonus;
    this.reward = reward;
  }

  public static void calcRank(long price, List<Lotto> lottos, List<Integer> winningLotto, int bonus) {
    int[] ranks = new int[6];
    long rewardSum = 0;
    for(Lotto lotto : lottos) {
      Rank curRank = matchLotto(lotto, winningLotto, bonus);
      ranks[curRank.rank]++;
      rewardSum += curRank.reward;
    }

    System.out.println("당첨 통계");
    System.out.println("---");
    System.out.println("3개 일치 (5,000원) - " + ranks[5] + "개");
    System.out.println("4개 일치 (50,000원) - " + ranks[4] + "개");
    System.out.println("5개 일치 (1,500,000원) - " + ranks[3] + "개");
    System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + ranks[2] + "개");
    System.out.println("6개 일치 (2,000,000,000원) - " + ranks[1] + "개");
    System.out.println("총 수익률은 " + String.format("%.1f", (double)rewardSum / price * 100)  + "%입니다.");
  }

  public static Rank matchLotto(Lotto lotto, List<Integer> winningLotto, int bonus) {
    int matches = 0, matchBonus = 0;
    for(int num : winningLotto) {
      if(lotto.contains(num)) {
        matches++;
      }
    }
    if(lotto.contains(bonus)) {
      matchBonus++;
    }

    for(Rank r : values()) {
      if(r.lotto == matches && r.bonus == matchBonus) {
        return r;
      }
    }
    return None;
  }
}
