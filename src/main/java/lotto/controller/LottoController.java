package lotto.controller;

import java.util.List;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoResult;
import lotto.domain.NumberOfLottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void gameStart() {
        try {
            NumberOfLottos numberOfLottos = getPriceAmount();
            LottoGenerator lottoGenerator = getLottos(numberOfLottos);
            OutputView.printLottos(numberOfLottos, lottoGenerator);
            LottoResult lottoResult = getLottoResult();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private NumberOfLottos getPriceAmount() {
        return new NumberOfLottos(InputView.getPriceAmount());
    }

    private LottoGenerator getLottos(NumberOfLottos numberOfLottos) {
        int price = numberOfLottos.getPrice();
        int amount = numberOfLottos.calculateNumberOfLottos(price);

        return new LottoGenerator(amount);
    }

    private LottoResult getLottoResult() {
        List<Integer> winningNumbers = InputView.getLottoNumbers();
        int bonusNumber = InputView.getBonusNumbers();

        return new LottoResult(winningNumbers, bonusNumber);
    }
}
