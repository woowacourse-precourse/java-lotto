package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Winning {
    private final LottoTicket lottoTicket;
    private final WinningNumber winningNumber;
    private final Map<LottoRank, Integer> lottoResult = new HashMap<>();

    public Winning(LottoTicket lottoTicket, WinningNumber winningNumber) {
        this.lottoTicket = lottoTicket;
        this.winningNumber = winningNumber;
    }

    public void checkWinningResult() {
        for (int i = 0; i < lottoTicket.getTicketCount(); i++) {
            Lotto lotto = lottoTicket.getTicket().get(i);
            int matchCount = checkWinningNumber(lotto);
            int bonusCount = checkBonusNumber(lotto);
            updateLottoResult(LottoRank.getLottoRank(matchCount, bonusCount));
        }
    }

    public int checkWinningNumber(Lotto lotto) {
        int matchCount = 0;

        for (int i = 0; i < winningNumber.getWinningNumbers().size(); i++) {
            int winningNum = winningNumber.getWinningNumbers().get(i);
            if (lotto.getNumbers().contains(winningNum)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public int checkBonusNumber(Lotto lotto) {
        int bonusCount = 0;

        if (lotto.getNumbers().contains(winningNumber.getBonusNumber())) {
            bonusCount++;
        }
        return bonusCount;
    }

    public void updateLottoResult(final LottoRank lottoRank) {
        lottoResult.put(lottoRank, lottoResult.get(lottoRank) + 1);
    }

    public Map<LottoRank, Integer> getLottoResult() {
        return lottoResult;
    }
}
