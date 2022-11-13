package domain;

import java.util.HashMap;

public class MatchingNumber {
    private HashMap<String,Integer> correctnumber = new HashMap<>();

    public MatchingNumber(HashMap<String, Integer> correctnumber) {
        this.correctnumber = correctnumber;
    }

    public HashMap<String,Integer> getMatchingNumber() {
        return correctnumber;
    }
}
