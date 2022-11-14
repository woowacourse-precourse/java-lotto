package lotto.Domain;

import java.util.List;

public class LottoGame {

    // Number -> Num으로 줄여서 변수명 적용

    private Integer cash;
    private Integer enterNum;
    private List<Integer> lottoList;
    private List<Integer> winNumList;
    private Integer bonusNum;
    private Integer result;
    private float earningRate;

    public LottoGame(Integer cash, Integer enterNum, List<Integer> lottoList, List<Integer> winNumList, Integer bonusNum, Integer result, float earningRate) {
        this.cash = cash;
        this.enterNum = enterNum;
        this.lottoList = lottoList;
        validateList(winNumList);
        this.winNumList = winNumList;
        validateBonusRange(bonusNum);
        this.bonusNum = bonusNum;
        this.result = result;
        this.earningRate = earningRate;
    }

    private void validateList(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateBonusRange(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException();
        }
    }

    private void setLottoList(List<Lotto> lottoList) {

    }
}
