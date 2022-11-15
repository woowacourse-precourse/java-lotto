package lotto.exception;

import static lotto.domain.Money.MONEY_PER_LOTTO;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class ExceptionCode {

    public static final String INVALID_LOTTO_SIZE = "[ERROR] 로또는 "
            + Lotto.LOTTO_SIZE
            + "개의 서로 다른 숫자를 입력해야 합니다.";
    public static final String INVALID_LOTTO_NUMBER_RANGE = "[ERROR] 로또 숫자 범위는 "
            + LottoNumber.LOWER_BOUND
            + "부터 "
            + LottoNumber.UPPER_BOUND
            + "까지여야 합니다.";
    public static final String INVALID_MONEY_PER_LOTTO = "[ERROR] 로또 구입금액은 "
            + MONEY_PER_LOTTO
            + "원 이상이어야 합니다";
    public static final String INVALID_MONEY_INPUT = "[ERROR] 구입 금액 입력 오류";
    public static final String INVALID_WINNING_NUMBER_INPUT = "[ERROR] 당첨 번호 입력 오류";
    public static final String INVALID_BONUS_NUMBER_INPUT = "[ERROR] 보너스 번호 입력 오류";
    public static final String ALREADY_PICKED_BONUS_NUMBER = "[ERROR] 당첨 로또 번호에 이미 있는 보너스 번호 입니다.";
}
