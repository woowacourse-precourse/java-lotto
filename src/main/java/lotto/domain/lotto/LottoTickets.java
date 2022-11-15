package lotto.domain.lotto;

import lotto.domain.lotto.Lotto;
import lotto.utils.LottoNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {

    private final List<Lotto> lottoTickets;

    public LottoTickets(int lottoCount, LottoNumberGenerator lottoNumberGenerator) {
        this.lottoTickets = generateLottoTickets(lottoCount, lottoNumberGenerator);
    }

    private List<Lotto> generateLottoTickets(int lottoCount, LottoNumberGenerator lottoNumberGenerator) {
        return IntStream.range(0, lottoCount)
                .mapToObj(count -> new Lotto(lottoNumberGenerator.generate()))
                .collect(Collectors.toList());
    }

    public int getCount() {
        return lottoTickets.size();
    }
}

