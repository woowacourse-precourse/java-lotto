package domain;

import java.util.HashMap;

public class Result {
    private final HashMap<String, Integer> winningResult;

    public Result(HashMap<String, Integer> winningResult) {
        this.winningResult = winningResult;
    }

    public HashMap<String, Integer> getWinningResult() {
        return winningResult;
    }

}
