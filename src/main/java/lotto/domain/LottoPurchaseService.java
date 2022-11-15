package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoPurchaseService {

  public List<Lotto> purchase(int money) {
    int lottoCount = payPrice(money);
    return generateLotto(lottoCount);
  }

  private int payPrice(int money) {
    if (money % 1000 != 0) {
      System.out.println("[ERROR] 돈 단위가 맞지 않습니다.");
      throw new IllegalArgumentException();
    }
    return money / 1000;
  }

  private List<Lotto> generateLotto(int count){
    List<Lotto> lottos = new ArrayList<>();
    for(int i = 0; i < count; i++){
      List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
      lottos.add(new Lotto(numbers));
    }
    return lottos;
  }
}
