package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
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
        double yield = lottoResultController.getYield();
        OutputView.printResult(lottoResult, yield);
    }


    private void generateLottos(int repeat) {
        for (int i = 0; i < repeat; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
    }
}
