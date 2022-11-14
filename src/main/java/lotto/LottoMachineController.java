package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachineController {
    public static void start() {

        int tickets = OrderInput.orderTicket();

        List<Lotto> lottoTickets = new ArrayList<>();

        for (int i = 0; i < tickets; i++) {
            lottoTickets.add(new Lotto(OrderInput.autoNumbers()));
        }

        for (Lotto ticket : lottoTickets) {
            System.out.println(ticket.getNumbers());
        }

        List<Integer> winningNumbers = OrderInput.inputWinningNumber();
        int bonusNumber = OrderInput.inputBonusNumber(winningNumbers);

        WinningStatistics winningStatistics = new WinningStatistics();

        for (int i = 0; i < lottoTickets.size(); i++) {
            int matchCount;
            boolean isSecond;
            Lotto lotto = lottoTickets.get(i);

            matchCount = Draw.numberCount(winningNumbers, lotto);
            isSecond = Draw.isMatchBonusNumber(bonusNumber, lotto);
            winningStatistics.setWinningTickets(matchCount, isSecond);
        }

        winningStatistics.result();
        winningStatistics.calculateProfitRate(tickets);


    }
}
