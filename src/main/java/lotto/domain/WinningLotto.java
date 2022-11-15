package lotto.domain;

import java.util.List;


public class WinningLotto {

    private List<Integer> winningLottoNumber;
    private int winningBonusNumber;

    private static WinningLotto winningLotto = new WinningLotto();


    private WinningLotto(){
        this.winningLottoNumber = LottoInputFilter.readLottoNumber();
        this.winningBonusNumber = LottoInputFilter.readBonusNumber();
    }

    public static WinningLotto getInstance() {
        return winningLotto;
    }

    public static List<Integer> getWinningLottoNumber() {
        return winningLotto.winningLottoNumber;
    }

    public static int getWinningBonusNumber() {
        return winningLotto.winningBonusNumber;
    }

}

