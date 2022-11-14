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

    public LottoResult(List<Lotto> lottoList, WinningLottoNumber winningLottoNumber) {
        this.lottoList = lottoList;
        this.winningLottoNumber = winningLottoNumber;
    }

    private void setWinningResult(){
        for(Lotto lotto : lottoList){
            Integer correctCountCalculation = winningLottoNumber.correctCountCalculation(lotto);
            Integer bonusCountCalculation = winningLottoNumber.bonusCountCalculation(lotto);
            if(Objects.equals(correctCountCalculation, 6)){
                sixCount++;
                continue;
            }
            if(Objects.equals(correctCountCalculation, 5) && (Objects.equals(bonusCountCalculation, 1))){
                fiveAndBonusCount++;
                continue;
            }
            if(Objects.equals(correctCountCalculation, 5) && (Objects.equals(bonusCountCalculation, 0))){
                fiveCount++;
                continue;
            }
            if(Objects.equals(correctCountCalculation, 4)){
                fourCount++;
                continue;
            }
            if(Objects.equals(correctCountCalculation, 3)){
                threeCount++;
            }
        }
    }

    public void getWinningResult(){
        setWinningResult();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + threeCount + "개");
        System.out.println("4개 일치 (50,000원) - " + fourCount + "개");
        System.out.println("5개 일치 (1,500,000원) - " + fiveCount + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + fiveAndBonusCount + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + sixCount + "개");
    }
}
