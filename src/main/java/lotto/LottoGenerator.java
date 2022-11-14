package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public List<Integer> createLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }

    public Lotto[] buyLottos(int quantity) {
        Lotto[] lottos = new Lotto[quantity];
        for(int i=0;i<quantity;i++){
            lottos[i]= new Lotto(createLottoNumbers());
        }
        return lottos;
    }
}
