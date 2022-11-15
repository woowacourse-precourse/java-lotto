package domain;

import java.util.List;
import java.util.Objects;

public class LottoResult {
    private final List<Lotto> lottoList;
    private final WinningLottoNumber winningLottoNumber;

    private Integer threeCount = 0;
    private Integer fourCount = 0;
    private Integer fiveCount = 0;
    private Integer fiveAndBonusCount = 0;
    private Integer sixCount = 0;
    private Integer totalPrize = 0;
    private Double yield;

    public Integer getThreeCount() {
        return threeCount;
    }

    public Integer getFourCount() {
        return fourCount;
    }

    public Integer getFiveCount() {
        return fiveCount;
    }

    public Integer getFiveAndBonusCount() {
        return fiveAndBonusCount;
    }

    public Integer getSixCount() {
        return sixCount;
    }

    public double getYield() {
        return (double) Math.round(yield * 100) / 100;
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
            sixCount++;
            return;
        }
        if (Objects.equals(correctCountCalculation, 5) && (Objects.equals(bonusCountCalculation, 1))) {
            fiveAndBonusCount++;
            return;
        }
        if (Objects.equals(correctCountCalculation, 5) && (Objects.equals(bonusCountCalculation, 0))) {
            fiveCount++;
            return;
        }
        if (Objects.equals(correctCountCalculation, 4)) {
            fourCount++;
            return;
        }
        if (Objects.equals(correctCountCalculation, 3)) {
            threeCount++;
        }
    }

    private void setTotalPrize() {
        this.totalPrize = (sixCount * WinningPrize.FIRST_PRIZE.getPrize())
                + (fiveAndBonusCount * WinningPrize.SECOND_PRIZE.getPrize())
                + (fiveCount * WinningPrize.THIRD_PRIZE.getPrize())
                + (fourCount * WinningPrize.FOURTH_PRIZE.getPrize())
                + (threeCount * WinningPrize.FIFTH_PRIZE.getPrize());
    }

    private void yieldCalculation() {
        yield = (double) totalPrize / (lottoList.size() * 10);
    }

}
