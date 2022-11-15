package lotto.domain;

import lotto.Lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchNumbers {
  private final Map<Integer, Integer> maps;

  public MatchNumbers() {
    this.maps = new HashMap<>();
  }

  public void matchCount(List<Integer> lottoNumber, List<Integer> winningNumber, int bonus) {
    int count = 0;
    for (Integer integer : winningNumber) {
      if (lottoNumber.contains(integer)) {
        count++;
      }
    }
    if (count == 5 && lottoNumber.contains(bonus)) {
      count = 7;
    }
    maps.put(count, maps.getOrDefault(count, 0) + 1);
  }

  public void resultOfMatchValue(List<Lotto> countLotto, List<Integer> winningNumber, int validBonusNumber) {
    for (int j = 0; j < Money.count; j++) {
      Lotto lotto = countLotto.get(j);
      List<Integer> lottoNumbers = lotto.getNumbers();
      matchCount(lottoNumbers, winningNumber, validBonusNumber);
    }
  }

  public Map<Integer, Integer> getMaps() {
    return maps;
  }
}
