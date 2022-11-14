package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LottoTicket {
    private final List<Lotto> lottoTickets = new ArrayList<>();

    public LottoTicket(int count) {
        generateTickets(count);
    }

    private void generateTickets(int count) {
        for (int i = 0; i < count; i++) {
            lottoTickets.add(Lotto.of());
        }
    }

    public List<Lotto> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

}
