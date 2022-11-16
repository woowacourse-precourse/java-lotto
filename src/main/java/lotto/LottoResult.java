package lotto;

import java.util.List;
import java.util.Objects;

public class LottoResult {
    private final List<Lotto> lottoList;
    private final WinningLottoNumber winningLottoNumber;

    private Integer fifthPrizeCount = 0;
    private Integer fourthPrizeCount = 0;
    private Integer thirdPrizeCount = 0;
    private Integer secondPrizeCount = 0;
    private Integer firstPrizeCount = 0;
    private Integer totalPrize = 0;
    private Double yield;

    public Integer getFifthPrizeCount() {
        return fifthPrizeCount;
    }

    public Integer getFourthPrizeCount() {
        return fourthPrizeCount;
    }

    public Integer getThirdPrizeCount() {
        return thirdPrizeCount;
    }

    public Integer getSecondPrizeCount() {
        return secondPrizeCount;
    }

    public Integer getFirstPrizeCount() {
        return firstPrizeCount;
    }

    public double getYield() {
        return yield;
    }


    public LottoResult(List<Lotto> lottoList, WinningLottoNumber winningLottoNumber) {
        this.lottoList = lottoList;
        this.winningLottoNumber = winningLottoNumber;
        setWinningResult();
    }

    private void setWinningResult() {
        for (Lotto lotto : lottoList) {
            getWinningCount(lotto);
        }
        setTotalPrize();
        yieldCalculation();
    }

    private void getWinningCount(Lotto lotto) {
        Integer correctCountCalculation = winningLottoNumber.correctCountCalculation(lotto);
        Integer bonusCountCalculation = winningLottoNumber.bonusCountCalculation(lotto);
        if (Objects.equals(correctCountCalculation, 6)) {
            firstPrizeCount++;
            return;
        }
        if (Objects.equals(correctCountCalculation, 5) && (Objects.equals(bonusCountCalculation, 1))) {
            secondPrizeCount++;
            return;
        }
        if (Objects.equals(correctCountCalculation, 5) && (Objects.equals(bonusCountCalculation, 0))) {
            thirdPrizeCount++;
            return;
        }
        if (Objects.equals(correctCountCalculation, 4)) {
            fourthPrizeCount++;
            return;
        }
        if (Objects.equals(correctCountCalculation, 3)) {
            fifthPrizeCount++;
        }
    }

    private void setTotalPrize() {
        this.totalPrize = (firstPrizeCount * WinningPrize.FIRST_PRIZE.getPrize())
                + (secondPrizeCount * WinningPrize.SECOND_PRIZE.getPrize())
                + (thirdPrizeCount * WinningPrize.THIRD_PRIZE.getPrize())
                + (fourthPrizeCount * WinningPrize.FOURTH_PRIZE.getPrize())
                + (fifthPrizeCount * WinningPrize.FIFTH_PRIZE.getPrize());
    }

    private void yieldCalculation() {
        yield = (double) totalPrize / (lottoList.size() * 10);
    }

}
