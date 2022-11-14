package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreateLottoNumber {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    public List<Integer> createLottoNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE);

        return sortLottoNumber(numbers);
    }

    private List<Integer> sortLottoNumber(List<Integer> numbers) {
        List<Integer> sortNumbers = new ArrayList<>();
        sortNumbers.addAll(numbers);
        Collections.sort(sortNumbers);
        return sortNumbers;
    }
}
