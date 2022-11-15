package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateOverlap(numbers);
        validateRangeOver(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 부족합니다.");
        }
    }
    
    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return numbers;
    }
    // 로또 넘버가 중복될 때 예외
    public void validateOverlap(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            System.out.println("[ERROR] 로또 번호가 중복되었습니다.");
            throw new IllegalArgumentException();
        }
    }
    // 로또 넘버가 1~45 범위에 해당되지 않을 때 예외.
    public void validateRangeOver(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

}
