package lotto.constant;

/**
 * 로또 시스템 전체에서 사용되는 상수를 관리합니다
 */
public class LottoConstants {
    /**
     * 로또 하나당 가격을 의미합니다
     */
    public static final int LOTTO_PRICE = 1000;
    /**
     * 로또 시작 번호를 의미합니다
     */
    public static final int LOTTO_START_INCLUSIVE = 1;
    /**
     * 로또 끝 번호를 의미합니다
     */
    public static final int LOTTO_END_INCLUSIVE = 45;
    /**
     * 로또 숫자들의 수를 의미합니다
     */
    public static final int LOTTO_LENGTH = 6;

    private LottoConstants() {
    }
}
