package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import camp.nextstep.edu.missionutils.Randoms;
import view.LottoView;

public class LottoController {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int NUMBER_OF_NUMBERS = 6;

    private final LottoService lottoService;
    private final int countLotto;

    public LottoController(LottoService lottoService, int countLotto) {
        this.lottoService = lottoService;
        this.countLotto = countLotto;
    }

    public List<Lotto> run() {
        for (int i = 0; i < countLotto; i++) {
            createLotto();
        }
        LottoView viewingLotto = viewLotto();
        viewingLotto.show();
        return lottoService.findLottos();
    }

    private void createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_OF_NUMBERS);
        Lotto lotto = new Lotto(numbers);
        lottoService.saveLotto(lotto);
    }

    private LottoView viewLotto() {
        List<Lotto> lottos = lottoService.findLottos();
        return new LottoView(lottos);
    }
}
