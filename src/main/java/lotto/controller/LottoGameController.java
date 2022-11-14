package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.service.LottoGame;
import lotto.view.input.AmountInput;
import lotto.view.input.BonusInput;
import lotto.view.input.WinningInput;
import lotto.view.print.PrintGuideMessage;

public class LottoGameController {
    private final LottoGame game;

    public LottoGameController(LottoGame game) {
        this.game = game;
    }

    public void startGame() {
        String amount = getAmount();
        List<Lotto> tickets = game.createLottoTickets(amount);
        printTickets(amount, tickets);
        List<Integer> winnings = getWinnings();
        int bonus = Integer.parseInt(getBonus(winnings));
        List<String> checkResult = game.compare(winnings, tickets, bonus);
    }

    public String getAmount() {
        PrintGuideMessage.printStartGuide();
        AmountInput input = new AmountInput();
        return input.getInput();
    }

    public void printTickets(String amount, List<Lotto> tickets) {
        PrintGuideMessage.printPurchaseGuide(game.calculateQuantity(amount));
        for (Lotto ticket : tickets) {
            List<Integer> numbers = ticket.getNumbers();
            ticket.ascending(numbers);
            System.out.println(numbers.toString());
        }
    }

    public List<Integer> getWinnings() {
        PrintGuideMessage.printWinningsGuide();
        WinningInput input = new WinningInput();
        return game.toList(input.getInput());
    }

    public String getBonus(List<Integer> winnings) {
        PrintGuideMessage.printBonusGuide();
        BonusInput input = new BonusInput(winnings);
        return input.getInput();
    }

    public void printStatistics() {
        // 당첨 내역과 수익률을 출력
    }
}