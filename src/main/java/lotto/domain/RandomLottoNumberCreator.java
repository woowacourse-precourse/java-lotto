package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.LottoValidationUtils.*;

public class RandomLottoNumberCreator {

    public static final int CRITERION_ZERO = 0;

    public static List<Integer> createLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER, CRITERION_LOTTO_SIZE);
    }

    public static List<List<Integer>> createLottoNumber(int count) {
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        while (count --> CRITERION_ZERO) {
            lottoNumbers.add(createLottoNumber());
        }
        return lottoNumbers;
    }
}
