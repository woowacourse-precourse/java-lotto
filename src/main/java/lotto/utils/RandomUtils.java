package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.status.NumberStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomUtils {

    public static Lotto createRandomUserLotto() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(NumberStatus.MIN_LOTTO_NUMBER.getNumber(),
                NumberStatus.MAX_LOTTO_NUMBER.getNumber(), NumberStatus.TOTAL_NUMBER_OF_LOTTO.getNumber()));
        Collections.sort(numbers);
        Lotto userLotto = new Lotto(numbers);
        return userLotto;
    }


}
