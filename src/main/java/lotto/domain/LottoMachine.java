package lotto.domain;

import java.util.List;

public class LottoMachine {
    private Lotto winningNumbers;
    private LottoNumber bonusNumber;

    public LottoMachine(List<Integer> winningNumbers, Integer bonusNumber) {
        this.winningNumbers = new Lotto(winningNumbers);
        this.bonusNumber = LottoNumber.valueOf(bonusNumber);
    }
}
