package lotto;

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
    public void printLotto() {
        String lotto = "[";
        for (int i = 0; i < numbers.size(); i++) {
            lotto += Integer.toString(numbers.get(i));

            if (i < numbers.size()-1) {
                lotto += ", ";
            }
        }
        lotto += "]";

        System.out.println(lotto);
    }
}
