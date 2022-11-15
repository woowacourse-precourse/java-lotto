package lotto.domain;

import java.util.function.Function;

public enum BonusType {
    No_Matter(noMatterBonusMatchingOrNot -> true),
    Should_Matching(isBonusMatching -> isBonusMatching.equals(true)),
    Should_Not_Matching(isBonusMatching -> isBonusMatching.equals(false));

    private Function<Boolean, Boolean> expression;

    BonusType(Function<Boolean,Boolean> expression) {
        this.expression = expression;
    }

    public boolean filter(boolean isBonusMatching) {
        return expression.apply(isBonusMatching);
    }
}
