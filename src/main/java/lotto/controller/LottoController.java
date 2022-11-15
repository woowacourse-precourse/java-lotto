package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.domain.GetBonusNumber;
import lotto.domain.GetWinningNumber;
import lotto.domain.LottoStore;
import lotto.view.PrintMachine;

public class LottoController {
    public void startLotto() {
        LottoStore lottoStore = new LottoStore();
        GetWinningNumber winningLotto = new GetWinningNumber();
        GetBonusNumber bonusNumber = new GetBonusNumber();
        lottoStore.insertMoney();
        lottoStore.getLottoPaper();
        PrintMachine.askWinningNumber();
        winningLotto.getWinningNumber(Console.readLine());
        Lotto lotto = new Lotto(winningLotto.winningNumber);
        PrintMachine.askBonusNumber();
        bonusNumber.getBonusNumber(winningLotto.winningNumber, Console.readLine());
        lotto.getResult(lottoStore.lottoPapers, lottoStore.validMoney, bonusNumber.bonus);
    }
}
