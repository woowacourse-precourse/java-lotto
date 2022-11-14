package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Judgment {
    public enum Rank {
        FIRST("1등", 6, 2000000000),
        SECOND("2등", 6, 30000000),
        THIRD("3등", 5, 1500000),
        FOURTH("4등", 4, 50000),
        FIFTH("5등", 3, 5000);

        private final String ranking;
        private final int matchCount;
        private final int prizeMoney;

        Rank(String ranking, int matchCount, int prizeMoney) {
            this.ranking = ranking;
            this.matchCount = matchCount;
            this.prizeMoney = prizeMoney;
        }

        public String getRanking() {
            return ranking;
        }

        public int getMatchCount() {
            return matchCount;
        }

        public int getPrizeMoney() {
            return prizeMoney;
        }
    }

    List<List<Integer>> lottoNumbers;
    List<Integer> winningNumbers;
    int bonusNumber;
    HashMap<String, Integer> result = new LinkedHashMap<>();

    public Judgment(List<List<Integer>> lottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> result() {
        setResult();
        compare();
        referee();
        List<Integer> winningResult = new ArrayList<>(result.values());
        return winningResult;
    }

    private void setResult() {
        result.put(Rank.FIFTH.getRanking(), 0);
        result.put(Rank.FOURTH.getRanking(), 0);
        result.put(Rank.THIRD.getRanking(), 0);
        result.put(Rank.SECOND.getRanking(), 0);
        result.put(Rank.FIRST.getRanking(), 0);
    }

    private void compare() {
        List<Integer> combineNumber = new ArrayList<>(winningNumbers);
        combineNumber.add(bonusNumber);

        for (int i = 0; i < lottoNumbers.size(); i++) {
            lottoNumbers.get(i).retainAll(combineNumber);
        }
    }

    private void referee() {
        for (int i = 0; i < lottoNumbers.size(); i++) {
            if (lottoNumbers.get(i).size() == Rank.FIFTH.getMatchCount()) {
                result.put(Rank.FIFTH.getRanking(), result.get(Rank.FIFTH.getRanking()) + 1);
            }
            if (lottoNumbers.get(i).size() == Rank.FOURTH.getMatchCount()) {
                result.put(Rank.FOURTH.getRanking(), result.get(Rank.FOURTH.getRanking()) + 1);
            }
            if (lottoNumbers.get(i).size() == Rank.THIRD.getMatchCount()) {
                result.put(Rank.THIRD.getRanking(), result.get(Rank.THIRD.getRanking()) + 1);
            }
            if (lottoNumbers.get(i).size() == Rank.SECOND.getMatchCount() && isContainBonusNumber(lottoNumbers.get(i))) {
                result.put(Rank.SECOND.getRanking(), result.get(Rank.SECOND.getRanking()) + 1);
            }
            if (lottoNumbers.get(i).size() == Rank.FIRST.getMatchCount() && !isContainBonusNumber(lottoNumbers.get(i))) {
                result.put(Rank.FIRST.getRanking(), result.get(Rank.FIRST.getRanking()) + 1);
            }
        }
    }

    private boolean isContainBonusNumber(List<Integer> lottoNumber) {
        return lottoNumber.contains(bonusNumber);
    }

    public double calculateProfitRate(int money) {
        int totalPrizeMoney = 0;
        if (result.get(Rank.FIFTH.getRanking()) != 0) {
            totalPrizeMoney += result.get(Rank.FIFTH.getRanking()) * Rank.FIFTH.getPrizeMoney();
        }
        if (result.get(Rank.FOURTH.getRanking()) != 0) {
            totalPrizeMoney += result.get(Rank.FOURTH.getRanking()) * Rank.FOURTH.getPrizeMoney();
        }
        if (result.get(Rank.THIRD.getRanking()) != 0) {
            totalPrizeMoney += result.get(Rank.THIRD.getRanking()) * Rank.THIRD.getPrizeMoney();
        }
        if (result.get(Rank.SECOND.getRanking()) != 0) {
            totalPrizeMoney += result.get(Rank.SECOND.getRanking()) * Rank.SECOND.getPrizeMoney();
        }
        if (result.get(Rank.FIRST.getRanking()) != 0) {
            totalPrizeMoney += result.get(Rank.FIRST.getRanking()) * Rank.FIRST.getPrizeMoney();
        }
        double profitRate = (double)totalPrizeMoney / money * 100;
        return profitRate;
    }
}