package lotto.model.lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoGenerator {
    public Lotto autoGenerate() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(Lotto.MINIMUM_NUMBER, Lotto.MAXIMUM_NUMBER, Lotto.LOTTO_NUMBER_LENGTH));

        numbers.sort(Comparator.naturalOrder());
        return new Lotto(numbers);
    }
}
