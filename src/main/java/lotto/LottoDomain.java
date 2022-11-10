package lotto;

import lotto.domain.Amount;
import lotto.domain.LottoGenerator;
import lotto.domain.Rank;

import java.util.List;

public class LottoDomain {
    public Amount amount;
    public LottoGenerator lottoGenerator;
    public Rank rank;

    public void setInputAmount(int inputAmount) {
        this.amount = new Amount(inputAmount);
        this.lottoGenerator = new LottoGenerator(amount.getPurchasesQuantity());
    }

    public void setInputWinningNumbers(List<Integer> numbers) {
        rank = new Rank(numbers);
    }

    public void setInputBonusNumber(int bonusNumber) {
        rank.countWinningRanks(lottoGenerator.getUserLottoTickets(), bonusNumber);
    }

    public void getEarningRates() {
        amount.getEarningRate(rank.winningRanks);
    }

}
