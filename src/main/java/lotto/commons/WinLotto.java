package lotto.commons;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinLotto {

    private static Map<String, Integer> winHistory = new HashMap<>();
    private static long winning;
    private static List<Integer> numbers;
    private static int bonus;

    public WinLotto(List<Integer> winNumbers, int bonusNumber) {
        numbers = winNumbers;
        bonus = bonusNumber;
        winning = 0;
        setWinHistory();
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
        if (rank.equals("")) {
            return;
        }
        validateRank(rank);
        int count = winHistory.get(rank);
        winHistory.put(rank, count + 1);
        updateWinning(moneyByRank((rank)));
    }

    private void validateRank(String rank) throws IllegalArgumentException {
        boolean isRank = false;
        if (rank.equals("FIRST_WIN") || rank.equals("SECOND_WIN") || rank.equals("THIRD_WIN")
                || rank.equals("FIRTH_WIN") || rank.equals("FIFTH_WIN")) {
            isRank = true;
        }
        if (!isRank) {
            throw new IllegalArgumentException("[ERROR] 랭크가 아닙니다.");
        }
    }

    public void updateWinning(long money) {
        winning += money;
    }


    private long moneyByRank(String rank) {
        return RankMoney.valueOf(rank).getMoney();
    }

}
