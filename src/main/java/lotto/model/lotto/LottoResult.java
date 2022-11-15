package lotto.model.lotto;

import lotto.model.customer.Customer;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.Rank;

import java.util.*;
import java.util.stream.Collectors;

public class LottoResult {
    private final static int RANK_INITIAL_VALUE = 0;
    private final static int RANK_INCREMENT_VALUE = 1;

    private Map<Rank, Integer> rankResult = new HashMap<>();
    private Double rateOfReturn;

    public void create(List<Integer> winNumbers, int bonusNumber, Customer customer) {
        initRankResult();
        createRankResult(winNumbers, bonusNumber, customer);
        calculateRateOfReturn(customer);
    }

    private void createRankResult(List<Integer> winNumbers, int bonusNumber, Customer customer) {
        for (Lotto lotto : customer.getLottos()) {
            List<Integer> customerLottoNumbers = lotto.getNumbers();
            Set<Integer> intersection = findIntersection(winNumbers, customerLottoNumbers);
            plusRankResultIfWinner(bonusNumber, customerLottoNumbers, intersection);
        }
    }

    private int cntMoneySum() {
        int rorSum = 0;
        for (Map.Entry<Rank, Integer> e : rankResult.entrySet()) {
            Rank rank = e.getKey();
            int cnt = e.getValue();

            rorSum += rank.getPrizeMoney() * cnt;
        }
        return rorSum;
    }

    private void calculateRateOfReturn(Customer customer) {
        int moneySum = cntMoneySum();
        rateOfReturn = getRateOfReturn(customer, moneySum);
        rateOfReturn = roundToSecond(rateOfReturn);
    }

    private double getRateOfReturn(Customer customer, int moneySum) {
        return moneySum / (double) (customer.getCntOfLottos() * 1000) * 100;
    }

    private double roundToSecond(Double rateOfReturn) {
        return Math.round(rateOfReturn * 100) / 100.0;
    }

    private void initRankResult() {
        for (Rank rank : Rank.values()) {
            rankResult.put(rank, RANK_INITIAL_VALUE);
        }
    }

    private void plusRankResultIfWinner(int bonusNumber, List<Integer> customerLottoNumbers, Set<Integer> intersection) {
        for (Rank rank : Rank.values()) {
            if (isWinner(bonusNumber, customerLottoNumbers, intersection, rank)) {
                rankResult.put(rank, rankResult.getOrDefault(rank, RANK_INITIAL_VALUE) + RANK_INCREMENT_VALUE);
                break;
            }
        }
    }

    private boolean isWinner(int bonusNumber, List<Integer> customerLottoNumbers, Set<Integer> intersection, Rank rank) {
        if (intersection.size() == rank.getCntOfSameNumber()) {
            if (isSecondWinner(bonusNumber, customerLottoNumbers, rank)) {
                return true;
            }
            return true;
        }
        return false;
    }

    private boolean isSecondWinner(int bonusNumber, List<Integer> customerLottoNumbers, Rank rank) {
        return rank.equals(Rank.SECOND) && customerLottoNumbers.contains(bonusNumber);
    }

    private Set<Integer> findIntersection(List<Integer> winNumbers, List<Integer> customerLottoNumbers) {
        return winNumbers.stream()
                .distinct()
                .filter(customerLottoNumbers::contains)
                .collect(Collectors.toSet());
    }

    public Map<Rank, Integer> getRankResult() {
        return new HashMap<>(rankResult);
    }

    public Double getRateOfReturn() {
        return rateOfReturn;
    }
}
