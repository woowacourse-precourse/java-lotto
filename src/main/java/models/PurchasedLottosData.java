package models;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

    public class PurchasedLottosData {

    private List<Lotto> purchasedLottos;

    public PurchasedLottosData(int amount){
        purchasedLottos = createLottos(amount);
    }

    private List<Lotto> createLottos(int amount){

        List<Lotto> lottos = new ArrayList<>();

        for(;lottos.size() < amount;){
            lottos.add(createLottoNumbers());
        }
        return lottos;

    }

    private Lotto createLottoNumbers(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = new Lotto(numbers);
        return lotto;

    }

     public void printLottoList(){
         System.out.println(String.format("%d개를 구매했습니다.",purchasedLottos.size()));
         purchasedLottos.forEach((lotto) -> System.out.println(Arrays.asList(lotto.getNumbers())));
     }

}
