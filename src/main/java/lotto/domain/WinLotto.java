package lotto.domain;

import lotto.validate.WinLottoValidate;

import java.util.ArrayList;
import java.util.List;

public class WinLotto extends Lotto{

    private final int bonusNumber;

    public WinLotto(List<Integer> numbers, int bonus) {
        super(numbers);
        validate(numbers, bonus);
        this.bonusNumber = bonus;
    }

    private void validate(List<Integer> numbers, int bonus) {
        new WinLottoValidate().validate(numbers, bonus);
    }

    public boolean contains(Lotto other) {
        return other.contains(bonusNumber);
    }


}
