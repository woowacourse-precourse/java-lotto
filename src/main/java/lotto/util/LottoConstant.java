package lotto.util;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/14
 */
public enum LottoConstant {
    MATCH_NUMBER_FIRST_GRADE(6)     // 1등 당첨을 위해 맞춰야 하는 숫자 개수
    ,MATCH_NUMBER_THIRD_GRADE(5)    // 3등 당첨을 위해 맞춰야 하는 숫자 개수 - 추가: 2등은 3등 숫자 개수 + 보너스 점수
    ,MATCH_NUMBER_FOURTH_GRADE(4)   // 4등 당첨을 위해 맞춰야 하는 숫자 개수
    ,MATCH_NUMBER_FIFTH_GRADE(3)    // 5등 당첨을 위해 맞춰야 하는 숫자 개수
    ,LOTTO_PRIZE_MONEY_FIRST_GRADE(2_000_000_000)   // 1등 당첨 금액
    ,LOTTO_PRIZE_MONEY_SECOND_GRADE(30_000_000)     // 2등 당첨 금액
    ,LOTTO_PRIZE_MONEY_THIRD_GRADE(1_500_000)       // 3등 당첨 금액
    ,LOTTO_PRIZE_MONEY_FOURTH_GRADE(50_000)         // 4등 당첨 금액
    ,LOTTO_PRIZE_MONEY_FIFTH_GRADE(5_000)           // 5등 당첨 금액
    ,LOTTO_RANGE_MIN(1)     // 로또 번호 범위 중 작은 값
    ,LOTTO_RANGE_MAX(45)    // 로또 번호 범위 중 큰 값
    ,LOTTO_LENGTH(6)        // 로또 번호 개수
    ,LOTTO_PRICE(1000)      // 로또 가격
    ;
    private final int value;

    LottoConstant(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    public String getString() {
        return String.format("%,d", value);
    }
}
