package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.LOTTO_CONSTANTS;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private List<Lotto> generatedLotto;

    public LottoGenerator() {
        this.generatedLotto = new ArrayList<>();
    }

    public List<Lotto> generateLotto(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(generateRandomNumbers());
            generatedLotto.add(lotto);
        }
        return generatedLotto;
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_CONSTANTS.MINIMUM.getNumbers(), LOTTO_CONSTANTS.MAXIMUM.getNumbers(), LOTTO_CONSTANTS.LOTTO_COUNT.getNumbers());
        return randomNumbers;
    }
}
