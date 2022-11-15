package lotto;

import java.util.List;
import java.util.Objects;

public class LottoResult {
    public static final int FIRST_PRIZE = 2000000000;
    public static final int SECOND_PRIZE = 30000000;
    public static final int THIRD_PRIZE = 1500000;
    public static final int FOURTH_PRIZE = 50000;
    public static final int FIFTH_PRIZE = 5000;

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
    public double getYield(){
        return (double) Math.round(yield * 100) / 100;
    }



    public LottoResult(List<Lotto> lottoList, WinningLottoNumber winningLottoNumber) {
        this.lottoList = lottoList;
        this.winningLottoNumber = winningLottoNumber;
        setWinningResult();
    }

    private void setWinningResult() {
        for (Lotto lotto : lottoList) {
            Integer correctCountCalculation = winningLottoNumber.correctCountCalculation(lotto);
            Integer bonusCountCalculation = winningLottoNumber.bonusCountCalculation(lotto);
            if (Objects.equals(correctCountCalculation, 6)) {
                sixCount++;
                continue;
            }
            if (Objects.equals(correctCountCalculation, 5) && (Objects.equals(bonusCountCalculation, 1))) {
                fiveAndBonusCount++;
                continue;
            }
            if (Objects.equals(correctCountCalculation, 5) && (Objects.equals(bonusCountCalculation, 0))) {
                fiveCount++;
                continue;
            }
            if (Objects.equals(correctCountCalculation, 4)) {
                fourCount++;
                continue;
            }
            if (Objects.equals(correctCountCalculation, 3)) {
                threeCount++;
            }
        }
        setTotalPrize();
        yieldCalculation();
    }

    private void setTotalPrize() {
        this.totalPrize = (sixCount * FIRST_PRIZE)
                + (fiveAndBonusCount * SECOND_PRIZE)
                + (fiveCount * THIRD_PRIZE)
                + (fourCount * FOURTH_PRIZE)
                + (threeCount * FIFTH_PRIZE);
    }

    private void yieldCalculation() {
        yield = (double) totalPrize / (lottoList.size() * 10);
    }

}
