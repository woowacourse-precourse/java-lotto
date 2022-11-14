package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.repository.LottoRepository;

public class LottoService {

    private final LottoRepository lottoRepository;

    public LottoService(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    public void saveLotto(Lotto lotto) {
        lottoRepository.save(lotto);
    }

    public List<Lotto> findLottos() {
        return lottoRepository.findAll();
    }
}
