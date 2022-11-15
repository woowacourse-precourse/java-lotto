package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinnerSelector {
    private final List<Integer> winningNumber;
    private final Integer bonusNumber;

    public WinnerSelector(String anyWord) {
        // test를 위해 만든 생성자
        this.winningNumber = List.of(1, 2, 3, 4, 5, 6);
        this.bonusNumber = 9;

    }
    public WinnerSelector() {
        Viewer viewer = new Viewer();
        this.winningNumber = viewer.selectNumber();
        this.bonusNumber = viewer.selectBonus();
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }


    public List<List<Integer>> compareLottos(List<Lotto> lottos) {
        List<List<Integer>> lottoResults=new ArrayList<>();
        for (Lotto lotto : lottos) {
            List<Integer> eachLottoResult = compareLotto(lotto);
            lottoResults.add(eachLottoResult);
        }

        return lottoResults;

    }


    public List<Integer> compareLotto(Lotto lotto) {
        List<Integer> lottoNumber = lotto.getNumbers();
        int matchCount = 0;
        int bonusCount= 0;
        for (Integer number : lottoNumber) {
            if (winningNumber.contains(number)) {
                matchCount++;
            }
            if (number == bonusNumber) {
                bonusCount = 1;
            }
        }

        return List.of(matchCount, bonusCount);
    }

}
