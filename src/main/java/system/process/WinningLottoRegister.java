package system.process;

import models.Lotto;
import models.WinningLotto;
import view.WinningLottoRegisterView;

public class WinningLottoRegister {
    private WinningLotto winningLotto;

    public WinningLottoRegister() {
        Lotto lotto = new Lotto(WinningLottoRegisterView.inputWinningLottoNumbers());
        int bonusNumber = WinningLottoRegisterView.inputWinningLottoBonusNumber();
        winningLotto = new WinningLotto(lotto, bonusNumber);
    }

    public WinningLotto getWinningLotto() {
        return winningLotto;
    }
}
