package lotto;

import java.io.*;
import java.util.*;

public class Result {
    private Map<Rank, Integer> history = new HashMap<>();
    private float totalEarningsRate;

    public Result() {
        Rank[] rank = Rank.values();
        for (Rank r : rank) {
            history.put(r, 0);
        }
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
            printPerRank(bw);
            bw.write("총 수익률은 " + totalEarningsRate + "%입니다.\n");
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void printPerRank(BufferedWriter bw) throws IOException {
        Rank[] rank = Rank.values();
        for (Rank r : rank) {
            if (r.equals(Rank.FAIL)) {
                continue;
            }
            bw.write(r.getMessage() + history.get(r) + "개\n");
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
