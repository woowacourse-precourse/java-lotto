package domain;

import Util.OutputValue;
import lotto.Lotto;

import java.util.List;
import java.util.Map;

public class MainController {
    public void run(){
        try {
            LottoMachine machine = new LottoMachine();
            List<Lotto> tickets = machine.buyTickets();
            OutputValue.printTicketsList(tickets);

            WinningLotto winningLotto = new WinningLotto();
            Map<Rank, Integer> winningTickets = winningLotto.checking(tickets);
            OutputValue.printWinningCount(winningTickets);
            OutputValue.printProfit(winningTickets, machine.getMoney());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
