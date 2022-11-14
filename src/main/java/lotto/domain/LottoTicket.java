package lotto.domain;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import java.util.List;

public class LottoTicket {
    private List<Lotto> ticket;

    public LottoTicket(List<Lotto> ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return ticket.toString();
    }

    public List<List<Integer>> value() {
        return ticket.stream()
                .map(Lotto::value)
                .collect(toList());
    }

    public LottoResult check(Lotto winningNumbers, LottoNumber bonusNumber) {
        return ticket.stream()
                .map(lotto -> lotto.check(winningNumbers, bonusNumber))
                .collect(collectingAndThen(groupingBy(identity(), counting()), LottoResult::new));
    }
}
