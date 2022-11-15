package lotto.domain;

import lotto.abstraction.PrintInterface;

public class YieldResult implements PrintInterface {
    @Override
    public String printResult() {
        return new History().getYieldResult();
    }
}
