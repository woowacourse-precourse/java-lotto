package lotto.commons;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinLotto {

    private static final Map<String, Integer> winHistory = new HashMap<>();
    private static long winning;
    private static List<Integer> numbers;
    private static int bonus;

    public WinLotto(List<Integer> winNumbers, int bonusNumber) {
        numbers = winNumbers;
        bonus = bonusNumber;
        winning = 0;
        this.setWinHistory();
    }

    public Map<String, Integer> getWinHistory() {
        return winHistory;
    }

    public long getWinning() {
        return winning;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonus() {
        return bonus;
    }

    public void setWinHistory() {
        winHistory.put("FIRST_WIN", 0);
        winHistory.put("SECOND_WIN", 0);
        winHistory.put("THIRD_WIN", 0);
        winHistory.put("FIRTH_WIN", 0);
        winHistory.put("FIFTH_WIN", 0);
    }

    public void updateWinHistory(String rank) {
        winHistory.put(rank, winHistory.get(rank) + 1);
        updateWinning(moneyByRank((rank)));
    }

    public void updateWinning(long money) {
        winning += money;
    }


    private long moneyByRank(String rank) {
        if (rank.equals("FIRST_WIN")) {
            return 2000000000;
        } else if (rank.equals("SECOND_WIN")) {
            return 30000000;
        } else if (rank.equals("THIRD_WIN")) {
            return 1500000;
        } else if (rank.equals("FIRTH_WIN")) {
            return 50000;
        } else if (rank.equals("FIFTH_WIN")) {
            return 5000;
        }
        return 0;
    }

}
