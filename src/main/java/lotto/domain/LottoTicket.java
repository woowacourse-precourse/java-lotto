package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import lotto.dto.LottoNumbersDTO;
import lotto.dto.RoundResult;

public class LottoTicket {
    private final List<Lotto> lottoTicket;

    public LottoTicket(List<Lotto> lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public List<LottoNumbersDTO> exportLottoNumbers() {
        List<LottoNumbersDTO> exportedNumbers = lottoTicket.stream()
                .map(Lotto::export)
                .collect(Collectors.toList());
        return Collections.unmodifiableList(exportedNumbers);
    }

    public RoundResult getResult(WinningLotto winningLotto) {
        List<Prize> prizes = lottoTicket.stream()
                .map(winningLotto::getPrize)
                .collect(Collectors.toList());
        double rateOrReturn = getRateOfReturn(prizes);
        return new RoundResult(prizes, rateOrReturn);
    }

    public double getRateOfReturn(List<Prize> prizes) {
        return prizes.stream()
                .mapToDouble(prize -> prize.getWinnings().doubleValue() / (double) 1000)
                .average()
                .orElse(Money.NONE.doubleValue());
    }
}
