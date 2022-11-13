package lotto.domain;

import java.util.Map;

public class Result {
    public Map result;
    public double yield;

    Result(Map result, double yield) {
        this.result = result;
        this.yield = yield;
    }
}
