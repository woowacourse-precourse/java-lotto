package lotto.domain;

import lotto.domain.model.Lotto;
import lotto.domain.model.LottoNum;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {
  public List<Lotto> makeLottos(LottoNum lottoNum) {
    List<Lotto> lottos = new ArrayList<>();
    LottoGenerator generator = new LottoGenerator();
    for (int i = 0; i < lottoNum.getLottoNum(); i++) {
      lottos.add(generator.generate());
    }
    return lottos;
  }
}