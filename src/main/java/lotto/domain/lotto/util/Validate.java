package lotto.domain.lotto.util;

import lotto.domain.lotto.LottoNumber;

import java.util.HashSet;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Validate {
    private static final String WARM = "[ERROR] ";
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 45;
    private static final String WARM_INPUT_NUMBER_RANGE = WARM + START_RANGE + "~" + END_RANGE + " 사이의 수를 입력해 주세요";
    private static final String WARM_NOT_ALLOW_OVERLAP_NUMBER = WARM + "중복된 수가 입력되었습니다.";


    public static void validateSize(List<LottoNumber> lottoNumbers, String msg, Predicate<List<LottoNumber>> p) {
        if (p.test(lottoNumbers)) {
            System.out.println(msg);
            throw new IllegalArgumentException(msg);
        }
    }

    public static <T> void validateDuplicateNumber(List<T> compareNumbers, BiPredicate<Integer, List<T>> p) {
        HashSet<T> base = new HashSet<>(compareNumbers);

        if (p.test(base.size(), compareNumbers)) {
            System.out.println(WARM_NOT_ALLOW_OVERLAP_NUMBER);
            throw new IllegalArgumentException(WARM_NOT_ALLOW_OVERLAP_NUMBER);
        }
    }

    public static void validateLottoNumberRange(int lottoNumber) {
        if (lottoNumber < START_RANGE || END_RANGE < lottoNumber) {
            System.out.println(WARM_INPUT_NUMBER_RANGE);
            throw new IllegalArgumentException(WARM_INPUT_NUMBER_RANGE);
        }
    }
}

