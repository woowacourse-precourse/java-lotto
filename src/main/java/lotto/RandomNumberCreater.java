package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomNumberCreater {
  Money money = new Money();
  UserNumberScan scanner = new UserNumberScan();
  public Map<Integer, List<Integer>> generateLottoNumber() {
    int count = money.countLotto(scanner.requestMoney());

    Map<Integer, List<Integer>> lottoMap = new HashMap<>();
    for (int i = 0; i < count; i++)
    {
      List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
      new Lotto(lottoNumbers); // validate 검사
      lottoMap.put(i, lottoNumbers);
    }
    return lottoMap;
  }
}
