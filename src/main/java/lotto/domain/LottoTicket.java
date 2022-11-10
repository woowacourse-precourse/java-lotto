package lotto.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 로또 티켓들을 생성하는 클래스
 */
public class LottoTicket {
    private List<Lotto> lottoTickets = new ArrayList<>();

    public LottoTicket(int ticketNumber) {
        // 티켓 갯수만큼 티켓 생성함
    }

    private void generateTickets(int ticketNumber) {
        for(int i=0; i<ticketNumber; i++){
            List<Integer> numbers = Number.generateRandomLottoNumbers();
            lottoTickets.add(new Lotto(numbers));
        }
    }

}
