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

    private static void setWinningLottoNumber() {
        winningLotto.winningLottoNumber = LottoInputFilter.readLottoNumber();
    }

    private static void setWinningBonusNumber(int bonusNumber) {
        if (winningLotto.winningLottoNumber == null) setWinningLottoNumber();
        if (winningLotto.winningLottoNumber.contains(bonusNumber)) {
            System.out.println(ErrorMessage.DUPLICATED_NUMBER.getMessage());
            throw new IllegalArgumentException();
        }
        winningLotto.winningBonusNumber = bonusNumber;
    }

    private static void setWinningBonusNumber() {
        int bonusNumber = LottoInputFilter.readBonusNumber();
        setWinningBonusNumber(bonusNumber);
    }

}

