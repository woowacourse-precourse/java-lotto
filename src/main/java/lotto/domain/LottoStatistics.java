package lotto.domain;

import lotto.model.Lotto;
import lotto.model.LottoBuyer;
import lotto.model.LottoResults;
import lotto.model.LottoWinningNumber;

import java.util.List;

public class LottoStatistics {
    public void getLottoStatistics(LottoBuyer lottoBuyer, LottoWinningNumber lottoWinningNumber) {
        List<Lotto> lottoTickets = lottoBuyer.getLottoTickets();
        LottoResults lottoResults = lottoBuyer.getLottoResults();

        for (Lotto lotto : lottoTickets) {
            List<Integer> lottoNumbers = lotto.getLotto();
            int lottoCount = countLottoNumber(lottoNumbers, lottoWinningNumber.getLottoWinningNumbers());
            boolean isBonus = checkIsBonus(lottoNumbers, lottoWinningNumber.getBonusNumber());
            lottoResults.addLottoCount(lottoCount, isBonus);
        }
    }


    private int countLottoNumber(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        return (int) winningNumbers.stream()
                .filter(s -> lottoNumbers.contains(s))
                .count();
    }

    private boolean checkIsBonus(List<Integer> lottoNumbers, int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }
}