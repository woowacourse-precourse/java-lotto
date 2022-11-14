package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoStore lottoStore = new LottoStore();
        GetUerNumber createWinningNumber = new GetUerNumber();
        GetBonusNumber bonusNumber = new GetBonusNumber();
        lottoStore.insertMoney();
        lottoStore.getLottoPaper();
        PrintMachine.askWinningNumber();
        List<Integer> winningNumber= createWinningNumber.makeWinningNumber(Console.readLine());
        Lotto lotto = new Lotto(winningNumber);
        PrintMachine.askBonusNumber();
        bonusNumber.getBonusNumber(winningNumber, Console.readLine());
        lotto.getResult(lottoStore.lottoPapers, lottoStore.validMoney, bonusNumber.bonus);
    }
}
