package lotto.service;

import lotto.Lotto;
import lotto.LottoGenerator;
import lotto.reposiotory.Repository;

import java.util.List;

public class Service {
    private final Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public List<Lotto> genLottos(String amount) {
        List<Lotto> lottos = LottoGenerator.generatLottos(amount);
        repository.saveAll(lottos);
        return lottos;
    }
}
