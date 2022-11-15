package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private static final int MAX_LENGTH = 6;

    private List<Integer> lottoNumbers = new ArrayList<>();

    public NumberGenerator() {
        lottoNumbers.addAll(Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, MAX_LENGTH));
    }

    public List<Integer> getNumbers() {
        return lottoNumbers;
    }
}
