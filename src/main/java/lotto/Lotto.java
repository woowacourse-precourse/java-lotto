package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 입력한 로또 번호의 개수가 6개가 아닙니다.");
        }
        if (Collections.min(numbers) < 1 || Collections.max(numbers) > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    public void showLotto() {
        List<Integer> numbersCopy = new ArrayList<Integer>(numbers);

        Collections.sort(numbersCopy);
        System.out.println(numbersCopy);
    }

    public List<Integer> get() {
        return numbers;
    }
}
