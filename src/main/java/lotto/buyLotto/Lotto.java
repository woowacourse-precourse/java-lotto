package lotto.buyLotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        sortNumbers();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6자리 입니다.");
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("로또번호에 중복 번호가 있습니다.");
        }
    }

    public void printLottoNumbers() {
        System.out.println(numbers);
    }

    public void sortNumbers() {
        Collections.sort(numbers);
    }

    public int compareNumbers(int[] prizeNumbers) {
        int count = 0;
        for (int n : prizeNumbers) {
            count += Collections.frequency(numbers, n);
        }

        return count;
    }
}
