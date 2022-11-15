package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoTicket {
    private final List<Integer> ticket;

    public LottoTicket() {
        this.ticket = generateRandomLottoTicket();
    }

    public List<Integer> getTicket() {
        return ticket;
    }

    private List<Integer> generateRandomLottoTicket() {
        List<Integer> LottoTicket = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return LottoTicket;
    }
}