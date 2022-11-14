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
}
