package lotto.domain;

import java.util.function.Function;

public enum LottoProperties {
    LOTTO_WINNER(value->value),
    LOTTO_SECONDWINNER(value->value),
    LOTTO_THIRDWINNER(value->value),
    LOTTO_FOURTHWINNER(value->value);
    private Function<Long,Long> expression;
    LottoProperties(Function<Long, Long> expression) { this.expression=expression;}

}
