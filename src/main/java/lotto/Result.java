package lotto;

import java.io.*;
import java.util.*;

public class Result {
    private Map<Rank, Integer> history = new HashMap<>();
    private float totalEarningsRate;

    public Result() {
        history.put(Rank.FIRST, 0);
        history.put(Rank.SECOND, 0);
        history.put(Rank.THIRD, 0);
        history.put(Rank.FOURTH, 0);
        history.put(Rank.FIFTH, 0);
        history.put(Rank.FAIL, 0);
    }

    public void add(Rank rank) {
        history.put(rank, history.get(rank) + 1);
    }

    public void showHistory() {
        setTotalEarningsRate();
        printHistory();
    }

    private void printHistory() {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            bw.write("당첨 통계\n");
            bw.write("---\n");
            for (Rank r : history.keySet()) {
                bw.write(r.getMessage() + history.get(r) + "개\n");
            }
            bw.write("총 수익률은 " + totalEarningsRate + "%입니다.\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void setTotalEarningsRate() {
        float investedMoney = history.size() * 1_000;
        totalEarningsRate = (int) (getTotalWinningMoney() / investedMoney * 10) / 10f;
    }

    private long getTotalWinningMoney() {
        long totalWinningMoney = 0;
        for (Rank r : history.keySet()) {
            totalWinningMoney += history.get(r) * (long) r.getMoney();
        }
        return totalWinningMoney;
    }


}
