package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.constant.Constant;
import lotto.domain.Lotto;
import lotto.domain.LottoAnswer;
import lotto.domain.LottoResult;
import lotto.service.LottoResultService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private List<Lotto> lottos = new ArrayList<>();
    private LottoAnswer lottoAnswer;
    private LottoResult lottoResult;
    private LottoResultService lottoResultService;
    private final InputView inputView = new InputView();
    private int price;
    private int lottoCount;


    public void run() throws Exception {
        int price = inputView.getPrice();
        int lottoCount = price / Constant.UNIT_PRICE.getValue();
        generateLottos(lottoCount);
        OutputView.printLottos(lottoCount, lottos);

        LottoAnswer lottoAnswer = inputView.getLottoAnswer();
        lottoResultService = new LottoResultService(lottoAnswer, lottos, price);
        lottoResultService.run();
        LottoResult lottoResult = lottoResultService.getLottoResult();
        double yield = lottoResultService.getYield();
        OutputView.printResult(lottoResult, yield);
    }

    private void generateLottos(int repeat) throws Exception {
        for (int i = 0; i < repeat; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(
                    Constant.LOTTO_MIN_VALUE.getValue(),
                    Constant.LOTTO_MAX_VALUE.getValue(),
                    Constant.LOTTO_LENGTH.getValue()));
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
    }
}
