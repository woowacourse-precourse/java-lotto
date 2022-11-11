package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchNumbers {
  private final Map<Integer, Integer> maps;

  public MatchNumbers() {
    this.maps = new HashMap<>();
  }

  public void match(List<Integer> lottoNumber, List<Integer> winningNumber) {
    int count = 0;
    for (Integer integer : winningNumber) {
      if (lottoNumber.contains(integer)) {
        count++;
      }
    }
    maps.put(count, maps.getOrDefault(count, 0) + 1);
  }

  public Map<Integer, Integer> getMaps() {
    return maps;
  }
}
