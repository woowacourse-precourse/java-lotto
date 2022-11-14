package lotto.domain.impl;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.NumberGenerator;

import java.util.Collections;
import java.util.List;

public class NumberGeneratorImpl implements NumberGenerator {

    @Override
    public List<Integer> createRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }
}
