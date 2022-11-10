package domain;

import java.util.HashSet;
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
        HashSet<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException("중복된 숫자는 존재할 수 없습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int count(WinningNumber winningNumber) {
        int cnt = 0;
        for (Integer number : numbers) {
            if (winningNumber.containNumberSet(number)) {
                cnt++;
            }
        }
        return cnt;
    }

    public boolean compareBonusNumber(WinningNumber winningNumber) {
        for (Integer number : numbers) {
            if (winningNumber.equalBonusNumber(number)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < numbers.size()-1; ++i) {
            sb.append(numbers.get(i));
            sb.append(", ");
        }
        sb.append(numbers.get(numbers.size()-1));
        sb.append("]");
        return sb.toString();
    }
}
