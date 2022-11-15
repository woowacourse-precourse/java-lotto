package domain;

import java.util.*;

public class Lotto {
    public final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    public int countMatch(List<Integer> winningNum) {
        return (int) numbers.stream().filter(winningNum::contains).count();
    }


    public boolean matchBonus(int bonusNum) {
        if ( numbers.contains(bonusNum)) {
            return true;
        }
        return false;
    }


    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
