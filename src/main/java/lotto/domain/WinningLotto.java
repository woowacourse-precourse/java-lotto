package lotto.domain;

import java.util.List;


public class WinningLotto {
    private List<Integer> winningLottoNumber;
    private int winningBonusNumber;

    private static WinningLotto winningLotto = new WinningLotto();


    private WinningLotto(){
        setWinningLotto();
    }

    public static WinningLotto getInstance() {
        return winningLotto;
    }

    private void setWinningLotto() {
        setWinningLottoNumber(LottoInputFilter.readLottoNumber());
        setWinningBonusNumber(LottoInputFilter.readBonusNumber());
    }

    public static List<Integer> getWinningLottoNumber() {
        return winningLotto.winningLottoNumber;
    }

    public static int getWinningBonusNumber() {
        return winningLotto.winningBonusNumber;
    }

    private static void setWinningLottoNumber(List<Integer> lottoNumber) {
        winningLotto.winningLottoNumber = lottoNumber;
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

