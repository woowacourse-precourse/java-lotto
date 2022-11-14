package lotto.domain.impl;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.NumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.Constants.*;

public class NumberGeneratorImpl implements NumberGenerator {

    @Override
    public List<Integer> createRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(NUMBER_MIN_RANGE, NUMBER_MAX_RANGE, LOTTO_NUMBERS_COUNT);
        Collections.sort(new ArrayList<>(numbers));
        return numbers;
    }
}
