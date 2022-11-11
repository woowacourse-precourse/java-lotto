package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos=new ArrayList<>();

    public Lottos(int set){
       initLottos(set);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
    public void initLottos(int set){
        for(int i=0;i<set;i++){
            Lotto lotto=new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6));
            lotto.rangeLottoNumbers();
            lottos.add(lotto);
        }
    }
}
