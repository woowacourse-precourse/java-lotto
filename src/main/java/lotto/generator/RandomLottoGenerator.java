package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.global.LottoConstants.*;

public class RandomLottoGenerator {

    public static Lotto makeLotto() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < 6) {
            int randomNumber = Randoms.pickNumberInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }

        return new Lotto(numbers);
    }
}
