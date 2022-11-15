package lotto.service;

import lotto.view.Output;

import java.util.List;

import static lotto.service.PickRandomLottoLists.randomLottoLists;

public class Lotto {
    private final List<Integer> numbers;
    PickRandomLottoLists pickRandomLotto = new PickRandomLottoLists();
    Output output = new Output();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkSameNumbers(numbers);
        this.numbers = numbers;
    }

    private void checkSameNumbers(List<Integer> numbers) {
        if(numbers.stream().distinct().count() == pickRandomLotto.LIMIT_LOTTO) {
            randomLottoLists.add(numbers);
        }

        if(numbers.stream().distinct().count() != pickRandomLotto.LIMIT_LOTTO) {
            throw new IllegalArgumentException(output.ERROR_ORDER+" 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(output.ERROR_ORDER+" 로또 개수는 6이어야 합니다.");
        }
    }
}