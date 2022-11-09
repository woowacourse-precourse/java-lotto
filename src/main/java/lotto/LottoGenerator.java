package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoGenerator {

    static final int LOTTO_MAX_LEN = 8;

    public List<Integer> createRandomLotto() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < LOTTO_MAX_LEN) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);
            addNum(numbers, randomNumber);
        }

        sortByNaturalOrder(numbers);
        return numbers;
    }

    private void sortByNaturalOrder(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
    }

    private void addNum(List<Integer> numbers, int randomNumber) {
        if (!numbers.contains(randomNumber)) {
            numbers.add(randomNumber);
        }
    }
}
