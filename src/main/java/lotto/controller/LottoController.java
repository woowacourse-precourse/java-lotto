package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoFactory;
import lotto.model.WinningLotto;
import lotto.utils.InputUtils;

import java.util.List;

public class LottoController extends Controller {
    private InputUtils inputUtils = InputUtils.getInstance();

    public List<Lotto> createLottos(int numberOfLotto) {
        outputView.printOutputNumberOfPurchaseLotto(numberOfLotto);

        LottoFactory lottoFactory = new LottoFactory();
        List<Lotto> lottos = lottoFactory.createLottos(numberOfLotto);

        outputView.printLottos(lottos);
        return lottos;
    }
}