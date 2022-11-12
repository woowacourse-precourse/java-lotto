package lotto.controller.request;

import lotto.domain.lotto.Lotto;
import lotto.domain.money.Money;
import lotto.domain.winningnumber.WinningNumber;

import java.util.List;

public class CalculateWinningRequest {

    private final Money principle;
    private final List<Lotto> lottos;
    private final WinningNumber winningNumber;

    public CalculateWinningRequest(Money principle, List<Lotto> lottos, WinningNumber winningNumber) {
        this.principle = principle;
        this.lottos = lottos;
        this.winningNumber = winningNumber;
    }

    public Money getPrinciple() {
        return principle;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public WinningNumber getWinningNumber() {
        return winningNumber;
    }
}
