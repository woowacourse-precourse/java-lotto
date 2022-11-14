package lotto.calculate;

import lotto.grade.Grade;
import lotto.lottocontroller.BuyLotto;
import lotto.winningnumbers.WinningNumbers;

import java.util.List;

public class CountNumberOfWins {
    private int firstPlace;
    private int secondPlace;
    private int thirdPlace;
    private int fourthPlace;
    private int fifthPlace;
    private double sumOfPrize;
    private final BuyLotto buyLotto;
    private final WinningNumbers winningNumbers;

    public CountNumberOfWins(BuyLotto buyLotto, WinningNumbers winningNumbers) {
        this.firstPlace = 0;
        this.secondPlace = 0;
        this.thirdPlace = 0;
        this.fourthPlace = 0;
        this.fifthPlace = 0;
        this.sumOfPrize = 0;
        this.buyLotto = buyLotto;
        this.winningNumbers = winningNumbers;
    }

    private List<List<Integer>> setBuyLotto() {
        return buyLotto.issue();
    }

    private List<Integer> setWinningNumbers() {
        return winningNumbers.input();
    }

    private int setBonusNumber() {
        return winningNumbers.inputBonusNumber();
    }

    private void numberOfWins(int ranking) {
        if (ranking == Grade.FIRST.getRanking()) {
            firstPlace++;
        }
        if (ranking == Grade.SECOND.getRanking()) {
            secondPlace++;
        }
        if (ranking == Grade.THIRD.getRanking()) {
            thirdPlace++;
        }
        if (ranking == Grade.FOURTH.getRanking()) {
            fourthPlace++;
        }
        if (ranking == Grade.FIFTH.getRanking()) {
            fifthPlace++;
        }
    }

    public void ranking() {
        List<List<Integer>> allLottoNumbers = setBuyLotto();
        List<Integer> winningNumber = setWinningNumbers();
        int bonusNumber = setBonusNumber();

        for (List<Integer> lottoNumbers : allLottoNumbers) {
            CountMatchNumber countMatchNumber = new CountMatchNumber();
            numberOfWins(Grade.findingRank(countMatchNumber.setWinningNumberMatchCount(lottoNumbers, winningNumber)
                    , countMatchNumber.setBonusNumberMatchCount(lottoNumbers, bonusNumber)).getRanking());
        }
    }

    public int getFirstPlace() {
        return firstPlace;
    }

    public int getSecondPlace() {
        return secondPlace;
    }

    public int getThirdPlace() {
        return thirdPlace;
    }

    public int getFourthPlace() {
        return fourthPlace;
    }

    public int getFifthPlace() {
        return fifthPlace;
    }

    public void calculateSumOfPrize() {
        sumOfPrize += (Grade.FIRST.getPrizeMoney() * getFirstPlace());
        sumOfPrize += (Grade.SECOND.getPrizeMoney() * getSecondPlace());
        sumOfPrize += (Grade.THIRD.getPrizeMoney() * getThirdPlace());
        sumOfPrize += (Grade.FOURTH.getPrizeMoney() * getFourthPlace());
        sumOfPrize += (Grade.FIFTH.getPrizeMoney() * getFifthPlace());
    }

    public double rateOfReturn() {
        return Math.round(( sumOfPrize / buyLotto.getPrice() * 100 * 10)) / 10.0;
    }
}
