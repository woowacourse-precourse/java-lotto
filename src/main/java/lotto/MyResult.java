package lotto;

import java.util.ArrayList;
import java.util.List;

public class MyResult {
    private final List<Integer> winningResult;

    public MyResult(List<Lotto> myLottos, WinningLotto winningLotto) {
        this.winningResult = checkLottos(myLottos, winningLotto);
    }

    private List<Integer> checkLottos(List<Lotto> myLottos, WinningLotto winningLotto) {
        List<Integer> winningResult = new ArrayList<>(List.of(0, 0, 0, 0, 0));
        for (Lotto myLotto : myLottos) {
            plusResult(winningResult, compareLotto(myLotto, winningLotto));
        }
        return winningResult;
    }

    private List<Integer> compareLotto(Lotto myLotto, WinningLotto winningLotto) {
        List<Integer> matchCount = new ArrayList<>(List.of(0, 0));
        for (int myNum : myLotto.getLottoNumbers()) {
            if (winningLotto.getWinNumbers().contains(myNum)) {
                matchCount.set(0, matchCount.get(0) + 1);
            }
            if (winningLotto.getBonusNumber() == myNum) {
                matchCount.set(1, 1);
            }
        }
        return matchCount;
    }

    private void plusResult(List<Integer> winningResult, List<Integer> matchCount) {
        if (matchCount.get(0) == 3) {
            winningResult.set(0, winningResult.get(0) + 1);
        }
        if (matchCount.get(0) == 4) {
            winningResult.set(1, winningResult.get(1) + 1);
        }
        if (matchCount.get(0) == 5 && matchCount.get(1) == 0) {
            winningResult.set(2, winningResult.get(2) + 1);
        }
        if (matchCount.get(0) == 5 && matchCount.get(1) == 1) {
            winningResult.set(3, winningResult.get(3) + 1);
        }
        if (matchCount.get(0) == 6) {
            winningResult.set(4, winningResult.get(4) + 1);
        }
    }

    public List<Integer> getWinningResult(){
        return this.winningResult;
    }
}
