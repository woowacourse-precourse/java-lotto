package lotto.utill;

import lotto.Messages.Message;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 로또 한장
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Message.NotEnoughNumber);
        }

        Set<Integer> setNumber = new HashSet<>(numbers);
        if(setNumber.size() != numbers.size()) {
            throw new IllegalArgumentException(Message.HaveSameNumber);
        }

        numbers.forEach(num -> {
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException(Message.NotInRange);
            }
        });
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
