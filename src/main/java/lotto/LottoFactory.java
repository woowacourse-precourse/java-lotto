package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.LottoConstants.*;

public class LottoFactory {
    public Lotto createLotto() {
        List<Integer> lottoNumbers = createLottoNumbers();
        return new Lotto(lottoNumbers);
    }

    // overload
    public Lotto createLotto(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    private List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER.getValue(), LOTTO_END_NUMBER.getValue(), LOTTO_NUMBER_COUNT.getValue());
    }

    public List<Lotto> createLottos(int quantity) {
        List<Lotto> lottos = new ArrayList<>();

        while (lottos.size() < quantity) {
            Lotto lotto = createLotto();
            lottos.add(lotto);
        }
        return lottos;
    }
}
