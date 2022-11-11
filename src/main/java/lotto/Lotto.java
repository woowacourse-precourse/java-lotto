package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        HashSet<Integer> deleteSameThing = new HashSet<>(numbers);
        numbers = new ArrayList<>(deleteSameThing);
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public String getLottoText()
    {
        Collections.sort(numbers);
        return Arrays.toString(numbers.toArray(new Integer[numbers.size()]));
    }
    // TODO: 추가 기능 구현
}
