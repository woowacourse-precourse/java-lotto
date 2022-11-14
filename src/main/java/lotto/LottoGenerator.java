package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.lang.reflect.Array;
import java.util.List;

public class LottoGenerator {
    public List<Integer> createLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }

    public List[] buyLottos(int quantity) {
        List[] lottos = new List[quantity];
        for(int i=0;i<quantity;i++){
            lottos[i]=createLottoNumbers();
        }
        return lottos;
    }
}
