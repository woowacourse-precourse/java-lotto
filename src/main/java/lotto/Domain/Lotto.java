package lotto.Domain;

import java.util.Collections;
import java.util.List;

public class Lotto extends LottoShop {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);

        Collections.sort(numbers);
        this.numbers = numbers;

        soldLottoList.add(numbers);
    }

    private void validate(List<Integer> numbers) {
        inspection.validateLottoNumberList(numbers);
    }
}
