package lotto.domain;

import lotto.utils.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private final List<Lotto> lottoTickets;

    public LottoTickets(int lottoCount, LottoNumberGenerator lottoNumberGenerator) {
        this.lottoTickets = generateLottoTickets(lottoCount, lottoNumberGenerator);
    }

    private List<Lotto> generateLottoTickets(int lottoCount, LottoNumberGenerator lottoNumberGenerator) {
        List<Lotto> lottoTickets = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(lottoNumberGenerator.generate());

            lottoTickets.add(lotto);
        }

        return lottoTickets;
    }

    public int getCount() {
        return lottoTickets.size();
    }
}

