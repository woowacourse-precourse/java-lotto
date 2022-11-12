package lotto;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.HashMap;

import camp.nextstep.edu.missionutils.Randoms;

public class Model {

    public List<Integer> checkLottoNumber (List<Integer> lottoNumbers, List<List<Integer>> usersLottos) {
        List<Integer> duplicatedNumbers = new ArrayList<>();

        for (List<Integer> lotto: usersLottos){
            List<Integer> comparingNumbers = lotto.stream()
                    .filter(lottoNumbers::contains)
                    .collect(Collectors.toList());

                duplicatedNumbers.add(comparingNumbers.size());
            }

        return duplicatedNumbers;
    }

    public HashMap<Integer, Integer> checkPrizeLotto (List<Integer> duplicatedNumbers, List<List<Integer>> usersLottos, int bonusNumber) {
        List<Integer> prizeRankings = new ArrayList<>();

        for (int number: duplicatedNumbers) {
            prizeRankings.add(addPrizeRanking(number));
        }

        checkBonusNumber(prizeRankings, usersLottos, bonusNumber);

        return makeNumberByRanking(prizeRankings);
    }

    private HashMap<Integer, Integer> makeNumberByRanking (List<Integer> prizeRankings) {
        HashMap<Integer, Integer> numberByRanking = new HashMap<>();

        for (int temp = Ranking.FIRST.getRanking(); temp <= Ranking.FIFTH.getRanking(); temp++) {
            numberByRanking.put(temp, 0);
        }

        inputNumberByRanking(prizeRankings, numberByRanking);
        return numberByRanking;
    }

    private void checkBonusNumber(List<Integer> prizeRankings, List<List<Integer>> usersLottos, int bonusNumber){
        int changedRanking;

        for (int temp = 0; temp < prizeRankings.size(); temp++) {

            if (prizeRankings.get(temp) == Ranking.THIRD.getRanking()) {
                changedRanking = upRanking(usersLottos.get(temp), bonusNumber);
                prizeRankings.set(temp, changedRanking);
            }
        }
    }

    private int upRanking (List<Integer> usersLottos, int bonusNumber) {
        if (usersLottos.contains(bonusNumber)) {
            return Ranking.SECOND.getRanking();
        }
        return Ranking.THIRD.getRanking();
    }

    private void inputNumberByRanking (List<Integer> prizeRankings, HashMap<Integer, Integer> numberByRanking) {

        for (int ranking: prizeRankings) {
            if (ranking > 0) {
                numberByRanking.put(ranking, numberByRanking.get(ranking) + 1);
            }
        }
    }

    private int addPrizeRanking(int duplicatedNumber) {
        if (duplicatedNumber == 3) return Ranking.FIFTH.getRanking();
        if (duplicatedNumber == 4) return Ranking.FORTH.getRanking();
        if (duplicatedNumber == 5) return Ranking.THIRD.getRanking();
        if (duplicatedNumber == 6) return Ranking.FIRST.getRanking();
        return 0;
    }

    public double calculateRateOfProfit (HashMap<Integer, Integer> prizeRankings, int money) {
        int totalProfit = 0;

        for (int ranking: prizeRankings.keySet()) {
            totalProfit += profitByRanking(ranking, prizeRankings.get(ranking));
        }

        return (double)totalProfit / money;
    }

    public int profitByRanking (int ranking, int numberOfRanking) {
        if (ranking == 1) return Prize.FIRST.getPrize() * numberOfRanking;
        if (ranking == 2) return Prize.SECOND.getPrize() * numberOfRanking;
        if (ranking == 3) return Prize.THIRD.getPrize() * numberOfRanking;
        if (ranking == 4) return Prize.FORTH.getPrize() * numberOfRanking;
        if (ranking == 5) return Prize.FIFTH.getPrize() * numberOfRanking;
        return 0;
    }

    public List<List<Integer>> repeatGettingLottoNumber(int moneyNumber) {
        List<List<Integer>> usersLottos = new ArrayList<>();

        for (int temp = 0; temp < moneyNumber; temp++) {
            usersLottos.add(getLottoNumber());
        }

        return usersLottos;
    }

    private List<Integer> getLottoNumber() {
        List<Integer> lottoNumbers = new ArrayList<>
                (Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }

    private enum Prize {
        FIRST(2_000_000),
        SECOND(30_000),
        THIRD(1_500),
        FORTH(50),
        FIFTH(5);

        final private int prize;
        private int getPrize() {
            return prize;
        }
        Prize(int prize) {
            this.prize = prize;
        }
    }

    public enum Ranking {
        FIRST(1),
        SECOND(2),
        THIRD(3),
        FORTH(4),
        FIFTH(5);

        final private int ranking;
        private int getRanking() {
            return ranking;
        }
        Ranking(int ranking) {
            this.ranking = ranking;
        }
    }
}
