package lotto.domain;

import lotto.type.ErrorType;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoGame {
    private static int purchaseAmount;
    private static List<Lotto> lottos = new ArrayList<>();
    private static List<Integer> winNumbers = new ArrayList<>();
    private static List<Integer> cashPrizes = Arrays.asList(5000, 50000, 1500000, 30000000, 2000000000);

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

        InputView.isValidBonusNumber(bonusNumberInput);
        isDuplicateWithWinNumbers(bonusNumberInput);

        addWinNumbers(bonusNumberInput);
    }

    public void result() {
        List<Integer> winHistory = countWinLottoMatchCount(winNumbers);

        OutputView.showWinHistory(winHistory);

        double yield = calculateYield(winHistory);
        OutputView.showYield(yield);
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

    private List<Integer> countWinLottoMatchCount(List<Integer> winNumbers) {
        List<Integer> counts = Arrays.asList(0, 0, 0, 0, 0);

        for (Lotto lotto : lottos) {
            int matchCount = lotto.matchNumber(winNumbers);

            if (matchCount == 6 && lotto.hasBonusNumber(winNumbers)) counts.set(4, counts.get(4) + 1);
            else if (matchCount == 6) counts.set(3, counts.get(3) + 1);
            else if (matchCount == 5) counts.set(2, counts.get(2) + 1);
            else if (matchCount == 4) counts.set(1, counts.get(1) + 1);
            else if (matchCount == 3) counts.set(0, counts.get(0) + 1);
        }

        return counts;
    }

    public double calculateYield(List<Integer> winHistory) {
        double total = 0.0;

        for (int i = 0; i < cashPrizes.size(); i++) {
            total += (double)winHistory.get(i) * cashPrizes.get(i);
        }

        System.out.println();
        return Math.round(total/purchaseAmount*1000)/10.0;
    }
}
