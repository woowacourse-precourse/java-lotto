package lotto.service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.LottoWinningNumber;
import lotto.domain.Rank;

public class LottoDrawService {

    public static Map<Rank, Integer> drawLotto(LottoTicket lottoTicket, LottoWinningNumber lottoWinningNumber) {
        Map<Rank, Integer> lottoResult = initLotto();
        int winningNumberAmount;
        boolean hasBonusNumber;
        for (Lotto lotto : lottoTicket.getLottoTicket()) {
            winningNumberAmount = getWinningNumberAmount(lotto, lottoWinningNumber);
            hasBonusNumber = hasBonus(lotto, lottoWinningNumber.getBonusNumber());
            lottoResult.put(Rank.getRank(winningNumberAmount, hasBonusNumber),
                    lottoResult.get(Rank.getRank(winningNumberAmount, hasBonusNumber)) + 1);
        }
        return lottoResult;
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

    private static Map<Rank, Integer> initLotto() {
        Map<Rank, Integer> lottoResult = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            lottoResult.put(rank, 0);
        }
        return lottoResult;
    }

    private static boolean hasBonus(Lotto lotto, int bonusNumber) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        return lottoNumbers.contains(bonusNumber);
    }
}
