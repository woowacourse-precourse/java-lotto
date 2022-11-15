package lotto.model;

import static lotto.enums.Constant.*;
import lotto.enums.Ranking;

import java.util.List;

public class Player {
    private int purchaseAmount;
    private int lottoCount;
    private List<Lotto> lottoNumbers;
    private List<Integer> winningNumber;
    private int bonusNumber;
    private int totalPrize;

    public void setPurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchaseAmount() {
        return this.purchaseAmount;
    }

    public void setLottoCount(int lottoCount) {
        this.lottoCount = lottoCount;
    }

    public int getLottoCount() {
        return this.lottoCount;
    }

    public void setLottoNumbers(List<Lotto> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Lotto> getLottoNumbers() {
        return this.lottoNumbers;
    }

    public void setWinningNumber(List<Integer> winningNumber) {
        this.winningNumber = winningNumber;
    }

    public List<Integer> getWinningNumber() {
        return this.winningNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void registerWinningResult() {
        for (Lotto lottonumber : lottoNumbers) {
            int matchingNumbers = compareLottoAndWinningNumber(lottonumber);
            Ranking lottoResult = Ranking.getRankByMatchingNumbers(matchingNumbers);
            lottoResult.plusWinningResult();
        }
    }

    private int compareLottoAndWinningNumber(Lotto lotto) {
        int matchingNumbers = 0;

        for (int number : this.winningNumber) {
            if (lotto.getNumbers().contains(number)) {
                matchingNumbers++;
            }
        }
        if (lotto.getNumbers().contains(this.bonusNumber)) {
            matchingNumbers += MATCHING_BONUS_NUMBER.getValue();
        }

        return matchingNumbers;
    }

    public void registerTotalPrize() {
        this.totalPrize = 0;
        for (Ranking rank : Ranking.values()) {
            totalPrize += rank.getPrize() * rank.getWinningResult();
        }
    }
}
