package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.constant.BoundaryValue;
import lotto.domain.constant.LottoInfo;
import lotto.domain.model.Lotto;

public class LottoGenerator {
  public Lotto generate() {
    Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(BoundaryValue.LOTTO_MIN_NUMBER.getBoundaryValue(),
                                                            BoundaryValue.LOTTO_MAX_NUMBER.getBoundaryValue(),
                                                            LottoInfo.LOTTO_LENGTH.getValue()));
    return lotto;
  }
}