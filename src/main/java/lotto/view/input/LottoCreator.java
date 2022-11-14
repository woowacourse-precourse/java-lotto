package lotto.view.input;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoCreator {
    public List<Integer> createLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Lotto> createLottos(int size) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Lotto lotto = new Lotto(createLottoNumbers());
            lottos.add(lotto);
        }
        return lottos;
    }
}
