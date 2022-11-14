package lotto.view.input;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    List<Lotto> lottos = new ArrayList<>();

    public List<Integer> generateLotto(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Lotto> generateLottos(int size) {
        for (int i = 0; i < size; i++) {
            Lotto lotto = new Lotto(generateLotto());
            lottos.add(lotto);
        }
        return lottos;
    }
}
