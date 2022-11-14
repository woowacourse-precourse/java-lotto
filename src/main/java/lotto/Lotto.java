package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.isValidNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    public int getCountOfMatch(Lotto lotto) {
        List<Integer> matchNumber = new ArrayList<>(lotto.numbers);
        matchNumber.retainAll(this.numbers);

        return matchNumber.size();
    }
}
