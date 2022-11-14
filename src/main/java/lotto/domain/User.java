package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.util.LottoUtils;

public class User {

    private List<Lotto> lottos;

    public void setLottos(int lottoAmount){
        lottos = new ArrayList<>();

        while (lottos.size()<lottoAmount){
            List<Integer> numbers = LottoUtils.pickUniqueNumbersInRange();
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
