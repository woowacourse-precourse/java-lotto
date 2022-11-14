package lotto.model;

import lotto.service.LottoService;
import lotto.view.OutputView;

import java.util.*;

import static lotto.service.LottoService.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Set<Integer> ordered = new TreeSet<>(numbers);
        this.numbers = new ArrayList<>(ordered);
    }

    private void validate(List<Integer> numbers) {
        try {
            Set<Integer> numberSet = makeNumberSet(numbers);
            if (numbers.size() != LOTTO_LENGTH || numberSet.size() != LOTTO_LENGTH) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            status = ERROR_STATUS;
            OutputView.printError(INVALID_LOTTO_NUMBER_ERROR);
        }
    }

    private Set<Integer> makeNumberSet(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>();
        for (Integer number : numbers) {
            if (!(number >= LOTTO_NUMBER_MIN && number <= LOTTO_NUMBER_MAX)) {
                throw new IllegalArgumentException();
            }
            numberSet.add(number);
        }
        return numberSet;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
