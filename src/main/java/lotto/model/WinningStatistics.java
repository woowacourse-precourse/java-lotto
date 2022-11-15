package lotto.model;

import lotto.util.LottoConstant;
import lotto.util.PrizeMoneyMessage;

import java.util.List;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/12
 */
public class WinningStatistics {
    private int firstGrade;
    private int secondGrade;
    private int thirdGrade;
    private int fourthGrade;
    private int fifthGrade;
    private String rateOfReturn;   // 수익률

    public WinningStatistics(Lotto winningLotto, List<Lotto> boughtLottos, int bonusNumber) {
        init();
        for (Lotto boughtLotto : boughtLottos) {
            int count = 0;
            count = getCount(winningLotto, boughtLotto, count);
            addGrade(bonusNumber, boughtLotto, count);
            calcRateOfReturn(boughtLottos.size() * 1000);
        }
    }

    private int getCount(Lotto winningLotto, Lotto boughtLotto, int count) {
        for (int number : boughtLotto.getNumbers()) {
            if (winningLotto.getNumbers().contains(number)) {
                count++;
            }
        }
        return count;
    }

    private void init() {
        this.firstGrade = 0;
        this.secondGrade = 0;
        this.thirdGrade = 0;
        this.fourthGrade = 0;
        this.fifthGrade = 0;
    }

    private void addGrade(int bonusNumber, Lotto boughtLotto, int count) {
        if (count == LottoConstant.MATCH_NUMBER_FIRST_GRADE.getValue()) {
            firstGrade++;
        } else if (count == LottoConstant.MATCH_NUMBER_THIRD_GRADE.getValue() && boughtLotto.getNumbers().contains(bonusNumber)) {
            secondGrade++;
        } else if (count == LottoConstant.MATCH_NUMBER_THIRD_GRADE.getValue()) {
            thirdGrade++;
        } else if (count == LottoConstant.MATCH_NUMBER_FOURTH_GRADE.getValue()) {
            fourthGrade++;
        } else if (count == LottoConstant.MATCH_NUMBER_FIFTH_GRADE.getValue()) {
            fifthGrade++;
        }
    }

    private void calcRateOfReturn(int boughtPrice) {
        int returnMoney = fifthGrade * LottoConstant.LOTTO_PRIZE_MONEY_FIFTH_GRADE.getValue()
                + fourthGrade * LottoConstant.LOTTO_PRIZE_MONEY_FOURTH_GRADE.getValue()
                + thirdGrade * LottoConstant.LOTTO_PRIZE_MONEY_THIRD_GRADE.getValue()
                + secondGrade * LottoConstant.LOTTO_PRIZE_MONEY_SECOND_GRADE.getValue()
                + firstGrade * LottoConstant.LOTTO_PRIZE_MONEY_FIRST_GRADE.getValue();
        this.rateOfReturn = String.format("%.1f", (double) returnMoney / boughtPrice * 100);
    }

    @Override
    public String toString() {
        return "당첨 통계\n" +
                "---\n" +
                PrizeMoneyMessage.FIFTH_GRADE.getMessage(fifthGrade) + "\n" +
                PrizeMoneyMessage.FOURTH_GRADE.getMessage(fourthGrade) + "\n" +
                PrizeMoneyMessage.THIRD_GRADE.getMessage(thirdGrade) + "\n" +
                PrizeMoneyMessage.SECOND_GRADE.getMessage(secondGrade) + "\n" +
                PrizeMoneyMessage.FIRST_GRADE.getMessage(firstGrade) + "\n" +
                "총 수익률은 " + rateOfReturn +"%입니다.";
    }
}
