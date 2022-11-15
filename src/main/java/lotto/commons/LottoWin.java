package lotto.commons;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoWin {

    private static final Map<String, Integer> winHistory = new HashMap<>();
    private static List<Integer> numbers;
    private static int bonus;

    public LottoWin(List<Integer> winNumbers, int bounusNumber) {
        numbers = winNumbers;
        bonus = bounusNumber;
        this.setWinHistory();
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

    public void updateWinHistory(String win) {
        winHistory.put(win, winHistory.get(win) + 1);
    }

    public int getWinHistoryValue(int rank) throws IllegalArgumentException {
        validateRank(rank);

        String win = "";
        if (rank == 1) {
            win = "FIRST_WIN";
        } else if (rank == 2) {
            win = "SECOND_WIN";
        } else if (rank == 3) {
            win = "THIRD_WIN";
        } else if (rank == 4) {
            win = "FIRTH_WIN";
        } else if (rank == 5) {
            win = "FIFTH_WIN";
        }
        return winHistory.get(win);
    }

    private void validateRank(int rank) {
        if (rank < 1 || 5 < rank) {
            throw new IllegalArgumentException("[ERROR] 5등 안에 들지 못했습니다.");
        }
    }

}
