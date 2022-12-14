package lotto.service;

import lotto.domain.TotalLotto;
import lotto.repository.LottoRepository;

public class LottoService {
    private final LottoRepository lottoRepository = LottoRepository.getInstance();

    public void buyLottos(final int validatedPrice) {
        TotalLotto totalLotto = lottoRepository.generateLotto(validatedPrice);
    }
}
