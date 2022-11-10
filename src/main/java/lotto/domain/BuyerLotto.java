package lotto.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.view.Message.BONUS_NUMBER_INPUT;
import static lotto.view.Message.WINNING_NUMBER_INPUT;

import java.util.stream.Stream;
import lotto.view.ErrorMessage;
import lotto.view.Message;

public class BuyerLotto {

    static String winningNumber;
    static String bonusNumber;

    public void purchaseLotto() {
        System.out.println(Message.PURCHASE_PRICE.getMessage());
        String purchasePrice = readLine();
        int purchaseLottoCount = Integer.parseInt(purchasePrice);
        validateDivideNumber(purchaseLottoCount);
        System.out.println(purchaseLottoCount / 1000 + Message.PURCHASE_COUNT.getMessage());
    }


    void winningNumberInput() {
        System.out.println(WINNING_NUMBER_INPUT);
        winningNumber = readLine();
    }

    void bonusNumberInput() {
        System.out.println(BONUS_NUMBER_INPUT);
        bonusNumber = readLine();
    }

    void validateDivideNumber(int purchaseLottoCount) {
        if (purchaseLottoCount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PRICE.getErrorMessage());
        }
    }

    void validateWinningNumber(String winningNumber) {
        Integer[] WinningNumberArr = Stream.of(winningNumber.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toArray(Integer[]::new);
        for (int i = 0; i < WinningNumberArr.length; i++) {
            if (WinningNumberArr[i] < 1 || WinningNumberArr[i] > 45) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_NUMBER_RANGE.getErrorMessage());
            }
        }
    }

    void validateWinningNumberSize(String winningNumber) {
        winningNumber.split(",");
        if (winningNumber.length() != 6) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_LENGTH.getErrorMessage());
        }
    }

    void validateInputBonusNumber(String bonusNumber) {
        Integer[] bonusNumberArr = Stream.of(bonusNumber)
                .mapToInt(Integer::parseInt)
                .boxed()
                .toArray(Integer[]::new);
        if (bonusNumberArr[0] < 1 || bonusNumberArr[0] > 45) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_BONUS_NUMBER.getErrorMessage());
        }
    }

    void validateInputSeparator(String winningNumber) {
        String[] checkSeparator = winningNumber.split(",");
        if (checkSeparator.length != 6) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_SEPARATOR.getErrorMessage());
        }
    }

    void validateInputBlank(String winningNumber) {
        for (int i = 0; i < winningNumber.length(); i++) {
            if (winningNumber.charAt(i) == ' ') {
                throw new IllegalArgumentException(ErrorMessage.ERROR_BLANK.getErrorMessage());
            }
        }
    }

}
