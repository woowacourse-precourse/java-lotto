package lotto;

import java.util.List;

public class LottoMachine {
    private final List<Integer> normalNumber;
    private final int bonusNumber;

    public LottoMachine(List<Integer> normalNumber, int bonusNumber) {
        this.normalNumber = normalNumber;
        this.bonusNumber = bonusNumber;
    }

}
