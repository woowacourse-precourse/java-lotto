package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private final List<Integer> ticket;

    public LottoTicket(List<Integer> lottoTicket) {
        this.ticket = lottoTicket;
    }

    private List<Integer> generateRandomLottoTicket() {
        List<Integer> LottoTicket = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return sortRandomLottoTicket(LottoTicket);
    }

    private List<Integer> sortRandomLottoTicket(List<Integer> LottoTicket) {
        Collections.sort(LottoTicket);
        return LottoTicket;
    }
}