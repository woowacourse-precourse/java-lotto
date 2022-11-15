package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class LottoResult {

    private Map<Rank, Integer> rankResult = new HashMap<>();
    private Double rateOfReturn;

    public void create(List<Integer> winNumbers, int bonusNumber, Customer customer) {
        for (Rank rank : Rank.values()) {
            rankResult.put(rank, 0);
        }

        for (Lotto lotto : customer.getLottos()) {
//            Set<Integer> intersection = new HashSet<>(winNumbers);
            List<Integer> customerLottoNumbers = lotto.getNumbers();
//            intersection.removeAll(customerLottoNumbers);

            Set<Integer> intersection = winNumbers.stream()
                    .distinct()
                    .filter(customerLottoNumbers::contains)
                    .collect(Collectors.toSet());

            for (Rank rank : Rank.values()) {
                if (intersection.size() == rank.getCntOfSameNumber()) {
                    if (rank.equals(Rank.SECOND) && customerLottoNumbers.contains(bonusNumber)) {
                        rankResult.put(rank, rankResult.getOrDefault(rank, 0) + 1);
                        break;
                    }
                    rankResult.put(rank, rankResult.getOrDefault(rank, 0) + 1);
                    break;
                }
            }
        }

        int rorSum = 0;
        for (Map.Entry<Rank, Integer> e : rankResult.entrySet()) {
            Rank rank = e.getKey();
            int cnt = e.getValue();

            rorSum += rank.getPrizeMoney() * cnt;
        }

        rateOfReturn = rorSum / (double) (customer.getCntOfLottos() * 1000) * 100;
        rateOfReturn = Math.round(rateOfReturn * 100) / 100.0;
    }

    public Map<Rank, Integer> getRankResult() {
        return new HashMap<>(rankResult);
    }

    public Double getRateOfReturn() {
        return rateOfReturn;
    }
}
