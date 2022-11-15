package lotto.constant;

import java.util.function.BiFunction;
import java.util.function.Function;

public enum Result {
    THREE_MATCH("3개 일치 (5,000원) - "),
    FOUR_MATCH("4개 일치 (50,000원) - "),
    FIVE_MATCH("5개 일치 (1,500,000원) - "),
    FIVE_BONUS_MATCH("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX_MATCH("6개 일치 (2,000,000,000원) - "),
    COUNT("개"),
    PROFIT_RATE("총 수익률은 "),
    IS("입니다.");

    private final String value;

    Result(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
