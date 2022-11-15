package lotto;

public class ERROR {
    static final String PURCHASE_INPUT = "[ERROR] 구입금액은 숫자를 입력해야 합니다.";
    static final String PURCHASE_DIVIDE =
            "[ERROR] 구입 금액은 " + Application.lottoPriceString + "원으로 나누어 떨어지는 자연수여야 합니다.";
    static final String LOTTO_NUMBERS =
            "[ERROR] 로또 번호는 1 ~ 45 사이의 중복되지 않는 6자리 자연수여야 합니다.";
    static final String BONUS_NUMBER =
            "[ERROR] 보너스 번호는 1 ~ 45 사이의 로또 번호와 중복되지 않는 1자리 자연수여야 합니다.";
}