package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberGenerator {

    private static final int LENGTH_OF_LOTTO_NUMBERS = 6;

    public List<Integer> numbers() {
        var numbers = this.nonDuplicatedRandomNumbersOf();
        var sorted = this.sortedNumbersAscending(numbers);

        return sorted;
    }

    private int randomNumber() {
        return Randoms.pickNumberInRange(1, 45);
    }

    private List<Integer> nonDuplicatedRandomNumbersOf() {
        List<Integer> numbers = new ArrayList<Integer>();

        while (numbers.size() < LENGTH_OF_LOTTO_NUMBERS) {
            int newNumber = this.randomNumber();

            if (!numbers.contains(newNumber)) {
                numbers.add(newNumber);
            }
        }

        return numbers;
    }

    private List<Integer> sortedNumbersAscending(List<Integer> numbers) {
        return numbers.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
    }
}
