package lotto.service;

public class LottoGameService {

    private static final int A_LOTTO_PRICE = 1000;
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private static final String LOTTO_PURCHASE_AMOUNT_DIVIDE_REST_EXCEPTION_MESSAGE = "로또 구입 금액은 1,000원으로 나누어 떨어져야합니다.";

    public int getLottoIssueCount(String lottoPurchaseAmount) {
        validateLottoIssueCount(lottoPurchaseAmount);
        return Integer.parseInt(lottoPurchaseAmount) / A_LOTTO_PRICE;
    }

    public void validateLottoIssueCount(String lottoPurchaseAmount) {
        if (isRestOfLottoPurchaseAmountDivideBy1000NotZero(lottoPurchaseAmount)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + LOTTO_PURCHASE_AMOUNT_DIVIDE_REST_EXCEPTION_MESSAGE);
        }
    }

    private boolean isRestOfLottoPurchaseAmountDivideBy1000NotZero(String lottoPurchaseAmount) {
        return Integer.parseInt(lottoPurchaseAmount) % A_LOTTO_PRICE != 0;
    }
}
