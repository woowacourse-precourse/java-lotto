package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoAnswer;
import lotto.domain.LottoResult;
import lotto.view.OutputView;

public class LottoController {
    private List<Lotto> lottos;
    private LottoAnswer lottoAnswer;
    private LottoResult lottoResult;
    private LottoResultController lottoResultController;
    private final InputController inputController = new InputController();

    public void run() {
        int lottoCount = inputController.getLottoCount();
        generateLottos(lottoCount);
        LottoAnswer lottoAnswer = inputController.getLottoAnswer();
        lottoResultController = new LottoResultController(lottoAnswer, lottos);
        lottoResultController.run();
        LottoResult lottoResult = lottoResultController.getLottoResult();
        OutputView.printResult(lottoResult);
    }

    private void generateLottos(int repeat) {
    }

}
