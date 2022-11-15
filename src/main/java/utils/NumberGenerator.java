package utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class NumberGenerator {

    private static final int FROM_INDEX = 1;
    private static final int END_INDEX = 45;
    private static final int PICKING_NUMBER = 6;

    public static List<Integer> generateSixRandomNumber() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(FROM_INDEX, END_INDEX, PICKING_NUMBER);
        return lottoNumbers;
    }
    public static List<LottoNumber> generate(final List<Integer> lottoNums) {
        return lottoNums.stream()
                .map(LottoNumber::getInstance)
                .sorted()
                .collect(Collectors.toList());
    }
}
