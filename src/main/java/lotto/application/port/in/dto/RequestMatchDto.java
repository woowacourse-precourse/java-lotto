package lotto.application.port.in.dto;

import lotto.domain.lotto.Bonus;
import lotto.domain.lotto.Lotto;

public class RequestMatchDto {

    private Lotto winningLotto;
    private Bonus bonus;
    private ResponseBuyLottoDto lottoTickets;


    public RequestMatchDto(Lotto winningLotto, Bonus bonus, ResponseBuyLottoDto lottoTickets) {
        this.winningLotto = winningLotto;
        this.bonus = bonus;
        this.lottoTickets = lottoTickets;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public Bonus getBonus() {
        return bonus;
    }

    public ResponseBuyLottoDto getLottoTickets() {
        return lottoTickets;
    }
}
