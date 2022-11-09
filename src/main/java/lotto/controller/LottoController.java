package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoAnswer;
import lotto.domain.LottoResult;
import lotto.view.OutputView;

public class LottoController {
    private static final int PRICE_PER_LOTTO = 1000;
    private List<Lotto> lottos;
    private LottoAnswer lottoAnswer;
    private LottoResult lottoResult;
    private LottoResultController lottoResultController;
    private final InputController inputController = new InputController();
    private int price;
    private int lottoCount;


    public void run() {
        int price = inputController.getPrice();
        int lottoCount = price / PRICE_PER_LOTTO;
        generateLottos(lottoCount);
        LottoAnswer lottoAnswer = inputController.getLottoAnswer();
        lottoResultController = new LottoResultController(lottoAnswer, lottos, price);
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
