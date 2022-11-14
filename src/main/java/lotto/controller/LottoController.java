package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import camp.nextstep.edu.missionutils.Randoms;
import view.LottoView;

public class LottoController {

    private final LottoService lottoService;
    private final int countLotto;

    public LottoController(LottoService lottoService, int countLotto) {
        this.lottoService = lottoService;
        this.countLotto = countLotto;
    }

    public void run() {
        for (int i = 0; i < countLotto; i++) {
            createLotto();
        }
        LottoView viewingLotto = viewLotto();
        viewingLotto.show();
    }

    private void createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = new Lotto(numbers);
        lottoService.saveLotto(lotto);
    }

    private LottoView viewLotto() {
        List<Lotto> lottos = lottoService.findLottos();
        return new LottoView(lottos);
    }
}
