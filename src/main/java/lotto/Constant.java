package lotto;

public class Constant {
    public static String NUMBER_REGEX = "^[0-9]*$";

    public static Integer LOTTO_PRICE = 1000;
    public static Integer LOTTO_DIGIT_CNT = 6;
    public static Integer BALL_MIN_RANGE = 1;
    public static Integer BALL_MAX_RANGE = 45;
    public static Integer MIN_LOTTO_CNT_PURCHASED = 1;

    /**
     * NUMBER_CONVENTION : 숫자 표기 규칙을 나타내는 Pattern입니다
     * 세 자리마다 콤마를 찍고, 소수점은 첫 째 자리까지 표기합니다
     */
    public static String NUMBER_CONVENTIONS = "###,###.#";
}
