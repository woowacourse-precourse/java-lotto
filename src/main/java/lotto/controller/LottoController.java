package lotto.controller;

import java.util.List;
import lotto.model.LottoGenerator;
import lotto.model.LottoJudge;
import lotto.model.WinningNumber;
import lotto.view.LottoInput;

public class LottoController {

    private LottoGenerator lottoGenerator;
    private LottoJudge lottoJudge;
    private WinningNumber winningNumber;

    public String loadPayMoney() {
        return LottoInput.inputPayMoney();
    }

    public List<Integer> loadWinningNumber() {
        winningNumber = new WinningNumber();
        winningNumber.setWinningNumbers(LottoInput.inputWinningNumber());
        return winningNumber.getWinningNumbers();
    }

    public int loadBonusNumber() {
        winningNumber.setBonusNumber(LottoInput.inputBonusNumber());
        return winningNumber.getBonusNumber();
    }


}
