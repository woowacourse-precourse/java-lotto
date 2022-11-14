package lotto;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Game {

  private List<Lotto> lotteries;
  private Lotto winningNumber;
  private int bonusNumber;

  public Game() {
    this.lotteries = new ArrayList<>();
  }

  private final Map<Ranking, Integer> winningResult = new EnumMap<>(Ranking.class);

  // 맞춘 개수와 보너스 넘버 포함 여부로 랭킹 알아보기
  public Ranking valueOf(int num, boolean hasBonusNumber) {
    for (Ranking ranking : Ranking.values()) {
      if (ranking.getNumber() == num) {
        if (num == 5) {
          if (hasBonusNumber) {
            return Ranking.SECOND;
          }
          else
            return Ranking.THIRD;
        }
        return ranking;
      }
    }
    return null;
  }

  public boolean hasBonusNumber(Lotto lotto, int bonusNumber) {
    return lotto.getNumbers().contains(bonusNumber);
  }

  // 등수별 0명으로 초기화
  public void initialWinningResult() {
    for (Ranking ranking : Ranking.values()) {
      winningResult.put(ranking, 0);
    }
  }

  // 로또 한 개 당첨 번호와 돌아가면서 비교하고 같은 수의 개수 반환
  public int compare(Lotto lotto, Lotto winningNumber) {
    int sameNumber = lotto.getNumbers().stream()
            .filter(target -> winningNumber.getNumbers().stream().anyMatch(Predicate.isEqual(target)))
            .collect(Collectors.toList())
            .size();
    return sameNumber;
  }

  // 로또 전체를 당첨 번호와 돌아가면서 비교하고 등수당 당첨 개수 구하는 메서드
  public Map<Ranking, Integer> compareAll(List<Lotto> lotteries, Lotto winningNumber, int bonusNumber) {
    initialWinningResult();
    for (Lotto lotto : lotteries) {
      int number = compare(lotto, winningNumber);
      if (number > 2) {
        Ranking ranking = valueOf(number, hasBonusNumber(lotto,bonusNumber));
        winningResult.put(ranking, winningResult.get(ranking) + 1);
      }
    }
    return winningResult;
  }
}
