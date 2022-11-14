package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private List<Integer> sort() {
        List<Integer> result = new ArrayList<>(this.numbers);

        Collections.sort(result, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 < o2)
                    return -1;
                else if (o1 > o2)
                    return 1;
                return 0;
            }
        });

        return result;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        String result = "";
        result += sort().toString();
        return result;
    }

    public int countSameNumber(Lotto winningLotto, int bonusNumber) {
        int result = 0;
        List<Integer> winningNumbers = winningLotto.getNumbers();

        for (int number : numbers) {
            if (winningNumbers.contains(number))
                result++;
        }

        if (result == 5 && numbers.contains(bonusNumber))
            result += 2;

        return result;
    }
}
