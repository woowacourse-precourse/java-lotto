package lotto.domain;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> lottoResult;

    LottoResult(LottoTicket lottoTicket, LottoWinningNumber lottoWinningNumber) {
        this.lottoResult = drawLotto(lottoTicket, lottoWinningNumber);
    }

    public Map<Rank, Integer> getLottoResult() {
        return this.lottoResult;
    }

    private static Map<Rank, Integer> drawLotto(LottoTicket lottoTicket, LottoWinningNumber lottoWinningNumber) {
        Map<Rank, Integer> lottoResult = new EnumMap<>(Rank.class);
        int winningNumberAmount;
        boolean hasBonusNumber;
        for (Lotto lotto : lottoTicket.getLottoTicket()) {
            winningNumberAmount = getWinningNumberAmount(lotto, lottoWinningNumber);
            hasBonusNumber = hasBonus(lotto, lottoWinningNumber.getBonusNumber());
            lottoResult.put(Rank.getRank(winningNumberAmount, hasBonusNumber),
                    lottoResult.getOrDefault(Rank.getRank(winningNumberAmount, hasBonusNumber), 0) + 1);
        }
        return lottoResult;
    }

    private static boolean hasBonus(Lotto lotto, int bonusNumber) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        return lottoNumbers.contains(bonusNumber);
    }

    private static int getWinningNumberAmount(Lotto lotto, LottoWinningNumber lottoWinningNumber) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> lottoWinningNumbers = lottoWinningNumber.getWinningNumbers();
        int winningNumberAmount = 0;
        for (int lottoNumber : lottoNumbers) {
            if (lottoWinningNumbers.contains(lottoNumber)) {
                winningNumberAmount++;
            }
        }
        return winningNumberAmount;
    }
}
