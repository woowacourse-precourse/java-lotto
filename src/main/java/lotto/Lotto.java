package lotto;

import org.assertj.core.util.Sets;

import java.util.List;
import java.util.Set;
/*
설명 - 로또 객체
getNumbers() - 로또 번호 List return

 */
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
