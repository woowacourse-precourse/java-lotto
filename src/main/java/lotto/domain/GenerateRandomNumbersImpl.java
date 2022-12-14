package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class GenerateRandomNumbersImpl implements GenerateNumbers {
    private static final int RANDOM_MIN_VALUE = 1;
    private static final int RANDOM_MAX_VALUE = 45;
    private static final int RANDOM_NUMBERS_SIZE = 6;

    @Override
    public List<Integer> generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(RANDOM_MIN_VALUE, RANDOM_MAX_VALUE, RANDOM_NUMBERS_SIZE);
        List<Integer> sortedLottoNumbers = numbers.stream().sorted().collect(Collectors.toList());
        return sortedLottoNumbers;
    }
}