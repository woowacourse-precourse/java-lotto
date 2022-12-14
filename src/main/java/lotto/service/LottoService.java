package lotto.service;

import lotto.domain.TotalLotto;
import lotto.repository.LottoRepository;

public class LottoService {
    private final LottoRepository lottoRepository = LottoRepository.getInstance();

    public TotalLotto buyLottos(final int validatedPrice) {
        return lottoRepository.generateLotto(validatedPrice);
    }
}
