package lotto.domain;

import java.util.Map;

public class Result {
    public Map resultMap;
    public double yield;

    Result(Map resultMap, double yield) {
        this.resultMap = resultMap;
        this.yield = yield;
    }
}
