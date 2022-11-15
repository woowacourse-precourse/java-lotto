package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Machine lottoMachine = new Machine();
        int ticketCount = lottoMachine.getMoney();
        List<Lotto> ticketList = lottoMachine.sellTicket(ticketCount);

        lottoMachine.createAnswer();
    }
}
