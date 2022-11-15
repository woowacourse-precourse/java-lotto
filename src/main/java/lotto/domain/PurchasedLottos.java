package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.CommonValue;

import java.util.ArrayList;
import java.util.List;

public class PurchasedLottos {

    private final List<Lotto> lottos=new ArrayList<>();

    public PurchasedLottos(int payment){
        for(int i=0; i<payment / CommonValue.LOTTO_PRICE; i++){
            this.lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(CommonValue.MIN_LOTTO_NUMBER, CommonValue.MAX_LOTTO_NUMBER, 6)));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
