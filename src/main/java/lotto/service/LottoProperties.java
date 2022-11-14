package lotto.service;

import java.util.Arrays;
import java.util.function.Function;

public enum LottoProperties {
    LOTTO_WINNER(6,correct->0),
    LOTTO_THIRDWINNER(5,correct->2),
    LOTTO_FOURTHWINNER(4,correct->3),
    LOTTO_FIFTHWINNER(3,correct->4),
    LOTTO_LOOSE(-1,correct->5);
    int operator;
    Function<Integer,Integer> expression;

    LottoProperties(int operator,Function<Integer,Integer> expression) {
        this.operator=operator;
        this.expression = expression;
    }
    public static LottoProperties findType(int correct){
        return Arrays.stream(LottoProperties.values())
                .filter(type -> type.operator==correct)
                .findFirst()
                .orElse(LottoProperties.LOTTO_LOOSE);
    }
    public int function(int correct){
        return this.expression.apply(correct);
    }
}
