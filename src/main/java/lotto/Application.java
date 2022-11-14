package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
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
