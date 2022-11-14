package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private static final int LOTTO_SIZE = 6;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;

    public static List<Lotto> getAllLotto(final int quantity) {
        List<Lotto> allLotto = new ArrayList<>();
        while (allLotto.size() < quantity) {
            allLotto.add(generateLotto());
        }
        return allLotto;
    }

    private static Lotto generateLotto() {
        List<Integer> randomNumber
                = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, LOTTO_SIZE);
        return new Lotto(randomNumber);
    }
}
