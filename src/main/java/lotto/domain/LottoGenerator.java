package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoGenerator {
    private static final int LENGTH_OF_LOTTO_NUM = 6;

    public static List<Lotto> generateLottos(int numberOfLotto) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> randomNumbers = generateRandomNumbers();
            lottos.add(new Lotto(randomNumbers));
        }
        return lottos;
    }

    public static List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
