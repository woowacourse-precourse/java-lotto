package lotto.model;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.HashMap;

import camp.nextstep.edu.missionutils.Randoms;

public class Model {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    public List<List<Integer>> USERS_LOTTOS;
    public HashMap <Integer, Integer> PRIZE_RANKINGS;
    private int MONEY;
    private int BONUS_NUMBER;

    public HashMap<Integer, Integer> checkPrize(int money, int bonusNumber, List<Integer> lottoNumbers) {
        this.MONEY = money;
        this.BONUS_NUMBER = bonusNumber;
        checkLottoNumber(lottoNumbers);

        return PRIZE_RANKINGS;
    }

    public double getRateOfProfit () {
        return calculateRateOfProfit(MONEY);
    }

    public List<List<Integer>> getUsersLottos (int money) {
        repeatGettingLottoNumber(money);

        return this.USERS_LOTTOS;
    }

    public void checkLottoNumber (List<Integer> lottoNumbers) {
        List<Integer> duplicatedNumbers = new ArrayList<>();

        for (List<Integer> lotto: USERS_LOTTOS){
            List<Integer> comparingNumbers = lotto.stream()
                    .filter(lottoNumbers::contains)
                    .collect(Collectors.toList());

                duplicatedNumbers.add(comparingNumbers.size());
            }

        checkPrizeLotto(duplicatedNumbers);
    }

    public void checkPrizeLotto (List<Integer> duplicatedNumbers) {
        List<Integer> prizeRankings = new ArrayList<>();

        for (int number: duplicatedNumbers) {
            prizeRankings.add(addPrizeRanking(number));
        }

        checkBonusNumber(prizeRankings);

        PRIZE_RANKINGS = makeNumberByRanking(prizeRankings);
    }

    private void checkBonusNumber(List<Integer> prizeRankings){
        int changedRanking;

        for (int temp = 0; temp < prizeRankings.size(); temp++) {

            if (prizeRankings.get(temp) == Ranking.THIRD.getRanking()) {
                changedRanking = upRanking(USERS_LOTTOS.get(temp), BONUS_NUMBER);
                prizeRankings.set(temp, changedRanking);
            }
        }
    }

    private HashMap<Integer, Integer> makeNumberByRanking (List<Integer> prizeRankings) {
        HashMap<Integer, Integer> numberByRanking = new HashMap<>();

        for (int temp = Ranking.FIRST.getRanking(); temp <= Ranking.FIFTH.getRanking(); temp++) {
            numberByRanking.put(temp, 0);
        }

        inputNumberByRanking(prizeRankings, numberByRanking);

        return numberByRanking;
    }

    private int upRanking (List<Integer> usersLotto, int bonusNumber) {
        if (usersLotto.contains(bonusNumber)) {
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

    public double calculateRateOfProfit (int money) {
        int totalProfit = 0;

        for (int ranking: PRIZE_RANKINGS.keySet()) {
            totalProfit += profitByRanking(ranking, PRIZE_RANKINGS.get(ranking));
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

    public void repeatGettingLottoNumber(int moneyNumber) {
        List<List<Integer>> usersLottos = new ArrayList<>();

        for (int temp = 0; temp < moneyNumber; temp++) {
            usersLottos.add(getLottoNumber());
        }

        USERS_LOTTOS = usersLottos;
    }

    private List<Integer> getLottoNumber() {
        List<Integer> lottoNumbers = new ArrayList<>
                (Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE));
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
