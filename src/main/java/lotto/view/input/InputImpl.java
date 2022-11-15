package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputImpl implements Input {

    private static final int MIN_PAYMENT_AMOUNT = 1000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    @Override
    public int inputPaymentAmount() throws IllegalArgumentException {
        int paymentAmount = Integer.parseInt(Console.readLine());
        if (isOverMinimumPaymentAmount(paymentAmount) && isAllowedPaymentAmount(paymentAmount)) {
            return paymentAmount;
        }
        return 0;
    }

    @Override
    public List<String> inputWinningNumbers() throws IllegalArgumentException {
        List<String> winningNumbers = new ArrayList<>(List.of(Console.readLine().split(",")));
        if (isAllowedWinningNumbers(winningNumbers)) {
            return winningNumbers;
        }
        return null;
    }

    @Override
    public int inputBonusNumber() throws IllegalArgumentException{
        int bonusNumber = Integer.parseInt(Console.readLine());
        if (isLottoNumber(bonusNumber)) {
            return bonusNumber;
        }
        return 0;
    }

    private boolean isOverMinimumPaymentAmount(int paymentAmount) throws IllegalArgumentException {
        if (paymentAmount < MIN_PAYMENT_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 최소 로또 구매 금액은 1000원입니다.");
        }
        return true;
    }

    private boolean isAllowedPaymentAmount(int paymentAmount) throws IllegalArgumentException {
        if (paymentAmount % MIN_PAYMENT_AMOUNT != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액은 1000원 단위의 금액이어야 합니다.");
        }
        return true;
    }

    private boolean isAllowedWinningNumbers(List<String> winningNumbers) throws IllegalArgumentException {
        if (winningNumbers.size() != 6 || isDuplicatedNumber(winningNumbers) || isAllowedLottoNumber(winningNumbers)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45의 서로다른 6개 숫자를 입력해야합니다.");
        }
        return true;
    }

    private boolean isDuplicatedNumber(List<String> winningNumbers) {
        int winningNumberSize = (int) winningNumbers.stream()
                .distinct().count();
        if (winningNumberSize == 6) {
            return false;
        }
        return true;
    }

    private boolean isAllowedLottoNumber(List<String> winningNumbers) throws IllegalArgumentException{
        for (String winningNumber : winningNumbers) {
            int number = Integer.parseInt(winningNumber);
            if (isLottoNumber(number)) {
                return false;
            }
        }
        return true;
    }

    private boolean isLottoNumber(int number) throws IllegalArgumentException {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 숫자여야 합니다.");
        }
        return true;
    }
}
