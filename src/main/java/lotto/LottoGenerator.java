package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator {
    public static Lotto generateRandomly() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER,
                Lotto.LOTTO_SIZE);
        return new Lotto(randomNumbers);
    }

    public static Lotto generateByNumberList(List<Integer> numbers) {
        return new Lotto(numbers);
    }
}
