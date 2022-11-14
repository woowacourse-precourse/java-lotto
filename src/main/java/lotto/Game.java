package lotto;

import lotto.view.Input;

public class Game {
    public static final int LOTTO_PRICE = 1000;

    private Lotto winLotto;
    private int bonusNumber;

    public void setWinLotto() {
        winLotto = new Lotto(Input.inputWinLottoNumbers());
        bonusNumber = Input.inputWinLottoBonusNumber();
    }
}

