package lotto.domain;

public abstract class ErrorMessage {
    public static final String NUMBER_FORMAT_ERROR_MESSAGE = "숫자를 입력해야 합니다.";

    public static final String LOTTO_PURCHASE_MONEY_ERROR_MESSAGE = "티켓은 " + LottoPurchaseMoney.LOTTO_PRICE + "원 입니다. " + LottoPurchaseMoney.LOTTO_PRICE + "원 단위로 입력해야 합니다.";

    public static final String LOTTO_NUMBER_RANGE_ERROR_MESSAGE = "로또 번호는 " + Lotto.MINIMUM_NUMBER + "부터 " + Lotto.MAXIMUM_NUMBER+ " 사이의 숫자여야 합니다.";
    public static final String LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE = "로또 번호는 서로 중복되지 않아야 합니다.";
    public static final String LOTTO_NUMBERS_SIZE_ERROR_MESSAGE = "로또 번호의 개수는 " + Lotto.NUMBERS_SIZE +"개여야 합니다.";

    public static final String BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE = "보너스 번호는 당첨 번호와 중복되지 않아야 합니다.";
}
