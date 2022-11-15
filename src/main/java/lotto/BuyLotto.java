package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class BuyLotto {

  private final int LottoCount;
  static List<List<Integer>> Lottos;

  BuyLotto(){
    int money = Integer.parseInt(Console.readLine());
    if(money % 1000 != 0){
      throw new IllegalArgumentException();
    }
    this.LottoCount = money / 1000;
  }

  void generateLottos(){
    for(int i=0; i<LottoCount; i++){
      List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
      Lottos.add(numbers);
    }
  }
}
