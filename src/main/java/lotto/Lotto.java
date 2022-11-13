package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers.sort(Comparator.naturalOrder());
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public static Lotto issueLottoTicket () {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public static Lotto drawLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }
}
