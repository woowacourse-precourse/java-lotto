package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoComparator {
    private final LottoTicket lottoTicket;
    private final WinningLotto winningLotto;
    private final BonusNumber bonusNumber;

    public LottoComparator(
            LottoTicket lottoTicket,
            WinningLotto winningLotto,
            BonusNumber bonusNumber
    ) {
        this.lottoTicket = lottoTicket;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public LottoTicketsResult compare() {
        List<LottoResult> results = lottoTicket.get().stream()
                .map(this::getLottoResult)
                .collect(Collectors.toList());
        return new LottoTicketsResult(results);
    }

    private LottoResult getLottoResult(Lotto lotto) {
        return LottoResult.of(getMatchCount(lotto), isMatchBonusNumber(lotto));
    }

    private int getMatchCount(Lotto lotto) {
        return winningLotto.getMatchCount(lotto.getNumbers());
    }

    private boolean isMatchBonusNumber(Lotto lotto) {
        return bonusNumber.isMatchBonusNumber(lotto.getNumbers());
    }
}
