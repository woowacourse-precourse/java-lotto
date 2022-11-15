package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.lang.IllegalArgumentException;
import java.util.ArrayList;
import java.util.List;


public class LottoManager {
    private List<Integer> winningNumbers = new ArrayList<>();
    private int lottoCount = 0;
    private int purchaseAmount = 0;

    private LottoPrinter lottoPrinter = new LottoPrinter();

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public void readPurchaseAmount() {
        final int lottoPrice = 1000;

        lottoPrinter.printPurchaseAmountMessage();
        String purchaseInput = Console.readLine();
        System.out.println();
        validatePurchasePattern(purchaseInput);
        purchaseAmount = Integer.parseInt(purchaseInput);
        validatePurchaseUnit(lottoPrice);
        lottoCount = purchaseAmount / lottoPrice;
        lottoPrinter.printPurchaseCompletionMessage(lottoCount);
    }

    public void readWinningNumbers() {
        final int winningInputLength = 6;
        lottoPrinter.printGetWinningNumberMessage();
        String winningInput = Console.readLine();
        validateInputPattern(winningInput, winningInputLength);
        String[] winningInputSplit = winningInput.split(",");
        for (String number : winningInputSplit) {
            validateNumberRange(number);
            validateRepetition(winningNumbers, Integer.valueOf(number));
            winningNumbers.add(Integer.valueOf(number));
        }
    }


    public void readBonusNumber() {
        final int bonusInputLength = 1;
        final Integer bonusNumber;
        lottoPrinter.printGetBonusNumberMessage();
        String bonusInput = Console.readLine();
        validateInputPattern(bonusInput, bonusInputLength);
        validateNumberRange(bonusInput);
        bonusNumber = Integer.valueOf(bonusInput);
        validateRepetition(winningNumbers, bonusNumber);
        winningNumbers.add(bonusNumber);
    }

    private void validatePurchaseUnit(int lottoPrice) {
        if (purchaseAmount % lottoPrice != 0) {
            throw new IllegalArgumentException(lottoPrinter.INVALID_PURCHASE_AMOUNT_ERROR);
        }
    }

    private void validatePurchasePattern(String purchaseInput) {
        final String inputPattern = "[0-9]*";
        if (!purchaseInput.matches(inputPattern)) {
            throw new IllegalArgumentException(lottoPrinter.INVALID_PURCHASE_PATTERN_ERROR);
        }
    }

    private void validateRepetition(List<Integer> winningNumbers, Integer number) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(lottoPrinter.WINNING_NUMBERS_REPETITION_ERROR);
        }
    }


    private void validateInputPattern(String input, int inputLength) {
        final String inputPattern = "[0-9]*,".repeat(inputLength - 1) + "[0-9]*";
        if (!input.matches(inputPattern)) {
            throw new IllegalArgumentException(lottoPrinter.WINNING_NUMBERS_PATTERN_ERROR);
        }
    }

    private void validateNumberRange(String number) {
        if (Integer.valueOf(number) > 45 || Integer.valueOf(number) < 1) {
            throw new IllegalArgumentException(lottoPrinter.WINNING_NUMBER_RANGE_ERROR);
        }
    }
}
