package lotto.dto;

import java.util.HashMap;

public class ResultResponse {
    private final HashMap<Integer, Integer> result;

    public ResultResponse(HashMap<Integer, Integer> result) {
        this.result = result;
    }

    public HashMap<Integer, Integer> getResult() {
        return result;
    }
}
