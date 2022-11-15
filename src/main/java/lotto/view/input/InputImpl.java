package lotto.view.input;

import static lotto.domain.lotto.lotto.LottoInfo.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.utils.message.ErrorMessage;

public class InputImpl implements Input {

    private static final String PAYMENT_AMOUNT_REGEX = "^[0-9]*$";

    @Override
    public int inputPaymentAmount() throws IllegalArgumentException {
        String paymentAmount = Console.readLine();
        validateIsNumber(paymentAmount);
        validatePaymentAmount(Integer.parseInt(paymentAmount));
        return Integer.parseInt(paymentAmount);
    }

    @Override
    public List<String> inputWinningNumbers() throws IllegalArgumentException {
        List<String> winningNumbers = new ArrayList<>(List.of(Console.readLine().split(",")));
        validateWinningNumber(winningNumbers);
        return winningNumbers;
    }

    @Override
    public int inputBonusNumber() throws IllegalArgumentException{
        String bonusNumber = Console.readLine();
        validateIsNumber(bonusNumber);
        isLottoNumber(Integer.parseInt(bonusNumber));
        return Integer.parseInt(bonusNumber);
    }

    private void validatePaymentAmount(int paymentAmount) throws IllegalArgumentException {
        validateIsOverMinimumPaymentAmount(paymentAmount);
        validateIsAllowedPaymentAmount(paymentAmount);
    }

    private void validateIsNumber(String paymentAmount) throws IllegalArgumentException {
        if (!paymentAmount.matches(PAYMENT_AMOUNT_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.UNSATISFIED_PAYMENT_AMOUNT);
        }
    }

    private void validateIsOverMinimumPaymentAmount(int paymentAmount) throws IllegalArgumentException {
        if (paymentAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.NOT_OVER_MINIMUM_PAYMENT_AMOUNT);
        }
    }

    private void validateIsAllowedPaymentAmount(int paymentAmount) throws IllegalArgumentException{
        if (paymentAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.UNSATISFIED_PAYMENT_AMOUNT);
        }
    }

    private void validateWinningNumber(List<String> winningNumbers) throws IllegalArgumentException {
        if (winningNumbers.size() != 6 || isDuplicatedNumber(winningNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.UNSATISFIED_WINNING_NUMBER);
        }

        if (!isAllowedLottoNumber(winningNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.UNSATISFIED_WINNING_NUMBER);
        }
    }

    private boolean isDuplicatedNumber(List<String> winningNumbers) {
        int winningNumberSize = (int) winningNumbers.stream()
                .distinct().count();
        return winningNumberSize != 6;
    }

    private boolean isAllowedLottoNumber(List<String> winningNumbers) throws IllegalArgumentException{
        for (String winningNumber : winningNumbers) {
            int number = Integer.parseInt(winningNumber);
            isLottoNumber(number);
        }
        return true;
    }

    private void isLottoNumber(int number) throws IllegalArgumentException {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.UNSATISFIED_LOTTO_NUMBER);
        }
    }
}
