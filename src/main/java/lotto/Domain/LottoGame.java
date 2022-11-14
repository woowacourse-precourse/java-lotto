package lotto.Domain;

import java.util.List;

public class LottoGame {

    // Number -> Num으로 줄여서 변수명 적용

    private Integer cash;
    private Integer enterNum;
    private List<Integer> lottoList;
    private Integer bonusNum;
    private Integer result;
    private float earningRate;

    public LottoGame(Integer cash, Integer enterNum, List<Integer> lottoList, Integer bonusNum, Integer result, float earningRate) {
        this.cash = cash;
        this.enterNum = enterNum;
        this.lottoList = lottoList;
        validateBonusRange(bonusNum);
        this.bonusNum = bonusNum;
        this.result = result;
        this.earningRate = earningRate;
    }

    private void validateBonusRange(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException();
        }
    }


}
