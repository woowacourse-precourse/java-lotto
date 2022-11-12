package lotto;

import lotto.domain.Amount;
import lotto.domain.LottoGenerator;
import lotto.domain.Rank;
import lotto.entity.Place;

import java.util.List;
import java.util.Map;

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


    public int getPurchasesQuantity() {
        return amount.getPurchasesQuantity();
    }

    public List<List<Integer>> getUserLottoTickets() {
        return lottoGenerator.getUserLottoTickets();
    }

    public Map<Place, Integer> getWinningRanks() {
        return rank.winningRanks;
    }

    public double getEarningRates() {
        return amount.getEarningRate(rank.winningRanks);
    }

}
