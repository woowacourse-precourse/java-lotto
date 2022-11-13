package lotto.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoFactory {
  public List<List<Integer>> makeLottos(int lottoNum) {
    List<List<Integer>> lottos = new ArrayList<>();
    LottoGenerator generator = new LottoGenerator();
    for (int i = 0; i < lottoNum; i++) {
      lottos.add(generator.generate());
      sortLotto(lottos.get(i));
    }
    return lottos;
  }

  private void sortLotto(List<Integer> lotto) {
    lotto.sort(Comparator.naturalOrder());
  }
}