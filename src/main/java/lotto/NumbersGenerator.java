package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class NumbersGenerator {

    private final List<Integer> numbers;

    public NumbersGenerator() {
        numbers = new ArrayList<>();
    }

    private void addNotContainsNumber(int num) {
        if (!numbers.contains(num)) {
            numbers.add(num);
        }
    }

    private void generateLotto() {
        while (numbers.size() < 6) {
            int randomNum = Randoms.pickNumberInRange(1, 45);
            addNotContainsNumber(randomNum);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
