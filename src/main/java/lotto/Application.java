package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Machine;

public class Application {
    public static void main(String[] args) {
        Machine lottoMachine = new Machine();
        try {
            int ticketCount = lottoMachine.getMoney();
            List<Lotto> ticketList = lottoMachine.sellTicket(ticketCount);

            lottoMachine.createAnswer();
            lottoMachine.printResult(ticketList);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
