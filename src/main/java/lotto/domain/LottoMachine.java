package lotto.domain;

import java.util.List;

public class LottoMachine extends Lotto{

    private int bonusNumber;

    public LottoMachine(List<Integer> numbers) {
        super(numbers);
    }
}
