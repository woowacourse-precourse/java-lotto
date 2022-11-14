package lotto.view;

import lotto.model.Lottos;
import lotto.model.WinningInfo;

public class OutputView {
    private static OutputView instance;

    private OutputView() {
    }

    public OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView();
        }

        return instance;
    }

    public void printNumberOfLottos(int numberOfLottos) {
        System.out.println();
        System.out.println(numberOfLottos + "개를 구매했습니다.");
    }

    public void printLottos(Lottos lottos) {
        System.out.println(lottos);
    }

    public void printWinningInfo(WinningInfo winningInfo) {
        System.out.println(winningInfo);
    }
}
