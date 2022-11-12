package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinningNumber {
    public List<Integer> RandomLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return SortRandomLotto(numbers);
    }

    private List<Integer> SortRandomLotto(List<Integer> numbers) {
        List<Integer> sortNumber = new ArrayList<>();
        sortNumber.addAll(numbers);
        Collections.sort(sortNumber);
        return sortNumber;
    }
}