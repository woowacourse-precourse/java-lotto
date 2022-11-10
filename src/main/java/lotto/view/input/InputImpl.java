package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputImpl implements Input {

    private static final int MIN_PAYMENT_AMOUNT = 1000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    @Override
    public int inputPaymentAmount() {
        int paymentAmount = Integer.parseInt(Console.readLine());
        if (isAllowedPaymentAmount(paymentAmount)) {
            return paymentAmount;
        }
        return 0;
    }

    @Override
    public List<String> inputWinningNumbers() {
        List<String> winningNumbers = new ArrayList<>(List.of(Console.readLine().split(",")));
        if (isAllowedWinningNumbers(winningNumbers)) {
            return winningNumbers;
        }
        return null;
    }

    private boolean isAllowedPaymentAmount(int paymentAmount) {
        if (paymentAmount < MIN_PAYMENT_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 최소 로또 구매 금액은 1000원입니다.");
        }
        return true;
    }

    private boolean isAllowedWinningNumbers(List<String> winningNumbers) {
        if (winningNumbers.size() != 6 || isDuplicatedNumber(winningNumbers) || !isLottoNumber(winningNumbers)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 서로다른 6개 숫자를 입력해야합니다.");
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

    private boolean isLottoNumber(List<String> winningNumbers) {
        for (String winningNumber : winningNumbers) {
            int number = Integer.parseInt(winningNumber);
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                return false;
            }
        }
        return true;
    }
}
