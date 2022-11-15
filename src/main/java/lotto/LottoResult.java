package lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LottoResult {

    private final Map<Rank, Integer> result = new HashMap<>();

    public LottoResult() {
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }

    public void putRank(Rank rank) {
        result.put(rank, result.get(rank) + 1);
    }

    public Long getReward() {
        return result.entrySet().stream().mapToLong(e -> e.getKey().prize(e.getValue())).sum();
    }

    @Override
    public String toString() {
        return getReversedOutputString();
    }

    private String getReversedOutputString() {
        Stack<String> reversedOutput = getReversedOutput();
        StringBuilder resultString = new StringBuilder();
        while (!reversedOutput.isEmpty()) {
            resultString.append(reversedOutput.pop());
        }
        return resultString.toString();
    }

    private Stack<String> getReversedOutput() {
        Stack<String> reversedOutput = new Stack<>();
        for (Rank rank : Rank.values()) {
            if (rank.equals(Rank.MISS)) {
                break;
            }
            reversedOutput.push(rank.print(result.get(rank)));
        }
        return reversedOutput;
    }
}
