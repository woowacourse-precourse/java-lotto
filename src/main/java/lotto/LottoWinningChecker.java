package lotto;

import lotto.enums.EtcNumber;
import lotto.enums.RankCount;
import lotto.enums.RankMoney;
import lotto.enums.RankPrize;

import java.util.List;

public class LottoWinningChecker {
    private int prizeMoney;
    private int numberCount = EtcNumber.ZERO.getNumber();
    private int bonusCount = EtcNumber.ZERO.getNumber();
    private int rank;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    LottoWinningChecker(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        countNumbers(lotto);
        setPrizeMoney();
        setRank();
    }

    public int checkCountNumbers(Lotto lotto, List<Integer> winningNumbers) {
        int numberCount = EtcNumber.ZERO.getNumber();
        List<Integer> lottoNumbers = lotto.getLottoNumbers();

        for (int index = EtcNumber.ZERO.getNumber(); index < EtcNumber.LOTTO_SIZE.getNumber(); index++) {
            if (winningNumbers.contains(lottoNumbers.get(index))) {
                numberCount++;
            }
        }

        return numberCount;
    }

    public int checkBonusNumbers(Lotto lotto, int bonusNumber) {
        int bonusCount = EtcNumber.ZERO.getNumber();
        List<Integer> lottoNumbers = lotto.getLottoNumbers();

        if (lottoNumbers.contains(bonusNumber)) {
            bonusCount++;
        }
        return bonusCount;
    }

    public void countNumbers(Lotto lotto) {
        numberCount = checkCountNumbers(lotto, winningNumbers);
        bonusCount = checkBonusNumbers(lotto, bonusNumber);
    }

    public void setPrizeMoney() {

        if (numberCount == RankCount.FIRST_PRIZE_COUNT.getNumberCount()) {
            prizeMoney = RankMoney.FIRST_PRIZE_MONEY.getPrizeMoney();
        }

        if (numberCount == RankCount.SECOND_PRIZE_COUNT.getNumberCount() && bonusCount == RankCount.SECOND_PRIZE_BONUS.getNumberCount()) {
            prizeMoney = RankMoney.SECOND_PRIZE_MONEY.getPrizeMoney();
        }

        if (numberCount == RankCount.THIRD_PRIZE_COUNT.getNumberCount() && bonusCount == EtcNumber.ZERO.getNumber()) {
            prizeMoney = RankMoney.THIRD_PRIZE_MONEY.getPrizeMoney();
        }

        if (numberCount == RankCount.FOURTH_PRIZE_COUNT.getNumberCount()) {
            prizeMoney = RankMoney.FOURTH_PRIZE_MONEY.getPrizeMoney();
        }

        if (numberCount == RankCount.FIFTH_PRIZE_COUNT.getNumberCount()) {
            prizeMoney = RankMoney.FIFTH_PRIZE_MONEY.getPrizeMoney();
        }
    }

    public int getRank() {
        return rank;
    }

    public void setRank() {

        if (numberCount == RankCount.FIRST_PRIZE_COUNT.getNumberCount()) {
            rank = RankPrize.FIRST_PRIZE.getRank();
        }

        if (numberCount == RankCount.SECOND_PRIZE_COUNT.getNumberCount() && bonusCount == RankCount.SECOND_PRIZE_BONUS.getNumberCount()) {
            rank = RankPrize.SECOND_PRIZE.getRank();
        }

        if (numberCount == RankCount.THIRD_PRIZE_COUNT.getNumberCount() && bonusCount == EtcNumber.ZERO.getNumber()) {
            rank = RankPrize.THIRD_PRIZE.getRank();
        }

        if (numberCount == RankCount.FOURTH_PRIZE_COUNT.getNumberCount()) {
            rank = RankPrize.FOURTH_PRIZE.getRank();
        }

        if (numberCount == RankCount.FIFTH_PRIZE_COUNT.getNumberCount()) {
            rank = RankPrize.FIFTH_PRIZE.getRank();
        }
    }

    public int getProfit() {
        return prizeMoney;
    }
}
