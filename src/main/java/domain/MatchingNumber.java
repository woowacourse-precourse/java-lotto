package domain;

import java.util.HashMap;

public class MatchingNumber {
    private final HashMap<String,Integer> correctNumber;

    public MatchingNumber(HashMap<String, Integer> correctNumber) {
        this.correctNumber = correctNumber;
    }

    public HashMap<String,Integer> getMatchingNumber() {
        return correctNumber;
    }
}
