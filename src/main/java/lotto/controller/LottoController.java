package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import view.LottoView;

public class LottoController {

    private final LottoService lottoService;
    private final int countLotto;

    public LottoController(LottoService lottoService, int countLotto) {
        this.lottoService = lottoService;
        this.countLotto = countLotto;
    }

    public List<Lotto> run() {
        for (int i = 0; i < countLotto; i++) {
            lottoService.createLotto();
        }
        LottoView viewingLotto = viewLotto();
        viewingLotto.show();
        return lottoService.findLottos();
    }

    private LottoView viewLotto() {
        List<Lotto> lottos = lottoService.findLottos();
        return new LottoView(lottos);
    }
}
