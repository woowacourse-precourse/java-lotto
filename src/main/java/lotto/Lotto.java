package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public int matched = 0;
    public boolean is_second_winner = false;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public void get_matched(List<Integer> winning_numbers, int bonus_number) {
        for (int a : winning_numbers)
            for (int b : numbers)
                if (a == b) matched++;

        if (matched == 5)
            for (int a : numbers)
                if (a == bonus_number) {
                    matched++;
                    is_second_winner = true;
                }
    }


    private void validate(List<Integer> numbers) {
        HashSet<Integer> hash_numbers = new HashSet<>(numbers);
        if (numbers.size() != 6) throw new IllegalArgumentException();
        if (hash_numbers.size() != 6) throw new IllegalArgumentException();
    }
}
