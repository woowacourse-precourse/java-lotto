package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    private final List<Integer> numbers;
    private static final String REGEX="^[1-9]{1}$|^[1-3]{1}[0-9]{1}$|^4{1}[0-5]{1}$";

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        NotDuplicate(numbers);
        validateNumbers(numbers);
        this.numbers = numbers;
    }
}