package lotto.publisher;

public class WinnerLotto {

    private Lotto lotto;
    private int bonusNumber;

    private static class WinningLottoInstanceHolder {
        private static final WinnerLotto INSTANCE = new WinnerLotto();
    }


    private WinnerLotto() {

    }

    public static WinnerLotto getInstance() {
        return WinningLottoInstanceHolder.INSTANCE;
    }


    public void setWinnerLotto(Lotto lotto) {
        if (this.lotto == null) {
            this.lotto = lotto;
        }

    }

    public void setBonusNumber(int bonusNumber) {
        if (this.bonusNumber == 0) {
            this.bonusNumber = bonusNumber;
        }

    }


    public Lotto getWinningLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
