package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserLottos {

     private final List<Lotto> userLottos;

     public UserLottos(Money money){
         int amount = money.getMoney() / 1000;
         this.userLottos = CreateBuyLottos(amount);
     }

     public List<Lotto> CreateBuyLottos(int amount){
         List<Lotto> buyLottos = new ArrayList<>();
         for (int i = 0; i < amount; i++) {
             List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
             buyLottos.add(new Lotto(numbers));
         }
         return buyLottos;
     }

     public List<Lotto> getUserLottos(){
         return this.userLottos;
    }
}
