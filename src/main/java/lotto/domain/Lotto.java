package lotto.domain;

import java.util.List;

public class Lotto {

    private static final String ERROR_CODE = "[ERROR] ";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if(numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_CODE + "당첨 번호는 6개만 입력해야 합니다.");
        }
        if(numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException(ERROR_CODE + "로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if(numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(ERROR_CODE + "입력된 당첨 번호 중에 중복되는 번호가 존재 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void printNumbers() {
        System.out.println(numbers);
    }

}
