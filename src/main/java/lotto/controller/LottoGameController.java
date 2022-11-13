package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.service.LottoGame;
import lotto.view.input.AmountInput;
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
    }

    public String getAmount() {
        PrintGuideMessage.printStartGuide();
        AmountInput input = new AmountInput();
        return input.getInput();
    }

    public void printTickets(String amount, List<Lotto> tickets) {
        PrintGuideMessage.printPurchaseGuide(game.calculateQuantity(amount));
        for (Lotto ticket : tickets) {
            System.out.println(ticket.getNumbers().toString());
        }
    }

    public void getWinnings() {
        //당첨 번호 입력받기
    }

    public void getBonus() {
        // 보너스 번호 입력받기
    }

    public void printStatistics() {
        // 당첨 내역과 수익률을 출력
    }
}