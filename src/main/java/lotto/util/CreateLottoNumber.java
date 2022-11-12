package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreateLottoNumber {
    public List<Integer> createLottoNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    private List<Integer> sortLottoNumber(List<Integer> numbers) {
        List<Integer> sortNumbers = new ArrayList<>();
        sortNumbers.addAll(numbers);
        Collections.sort(sortNumbers);
        return sortNumbers;
    }
}
