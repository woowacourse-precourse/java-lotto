package lotto.domain.lottomachine.lottoticket;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.lottomachine.payment.Payment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicketSystem {

    public static final int TICKET_PRICE = 1000;
    public static final int START = 1;
    public static final int END = 45;
    public static final int COUNT = 6;

    private LottoTicketSystem() {
    }

    public static LottoTicketSystem getInstance() {
        return new LottoTicketSystem();
    }

    public LottoTickets issueLottoTickets(Payment money) {
        int numberOfTickets = money.divideBy(TICKET_PRICE);
        List<Lotto> tickets = new ArrayList<>();

        for (int i = 0; i < numberOfTickets; i++) {
            tickets.add(issueLottoTicket());
        }
        return new LottoTickets(tickets);
    }

    private Lotto issueLottoTicket() {
        List<Integer> numbers = generateSixRandomNumbers();
        numbers = sortInAscendingOrder(numbers);
        return createLotto(numbers);
    }

    private Lotto createLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private List<Integer> generateSixRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(START, END, COUNT);
    }

    private List<Integer> sortInAscendingOrder(List<Integer> numbers) {
        List<Integer> copied = new ArrayList<>(numbers);
        Collections.sort(copied);
        return copied;
    }
}
