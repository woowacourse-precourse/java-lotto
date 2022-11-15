package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.validator.LottoValidator;
import org.assertj.core.util.Sets;

public class Lotto {
    public static final String BE_SIX_IN_TOTAL = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String ALL_BE_DIFFERENT = "[ERROR} 로또 번호는 모두 달라야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(BE_SIX_IN_TOTAL);
        }

        if (Sets.newHashSet(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(ALL_BE_DIFFERENT);
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
