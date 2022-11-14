package lotto.Domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Validator.LottoValidator;
import org.assertj.core.util.Sets;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        if (Sets.newHashSet(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR} 로또 번호는 모두 달라야 합니다.");
        }

        numbers.stream().forEach(s -> LottoValidator.checkLottoRange(s));
    }

    @Override
    public String toString() {
        ArrayList<Integer> temp = new ArrayList<>();

        for (int n : numbers) {
            temp.add(n);
        }
        Collections.sort(temp);

        return temp.toString();
    }

    public int size() {
        return numbers.size();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean isContain(int num) {
        if (numbers.contains(num)) {
            return true;
        }

        return false;
    }
}
