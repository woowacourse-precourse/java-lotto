package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class LottoSystem {
    LottoMachine lottoMachine;
    WinningLotto winningLotto;

    public LottoSystem() {
        lottoMachine = new LottoMachine();
        winningLotto = new WinningLotto();
    }

    public List<Lotto> buy() throws IllegalArgumentException {
        System.out.println(Message.INPUT_PURCHASE_AMOUNT);
        String input = Console.readLine().trim();
        return lottoMachine.printLottoBundle(input);
    }

    public void printPurchasedLotto(List<Lotto> lottoBundle) {
        for (Lotto lotto : lottoBundle) {
            System.out.println(lotto.toString());
        }
    }

    private void setWinningNumber() {
        System.out.println(Message.INPUT_WINNING_NUMBER);
        String input = Console.readLine().trim();
        winningLotto.setWinningNumbers(input);
    }
}
