package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.Lotto.*;

public class LottoGenerator {
  public static List<Lotto> getRandomLottoListByCount(int count) {
    List<Lotto> lottoList = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      lottoList.add(getRandomLotto());
    }
    return lottoList;
  }

  private static Lotto getRandomLotto() {
    List<Integer> lottoNumbers = pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT);
    return new Lotto(lottoNumbers);
  }
}
