package lotto.domain.lottomachine.lottoticket;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicketMachine {

    public LottoTickets issueLottoTickets(int money) {
        int numberOfTickets = convertMoneyIntoTickets(money);
        List<Lotto> tickets = new ArrayList<>();

        for (int i = 0; i < numberOfTickets; i++) {
            tickets.add(issueLottoTicket());
        }
        return new LottoTickets(tickets);
    }

    private Lotto issueLottoTicket() {
        List<Integer> numbers = generateSixRandomNumbers();
        sortInAscendingOrder(numbers);
        return createLotto(numbers);
    }

    private Lotto createLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private int convertMoneyIntoTickets(int money) {
        return money / 1000;
    }

    private List<Integer> generateSixRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private void sortInAscendingOrder(List<Integer> list) {
        Collections.sort(list);
    }
}
