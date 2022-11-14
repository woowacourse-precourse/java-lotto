package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 로또 티켓들을 생성하는 클래스
 */
public class LottoTicket {
    private List<Lotto> lottoTickets = new ArrayList<>();

    public LottoTicket(int ticketNumber) {
        // 티켓 갯수만큼 티켓 생성함
        generateTickets(ticketNumber);
    }

    private void generateTickets(int ticketNumber) {
        for (int i = 0; i < ticketNumber; i++) {
            List<Integer> numbers = Number.generateRandomLottoNumbers();
            numbers = sortList(numbers);
            lottoTickets.add(new Lotto(numbers));
        }
    }

    private List<Integer> sortList(List<Integer> numbers) {
        List<Integer> list = new ArrayList<>();
        for (int i : numbers) {
            list.add(i);
        }

        Collections.sort(list);
        return list;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
}
