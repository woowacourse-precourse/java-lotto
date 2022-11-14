package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBER_OF_LOTTO_NUMBERS = 6;

    public static List<Integer> generate() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_OF_LOTTO_NUMBERS);
        return lottoNumber.stream().sorted(Integer::compareTo).collect(Collectors.toList());
    }
}