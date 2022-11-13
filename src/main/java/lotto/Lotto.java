package lotto;

import java.util.List;

public class Lotto {
    public List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {

//        Collections.sort(numbers); // 포함하면 오류남
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또는 숫자 6자리 입니다.");
        }
        for (int a : numbers) {
            if (a < 1 || a > 45) {
                throw new IllegalArgumentException("[ERROR] 로또는 1-45사이 숫자입니다");
            }
            if (numbers.size() != numbers.stream().distinct().count()) {
                throw new IllegalArgumentException("[ERROR] 로또 숫자는 중복되면 안됩니다.");
            }
        }

    }

}
