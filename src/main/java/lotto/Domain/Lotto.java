package lotto.Domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto extends LottoShop {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortLottoList(numbers);

        soldLottoList.add(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        inspection.validateLottoNumberList(numbers);
    }

    private List<Integer> sortLottoList(List<Integer> numbers) {
        List<Integer> sortedList = new ArrayList<>(numbers);
        Collections.sort(sortedList);

        return sortedList;
    }
}
