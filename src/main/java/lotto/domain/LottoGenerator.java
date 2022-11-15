package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {
    private final List<Lotto> lottoTickets;

    public LottoGenerator(int round) {
        lottoTickets = makeLottoTickets(round);
    }

    private List<Lotto> makeLottoTickets(int round) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < round; i++) {
            tickets.add(new Lotto(makeLottoNumbers()));
        }
        return tickets;
    }

    private List<Integer> makeLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                        LottoNumber.MIN.getNumber(),
                        LottoNumber.MAX.getNumber(),
                        LottoNumber.SIZE.getNumber())
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
}
