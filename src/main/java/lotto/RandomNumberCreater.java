package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberCreater {
  public static List<Lotto> generateLottoNumber(int count) {

    List<Lotto> lottoList = new ArrayList<>();
    for (int i = 0; i < count; i++)
    {
      List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
      Lotto lotto = new Lotto(lottoNumbers); // validate 검사
      lottoList.add(lotto);
    }
    return lottoList;
  }
}
