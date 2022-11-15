package lotto.domain;

import static lotto.domain.Lotto.NUMBER_COUNT;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private final List<Lotto> ticket;

    public LottoTicket(List<Lotto> ticket) {
        this.ticket = ticket;
    }

    public static LottoTicket createLottoTicket(int count, int min, int max) {
        return new LottoTicket(autoTickets(count, min, max));
    }

    private static List<Lotto> autoTickets(int count, int min, int max) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            tickets.add(new Lotto(autoNumber(min, max)));
        }
        return tickets;
    }

    private static List<Integer> autoNumber(int min, int max) {
        List<Integer> temp = Randoms.pickUniqueNumbersInRange(min, max, NUMBER_COUNT);
        temp.stream().sorted();
        //Collections.sort(temp);
        return temp;
    }

    public List<Lotto> getTicket() {
        return this.ticket;
    }
}