package lotto;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class LottoWinRank {
  private final HashMap<Integer, Integer> win_rank = new HashMap<>();

  public LottoWinRank(List<Lotto> lottos, LottoAnswer lottoAnswer) {
    setWinRank(lottos, lottoAnswer);
  }

  private void initWinRank() {
    win_rank.put(3,0);
    win_rank.put(4,0);
    win_rank.put(5,0);
    win_rank.put(6,0);
    win_rank.put(7,0);
  }

  private void setWinRank(List<Lotto> lottos, LottoAnswer lottoAnswer) {
    initWinRank();
    Iterator<Lotto> iter = lottos.iterator();
    int win;

    while (iter.hasNext()) {
      win = iter.next().winningRanking(lottoAnswer);
      if (win > 2) {
        win_rank.put(win, win_rank.get(win) + 1);
      }
    }
  }

  public void printWinRank() {
    System.out.println("당첨 통계");
    System.out.println("---");

    System.out.println("3개 일치 (5,000원) - " + win_rank.get(3) + "개");
    System.out.println("4개 일치 (50,000원) - " + win_rank.get(4) + "개");
    System.out.println("5개 일치 (1,500,000원) - " + win_rank.get(5) + "개");
    System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + win_rank.get(7) + "개");
    System.out.println("6개 일치 (2,000,000,000원) - " + win_rank.get(6) + "개");
  }

  public int calcWinMoney() {
    int reward = 0;

    reward += win_rank.get(3) * 5000;
    reward += win_rank.get(4) * 50000;
    reward += win_rank.get(5) * 1500000;
    reward += win_rank.get(6) * 2000000000;
    reward += win_rank.get(7) * 30000000;

    return reward;
  }
}
