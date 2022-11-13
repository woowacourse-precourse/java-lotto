package lotto.domain;

public class LottoMachine {
    private Lotto winningNumbers;
    private LottoNumber bonusNumber;

    public LottoMachine(Lotto winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
    
    public LottoResult check(LottoTicket lottoTicket) {
        return lottoTicket.check(winningNumbers, bonusNumber);
    }
}
