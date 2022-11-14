package lotto.view.input;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.util.Constants.*;

public class LottoCreator {
    public List<Integer> createLottoNumbersCandidate(){
        return Randoms.pickUniqueNumbersInRange(LOTTO_START_RANGE, LOTTO_END_RANGE, LOTTO_SIZE);
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
