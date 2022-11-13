package lotto.domain;

public class LottoMachine {
    private Lotto winningNumbers;
    private LottoNumber bonusNumber;

    public LottoMachine(Lotto winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
}
