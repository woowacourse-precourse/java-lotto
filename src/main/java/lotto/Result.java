package lotto;

import java.util.HashMap;
import java.util.Map;

public class Result {

    private int prize;
    private Map<Rank, Integer> result;

    public Result() {
        this.prize = 0;
        this.result = new HashMap<>();
    }
}
