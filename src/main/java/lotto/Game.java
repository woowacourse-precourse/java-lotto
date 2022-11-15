package lotto;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Client client;
    private LottoAgency lottoAgency;

    public Game() {
        client = new Client(new ClientInputTerminal());
    }
    public void run() {
        try {
            int amount = client.buy();
            List<List<Integer>> tickets = new LottoAgency(amount, new NumberGeneratorRandom()).issue();
            client.printLottoInfo(tickets);
            List<Integer> answer = client.mark();
            Integer bonus = client.bonusMark();

            List<Prize> prizes = new ArrayList<>();
            for (List<Integer> ticket : tickets) {
                prizes.add(new Lotto(answer).raffle(ticket, bonus));
            }
            double profit = new Calculator(amount, prizes).profit();
            client.printLottoResult(prizes, profit);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
