package lotto.domain;

import java.util.List;

public class WinningLotto {
    private static List<Integer> winningLottoNumber;
    private static int winningBonusNumber;

    private static WinningLotto winningLotto = new WinningLotto();

    private WinningLotto(){}

    public static WinningLotto getInstance() {
        return winningLotto;
    }

    public void setWinningLotto(List<Integer> winningLottoNumber, int winningBonusNumber) {
        winningLottoNumber = winningLottoNumber;
        winningBonusNumber = winningBonusNumber;
    }

    public static List<Integer> getWinningLottoNumber() {
        return winningLottoNumber;
    }

    public static int getWinningBonusNumber() {
        return winningBonusNumber;
    }

}
