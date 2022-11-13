package lotto.domain;

import lotto.model.Lotto;
import lotto.model.LottoBuyer;
import lotto.model.LottoResults;
import lotto.model.LottoWinningNumber;

import java.util.List;

public class LottoStatistics {
    public void getLottoStatistics(LottoBuyer lottoBuyer, LottoWinningNumber lottoWinningNumber) {
        LottoResults lottoResults = lottoBuyer.getLottoResults();
        List<Lotto> lottoTickets = lottoBuyer.getLottoTickets();
        List<Integer> winningNumbers = lottoWinningNumber.getLottoWinningNumbers();
        int bonusNumber = lottoWinningNumber.getBonusNumber();

        for (Lotto lotto : lottoTickets) {
            List<Integer> lottoNumbers = lotto.getLotto();
            int lottoCount = countLottoNumber(lottoNumbers, winningNumbers);
            boolean isBonus = checkIsBonus(lottoNumbers, bonusNumber);
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