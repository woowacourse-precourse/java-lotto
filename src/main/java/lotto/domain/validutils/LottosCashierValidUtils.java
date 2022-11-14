package lotto.domain.validutils;

import lotto.domain.LottosCashier;

import java.util.List;

public class LottosCashierValidUtils {

    public static final String ERROR_NOT_VALID_PRICE = "[ERROR] 구입 금액은 1000으로 나누어 떨어져야 합니다.";
    public static final String ERROR_PRICE_COUNT_NOT_EQUAL_LOTTO_SIZE = "[ERROR] 주어진 금액과 주어진 로또 번호의 개수가 일치하지 않습니다.";
    public static final int CRITERION_ZERO = 0;

    private LottosCashierValidUtils() {
    }

    public static void validateCanPurchase(int purchasePrice) {
        if (!isDivided(purchasePrice)) {
            throw new IllegalArgumentException(ERROR_NOT_VALID_PRICE);
        }
    }

    private static boolean isDivided(int purchasePrice) {
        return ((purchasePrice % LottosCashier.LOTTO_PRICE) == CRITERION_ZERO);
    }

    public static void validateSize(int buyLottoCount, List<List<Integer>> lottoNumbers) {
        if (!isSame(buyLottoCount, lottoNumbers.size())) {
            throw new IllegalArgumentException(ERROR_PRICE_COUNT_NOT_EQUAL_LOTTO_SIZE);
        }
    }

    private static boolean isSame(int count, int lottoNumbersSize) {
        return count == lottoNumbersSize;
    }
}
