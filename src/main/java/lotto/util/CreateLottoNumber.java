package lotto.util;

import static lotto.constant.Constant.LOTTO_SIZE;
import static lotto.constant.Constant.MAX_LOTTO_NUMBER;
import static lotto.constant.Constant.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreateLottoNumber {

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
