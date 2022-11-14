package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        numberSize(numbers);
        checkNumberDuplicate(numbers);
        this.numbers = numbers;
    }

    public static void numberSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkNumberDuplicate(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.contains(numbers.get(i))) {
                throw new IllegalArgumentException(" 중복된 숫자는 잘못된 입력값 입니다.");
            }
        }
    }


    public List<Integer> getNumbers() {
        return numbers;
    }

}
