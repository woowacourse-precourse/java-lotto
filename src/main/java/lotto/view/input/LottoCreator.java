package lotto.view.input;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoCreator {
    public List<Integer> createLottoNumbersCandidate(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Lotto> createLottosCandidate(int size) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Lotto lotto = new Lotto(createLottoNumbersCandidate());
            lottos.add(lotto);
        }
        return lottos;
    }
}
