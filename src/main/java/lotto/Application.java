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
        PrintMessenger.askWinningNumber();
        List<Integer> winningNumber= createWinningNumber.makeWinningNumber(Console.readLine());
        Lotto lotto = new Lotto(winningNumber);
        PrintMessenger.askBonusNumber();
        bonusNumber.getBonusNumber(winningNumber, Console.readLine());
        System.out.println(bonusNumber.bonus);
        lotto.getResult(lottoStore.lottoPapers, lottoStore.validMoney, bonusNumber.bonus);
    }
}
