package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
  private static final int startInclusive = 1;
  private static final int endInclusive = 45;
  private static final int pickCount = 6;

  private final List<Lotto> lottos;

  LottoManager(int payment){
    lottos = new ArrayList<>();
    generateLotto(payment);
    showAllLotto();
  }

  private void generateLotto(int payment){
    while(payment-->0){
      List<Integer> numbers =
              Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, pickCount);
      Lotto lotto = new Lotto(numbers);

      lottos.add(lotto);
    }
  }

  private void showAllLotto(){
    for(Lotto lotto : lottos){
      System.out.println(lotto.getNumbers().toString());
    }
  }
}
