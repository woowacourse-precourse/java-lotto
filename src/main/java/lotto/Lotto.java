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
    public int compareWithAnswer(List<Integer> winNumbers, int bonusNumber) {
        int correctCount = 0;
        for (int winNumber : winNumbers) {
            if (numbers.contains(winNumber)) {
                correctCount++;
            }
        }

        //이걸 대체 어떻게 줄이지?
        if (correctCount < 3) {
            return 0;
        }
        if (correctCount == 3) {
            return 5;
        }
        if (correctCount == 4) {
            return 4;
        }
        if (correctCount == 5) {
            if (numbers.contains(bonusNumber)) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
