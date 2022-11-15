package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.Constants.*;

public class Application {

    public static void main(String[] args) {
        String purchaseAmount = InputView.getPurchaseAmount();
        validatePurchaseAmount(purchaseAmount);

        int lottoCount = OutputView.getLottoCount(purchaseAmount, UNIT);
        List<Lotto> userLotto = publishLotto(lottoCount);
        OutputView.showLottoSheets(userLotto);

        List<Integer> winningNumbers = InputView.getWinningNumber();
        validateWinningNumbers(winningNumbers);
        String bonusNumber = InputView.getBonusNumber();
        validateBonusNumber(bonusNumber);
    }

    private static void validatePurchaseAmount(String purchaseAmount) {
        int userPurchaseAmount;
        try {
            userPurchaseAmount = Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR + "구입금액을 숫자로 입력해주세요");
        }
        if (!isDivide(userPurchaseAmount, UNIT)) {
            throw new IllegalArgumentException(ERROR + UNIT + "원 단위로 구입이 가능합니다");
        }
    }

    private static boolean isDivide(int userPurchaseAmount, int unit) {
        if ((userPurchaseAmount % unit) == 0) {
            return true;
        }
        return false;
    }

    private static List<Lotto> publishLotto(int lottoCount) {
        List<Lotto> userLotto = new ArrayList<>();
        for (int count = 0; count < lottoCount; count++) {
            userLotto.add(createLotto());
        }
        return userLotto;
    }

    private static Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUM, END_NUM, COUNT_NUM);
        Collections.sort(numbers);
        Lotto lotto = new Lotto(numbers);
        return lotto;
    }


    private static void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != COUNT_NUM) {
            throw new IllegalArgumentException(ERROR + "당첨 번호 숫자는 6개입니다");
        }
//        if (isDuplicate(winningNumbers)) {
//            throw new IllegalArgumentException(ERROR + "당첨 번호에 중복된 숫자가 있습니다");
//        }
    }

    private static void validateBonusNumber(String bonusNumber) {
        if (bonusNumber.length() != 1) {
            throw new IllegalArgumentException(ERROR + "보너스 번호는 1개입니다");
        }
        if (isOutOfRange(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException(ERROR + "보너스 번호가 범위를 벗어났습니다");
        }
    }

    private static boolean isOutOfRange(int number) {
        if (number < 1 || number > 45) {
            return false;
        }
        return true;
    }
}
