package lotto;

import org.assertj.core.util.Sets;

import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR]");
        }
        Set<Integer> set= Sets.newHashSet(numbers);
        if(set.size()!=6){
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
