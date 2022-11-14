package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public List<Integer> createLottoNumbers(){
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        return numbers;
    }

    public Lotto[] buyLottos(int quantity) {
        Lotto[] lottos = new Lotto[quantity];
        for(int i=0;i<quantity;i++){
            lottos[i]= new Lotto(createLottoNumbers());
        }
        return lottos;
    }
}
