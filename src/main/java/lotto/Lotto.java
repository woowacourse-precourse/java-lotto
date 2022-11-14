package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import lotto.message.ErrorMessage;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_SIZE.getErrorMessage());
        }
        if (new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_OVERLAP.getErrorMessage());
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public static Lotto issueLottoTicket() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public static Lotto drawLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }
}
