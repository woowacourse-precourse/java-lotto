package lotto;

import java.util.ArrayList;
import java.util.Collections;
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

        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }

        if (numbers.stream().filter(integer -> integer < 1 || integer > 45).count() > 0) {
            throw new IllegalArgumentException();
        }
    }

    public void print() {
        StringBuilder sb = new StringBuilder("[");
        List<Integer> sortNumbers = new ArrayList<>(numbers);
        Collections.sort(sortNumbers);

        for (int i = 0; i < 5; i++) {
            sb.append(sortNumbers.get(i));
            sb.append(", ");
        }
        sb.append(sortNumbers.get(5));
        sb.append("]");

        System.out.println(sb);
    }

    public int countMatches(List<Integer> winNumbers) {
        int count = 0;

        for (int i = 0; i < 6; i++) {
            if (numbers.contains(winNumbers.get(i))) {
                count++;
            }
        }

        return count;
    }

    public boolean matchesBonus(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
