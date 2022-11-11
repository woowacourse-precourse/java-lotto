package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class LottoUI {
    LottoMachine lottoMachine;
    LottoSystem lottoSystem;

    public LottoUI() {
        lottoMachine = new LottoMachine();
        lottoSystem = new LottoSystem();
    }

    public List<Lotto> buy() throws IllegalArgumentException {
        System.out.println(Message.INPUT_PURCHASE_AMOUNT);
        String input = Console.readLine().trim();
        return lottoMachine.printLottoBundle(input);
    }

    public void printLottoBundle(List<Lotto> lottoBundle) {
        for (Lotto lotto : lottoBundle) {
            System.out.println(lotto.toString());
        }
    }

    public void inputWinningNumbers() throws IllegalArgumentException {
        System.out.println(Message.INPUT_WINNING_NUMBERS);
        String numbers = Console.readLine();
        lottoSystem.setWinningNumbers(numbers);
        System.out.println(Message.INPUT_BONUS_NUMBER);
        String bonusNumber = Console.readLine();
        lottoSystem.setBonusNumber(bonusNumber);
    }

    public void printWinningStatistics(List<Lotto> lottoBundle) {
        System.out.println(Message.PRINT_WINNING_STATISTICS);
    }
}
