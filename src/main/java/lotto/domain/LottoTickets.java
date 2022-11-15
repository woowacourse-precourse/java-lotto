package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private List<List<Integer>> LottoTicket;

    public LottoTickets(int lottoCount) {
        LottoTicket = createLottoTickets(lottoCount);
    }

    private List<List<Integer>> createLottoTickets(int lottoCount) {
        List<List<Integer>> LottoTicket = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            LottoTicket.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        return LottoTicket;
    }



    public List<List<Integer>> getLottoTicket(){
        return LottoTicket;
    }
}


