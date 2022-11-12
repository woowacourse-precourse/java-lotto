package lotto.model;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.model.LottoNumber.toLottoNumber;

public class UserLotto {
    private final String inputNumbers;
    private final LottoNumber bonus;

    public UserLotto(String inputNumbers, String bonus) {
        this.inputNumbers = inputNumbers;
        this.bonus = toLottoNumber(Integer.parseInt(bonus));
    }

    public boolean isDuplicate() {
        if (toLotto().getNumbers().contains(bonus)) {
            return true;
        }
        return false;
    }

    public Lotto toLotto() {
        return new Lotto(of(inputNumbers));
    }

    private List<Integer> of(String inputNumbers) {
        List<String> numbers = Arrays.asList(inputNumbers.split(","));
        return numbers.stream()
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
