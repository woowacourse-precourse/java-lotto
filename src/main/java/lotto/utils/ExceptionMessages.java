package lotto.utils;

public class ExceptionMessages {
    public static String PAYMENT_ONLY_NUMBER = "[ERROR] 구입 금액은 숫자만 올 수 있습니다.";
    public static String PAYMENT_ONLY_ONE_THOUSAND_UNIT = "[ERROR] 구입 금액은 천원 단위만 가능합니다.";
    public static String LOTTO_ONLY_SIX_SIZE = "[ERROR] 로또는 6개의 숫자로만 이루어집니다.";
    public static String LOTTO_ONLY_UNIQUE_NUMBERS = "[ERROR] 로또에는 중복된 숫자가 올 수 없습니다.";
    public static String LOTTO_OUT_OF_RANGE = "[ERROR] 로또 숫자는 1~45까지만 가능합니다.";
    public static String LOTTO_ONLY_NUMBERS = "[ERROR] 로또 번호는 숫자만 가능합니다.";
    public static String WINNING_NUMBER_HAS_SIX_ELEMENT = "[ERROR] 당첨번호는 쉽표로 구분된 6개의 숫자입니다.";
    public static String BONUS_NUMBER_DUPLICATE = "[ERROR] 보너스 번호는 당첨번호와 중복되지 않는 숫자만 가능합니다.";
}
