package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.ResultRepository;
import lotto.domain.WinningLotto;

public class ResultController {

    private final WinningLotto winningLotto;
    private final List<Lotto> lottos;
    ResultRepository repository;

    public ResultController(WinningLotto winningLotto, List<Lotto> lottos) {
        this.winningLotto = winningLotto;
        this.lottos = lottos;
        repository = new ResultRepository();
    }

    public void sratchLottos() {
        for (Lotto lotto : lottos) {
            Rank rank = winningLotto.match(lotto);
            repository.add(rank);
        }
    }

}
