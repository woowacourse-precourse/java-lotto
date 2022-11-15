package lotto;

import static lotto.Money.MONEY_PER_LOTTO;

public class ExceptionCode {

    public static final String INVALID_LOTTO_SIZE = "[ERROR] 로또는 "
            + Lotto.LOTTO_SIZE
            + "개의 서로 다른 숫자를 입력해야 합니다.";
    public static final String INVALID_LOTTO_NUMBER_RANGE = "[ERROR] 로또 숫자 범위는 "
            + LottoNumber.LOWER_BOUND
            + "부터 "
            + LottoNumber.UPPER_BOUND
            + "까지여야 합니다.";

    public static final String INVALID_MONEY_PER_LOTTO = "[Error] 로또 구입금액은 "
            + MONEY_PER_LOTTO
            + "원 이상이어야 합니다";
}
