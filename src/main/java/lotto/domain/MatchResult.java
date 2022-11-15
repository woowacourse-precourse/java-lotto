package lotto.domain;

import lotto.abstraction.PrintInterface;

public class MatchResult implements PrintInterface {

    @Override
    public String printResult() {
        return new History().getMatchResult();
    }
}
