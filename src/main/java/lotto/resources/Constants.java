package lotto.resources;

public enum Constants {

    ERROR_CASE(-1),
    CORRECT_CASE(1),
    FROM(1),
    TO(45),
    LOTTO_LENGTH(6),
    BONUS_LOTTO_SIZE(2),
    CURRENCY(1000),
    ZERO(0),
    BONUS_INDEX(5),
    BONUS_EXIST(1),
    RANK_START(3),
    ONE(1),
    HUNDRED(100),
    COMMA_NUMBER(5);

    private final Integer s;
    Constants(int s) { this.s = s;}

    public Integer getValue() {
        return s;
    }

}
