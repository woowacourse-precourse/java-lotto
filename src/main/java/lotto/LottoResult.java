package lotto;

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

    public LottoResult(List<Lotto> lottoList, WinningLottoNumber winningLottoNumber) {
        this.lottoList = lottoList;
        this.winningLottoNumber = winningLottoNumber;
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
        this.totalPrize = (sixCount * 2000000000)
                + (fiveAndBonusCount * 30000000)
                + (fiveCount * 1500000)
                + (fourCount * 50000)
                + (threeCount * 5000);
    }

    public void getWinningResult() {
        setWinningResult();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + threeCount + "개");
        System.out.println("4개 일치 (50,000원) - " + fourCount + "개");
        System.out.println("5개 일치 (1,500,000원) - " + fiveCount + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + fiveAndBonusCount + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + sixCount + "개");
        System.out.println();
        System.out.println("총 수익률은 " + (double) Math.round(yield * 100) / 100 + "%입니다.");
    }

    private void yieldCalculation() {
        yield = (double) totalPrize / (lottoList.size() * 10);
    }
}
