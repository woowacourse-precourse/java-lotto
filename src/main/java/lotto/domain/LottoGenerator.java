package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.constant.BoundaryValue;
import lotto.domain.constant.LottoInfo;

import java.util.List;

public class LottoGenerator {
  public List<Integer> generate() {
    return Randoms.pickUniqueNumbersInRange(BoundaryValue.LOTTO_MIN_NUMBER.getBoundaryValue(),
                                            BoundaryValue.LOTTO_MAX_NUMBER.getBoundaryValue(),
                                            LottoInfo.LOTTO_LENGTH.getValue());
  }
}