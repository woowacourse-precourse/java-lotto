package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMaker {
    private static final int NUMBERS_SIZE = 6;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;

    public List<Lotto> makeLottoTickets(int ticketCount){
        List<Lotto> lottoTickets = new ArrayList<>();
        for(int i = 0; i < ticketCount; i++){
            Lotto lotto = new Lotto(createLottoNumbers());
            lottoTickets.add(lotto);
        }
        return lottoTickets;

    }

    public List<Integer> createLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, NUMBERS_SIZE);
    }

    public int calculateTicketCount(int money){
        return money/1000;
    }
}
