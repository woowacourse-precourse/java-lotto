package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private static final int LENGTH_OF_LOTTO_NUM = 6;
    private static final int LOWER_LIMIT_OF_LOTTO_NUM = 1;
    private static final int UPPER_LIMIT_OF_LOTTO_NUM = 45;


    public static List<Lotto> generateLottos(int numberOfLotto) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> randomNumbers = generateRandomNumbers();
            lottos.add(new Lotto(randomNumbers));
        }
        return lottos;
    }

    public static List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOWER_LIMIT_OF_LOTTO_NUM, UPPER_LIMIT_OF_LOTTO_NUM,
                LENGTH_OF_LOTTO_NUM);
    }
}
