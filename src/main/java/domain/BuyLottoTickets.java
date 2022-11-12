package domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import view.OutputView;

public class BuyLottoTickets {

    static List<List<Integer>> buyLottoTickets = new ArrayList<>();

    public void putLottoNumberTickets(int money){
        int pick_count= money/1000;
        for(int number=0; number<pick_count; number++){
            setLottoNumberTicket(buyLottoTickets, number);
          }

        OutputView.printLottoTickets(pick_count, buyLottoTickets);
    }

    private void setLottoNumberTicket(List<List<Integer>> buyLottoTickets, int number) {
        List<Integer> LottoTicket = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(LottoTicket);
        buyLottoTickets.add(LottoTicket);
    }

    public static List<List<Integer>> getBuyLottoTickets() {
        return buyLottoTickets;
    }
}
