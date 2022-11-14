package lotto;

import camp.nextstep.edu.missionutils.Console;

public class DoLotto {
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
