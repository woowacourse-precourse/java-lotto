package lotto.domain;

import static lotto.constant.LottoGameRule.LOTTO_MAX_NUMBER;
import static lotto.constant.LottoGameRule.LOTTO_MIN_NUMBER;
import static lotto.constant.LottoGameRule.LOTTO_NUMBER_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public static List<Lotto> generateLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(LottoGenerator.pickRandomNumber());
        }
        return lottos;
    }

    public static Lotto pickRandomNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER,
                LOTTO_NUMBER_SIZE);
        return new Lotto(numbers);
    }
}
