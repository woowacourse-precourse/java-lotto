package lotto.domain;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static int purchaseAmount;
    private static List<Lotto> lottos = new ArrayList<>();
    private static List<Integer> winNumbers = new ArrayList<>();

    public void start() {
        String input = InputView.inputPurchaseAmount();

        InputView.isNumber(input);

        purchaseAmount = Integer.parseInt(input);
        InputView.isValidUnit(purchaseAmount);
    }

    public void play() {
        int lottoCount = purchaseAmount / 1000;

        OutputView.showLottoCount(lottoCount);

        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(LottoPrinter.makeUniqueNumbers());
            lottos.add(lotto);
            OutputView.showLottoNumber(lotto);
        }

        String winNumberInput = InputView.inputWinNumber();

        InputView.isValidFormat(winNumberInput);

        addWinNumbers(winNumberInput);
    }

    private void addWinNumbers(String winNumberInput) {
        String[] numbers = winNumberInput.split(",");

        for (String number : numbers) {
            winNumbers.add(Integer.parseInt(number));
        }
    }
}
