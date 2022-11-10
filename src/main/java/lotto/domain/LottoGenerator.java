package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int MINIMUM_LOTTO_NUMBER = 1;


    public static LottoTickets generateTickets(Money money) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < money.getTicketCount(); i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_COUNT);
            lottoTickets.add(new LottoTicket(lottoNumbers));
        }
        return new LottoTickets(lottoTickets);
    }
}
