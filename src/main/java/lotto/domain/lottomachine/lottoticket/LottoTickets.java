package lotto.domain.lottomachine.lottoticket;

import lotto.domain.lottomachine.winningnumber.WinningNumber;
import lotto.domain.lottomachine.winningnumber.WinningNumbers;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class LottoTickets {

    private final List<Lotto> tickets;

    public LottoTickets(List<Lotto> tickets) {
        this.tickets = tickets;
    }

    public int size() {
        return tickets.size();
    }

    public List<String> matchWith(WinningNumbers winningNumbers, WinningNumber bonusNumber) {
        return tickets.stream()
                .map(lotto -> lotto.countNumbersConsistentWith(winningNumbers, bonusNumber))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return tickets.stream()
                .map(Lotto::toString)
                .collect(joining("\n"));
    }
}
