package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.CONSTANTS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private List<Lotto> generatedLotto;

    public LottoGenerator() {
        this.generatedLotto = new ArrayList<>();
    }

    public List<Lotto> generateLotto(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(generateRandomNumbers());
            Collections.sort(lotto.getLotto());
            generatedLotto.add(lotto);
        }
        return generatedLotto;
    }

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(CONSTANTS.MINIMUM.getNumbers(), CONSTANTS.MAXIMUM.getNumbers(), CONSTANTS.LOTTO_COUNT.getNumbers());
    }
}
