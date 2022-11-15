package lotto.domain;

import lotto.type.ErrorType;
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

        String bonusNumberInput = InputView.inputBonusNumber();

        InputView.isValidFormat(bonusNumberInput);
        InputView.isValidBonusNumber(bonusNumberInput);
        isDuplicateWithWinNumbers(bonusNumberInput);

        addWinNumbers(bonusNumberInput);
    }

    private void addWinNumbers(String winNumberInput) {
        String[] numbers = winNumberInput.split(",");

        for (String number : numbers) {
            winNumbers.add(Integer.parseInt(number));
        }
    }

    private void isDuplicateWithWinNumbers(String bonusNumberInput) {
        int bonus = Integer.parseInt(bonusNumberInput);

        if(winNumbers.contains(bonus))
            throw new IllegalArgumentException(ErrorType.DUPLICATE_WHIT_WIN_NUMBERS.getError());
    }
}
