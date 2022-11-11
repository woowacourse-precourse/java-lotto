package lotto;

import java.util.HashMap;
import java.util.Map;

public class WinningCount {
    private Map<String, Integer> count;

    public WinningCount() {
        count = new HashMap<>();
        count.put("3", 0);
        count.put("4", 0);
        count.put("5", 0);
        count.put("6", 0);
        count.put("bonus", 0);
    }

    public Map<String, Integer> getCount() {
        return count;
    }

    public void addWinningResult(String str, boolean bonusCheck) {
        if (bonusCheck && str == "5") {
            count.put("bonus", count.get("bonus"));
            return;
        }
        if (count.containsKey(str)) {
            count.put(str, count.get(str) + 1);
        }
    }


}
