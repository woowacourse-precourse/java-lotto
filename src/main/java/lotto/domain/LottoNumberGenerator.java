package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LottoNumberGenerator {
    public List<Integer> generate() {
        return (Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public List<Integer> sortAscending(List<Integer> numbers) {
        int[] numberList = new int[numbers.size()];
        for (int index = 0; index < numbers.size(); index++) {
            numberList[index] = numbers.get(index);
        }
        Arrays.sort(numberList);

        List<Integer> sortedNumbers = new ArrayList<>();
        for (int number : numberList) {
            sortedNumbers.add(number);
        }
        numbers = sortedNumbers;
        return numbers;
    }

}
