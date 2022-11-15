package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NumberAutoMachine {

    private final int minNum = 1;
    private final int maxNum = 45;
    private final int numSize = 6;

    // 중복되지 않는 6개의 숫자를 뽑기
    public List<Integer> pickNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(minNum, maxNum, numSize);
        return sortNumbers(numbers);

    }

    // 로또 번호 정렬
    private List<Integer> sortNumbers(List<Integer> number) {
        List<Integer> sortedNumbers = new ArrayList<>(number);
        sortedNumbers.sort(Comparator.naturalOrder());
        return sortedNumbers;
    }

}
