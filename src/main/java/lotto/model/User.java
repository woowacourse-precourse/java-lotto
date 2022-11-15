package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.util.InputLottoValidator.LOTTO_TOTAL_COUNT;
import static lotto.util.LottoNumberFormatValidator.LOTTO_NUMBER_MAX;
import static lotto.util.LottoNumberFormatValidator.LOTTO_NUMBER_MIN;

public class User {

    private List<List<Integer>> tickets;
    private final int ticketCount;

    public User (int ticketCount) {
        this.ticketCount = ticketCount;
    }

    public List<List<Integer>> setTickets() {
        List<List<Integer>> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            List<Integer> newTicket = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN,LOTTO_NUMBER_MAX, LOTTO_TOTAL_COUNT)
                    .stream().sorted().collect(Collectors.toList());
            tickets.add(newTicket);
        }
        this.tickets = tickets;
        return tickets;
    }

    public List<List<Integer>> getTickets() {
        return this.tickets;
    }
}