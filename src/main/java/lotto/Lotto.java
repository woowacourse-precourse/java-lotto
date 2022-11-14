package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        List<Integer> numbers_ = new ArrayList<>(numbers);
        Collections.sort(numbers_);
        validate(numbers_);
        checkDuplicate(numbers_);
        this.numbers = numbers_;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.");
        }
        for (int number : numbers) {
            if (number < 1 || number > 45)
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이다.");
        }
    }

    private void checkDuplicate(List<Integer> numbers) {
        for (int i = 0; i < 5; i++) {
            if (numbers.get(i) == numbers.get(i + 1))
                throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있으면 예외가 발생한다.");
        }
    }

    //발행한 로또와 당첨번호를 비교한다
    public Statistics compareLotto(List<Integer> winningNumber, int bonusNumber) {
        int matchingCount = 0;
        HashSet<Integer> winningSet = new HashSet<>(winningNumber);
        for (int number : numbers) {
            if (winningSet.contains(number))
                matchingCount++;
        }
        return Statistics.getRank(matchingCount, numbers.contains(bonusNumber));
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
