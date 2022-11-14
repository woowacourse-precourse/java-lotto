package domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import view.OutputView;

public class BuyLottoTickets {

    private static final int CURRENCY_UNIT = 1000;
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    private static final int TICKET_SIZE = 6;
    static List<List<Integer>> buyLottoTickets = new ArrayList<>();


    public void putLottoNumberTickets(int money) {
        int pick_count = money / CURRENCY_UNIT;
        for (int number = 0; number < pick_count; number++) {
            setLottoNumberTicket(buyLottoTickets);
        }

        OutputView.printLottoTickets(pick_count, buyLottoTickets);
    }

    public void setLottoNumberTicket(List<List<Integer>> buyLottoTickets) {
        List<Integer> LottoTicket = new ArrayList<>(
            Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, TICKET_SIZE));
        Collections.sort(LottoTicket);
        buyLottoTickets.add(LottoTicket);
    }

    public static List<List<Integer>> getBuyLottoTickets() {
        return buyLottoTickets;
    }
}
