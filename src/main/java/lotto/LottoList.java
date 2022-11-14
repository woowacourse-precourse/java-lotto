package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoList {
    private final List<Lotto> lottos = new ArrayList<>();
    private int amount;

    public LottoList() {
        this.amount = 0;
    }

    public void printLottoList(){
        System.out.println(amount+"개를 구매했습니다.");
        for(var lotto:lottos){
//            TODO: lotto.printLottoNumbers();
        }
    }

    public void generateLotto(){
//        TODO: List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

    }
}
