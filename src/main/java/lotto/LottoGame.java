package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LottoGame {

    private final int price;
    private final List<Lotto> lottoList;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    private final HashMap<Integer, Rank> rankHashMap = new HashMap<>() {{
        put(6, Rank.First);
        put(5, Rank.Third);
        put(4, Rank.Fourth);
        put(3, Rank.Fifth);
    }};

    public LottoGame(int price, List<Lotto> lottoList, List<Integer> winningNumbers, int bonusNumber) {
        this.price = price;
        this.lottoList = lottoList;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Rank getRank(Lotto lotto) {
        int count = 0;
        for (Integer number : lotto.getNumbers()) {
            if (this.winningNumbers.contains(number)) {
                count++;
            }
        }
        if (count == 5 && lotto.getNumbers().contains(bonusNumber)) {
            return Rank.Second;
        }
        return rankHashMap.get(count);
    }

    public List<Rank> getStatistics() {
        List<Rank> statistics = new ArrayList<>();
        for (Lotto lotto : lottoList) {
            if (getRank(lotto) != null) {
                statistics.add(getRank(lotto));
            }
        }
        return new ArrayList<>(statistics);
    }

    public Double getEarnPriceRate() {
        List<Rank> statistics = getStatistics();
        double sumReward = 0.0;
        for (Rank rank : statistics) {
            if (rank != null) {
                sumReward += rank.getReward();
            }
        }
        double rate = ((sumReward / this.price) * 100) / 100.0;
        return rate * 100;
    }

    public List<Lotto> getSortedLottoList() {
        List<Lotto> sortedLottoList = new ArrayList<>();
        for (Lotto lotto : this.lottoList) {
            ArrayList<Integer> sortedList = new ArrayList<>(lotto.getNumbers());
            Collections.sort(sortedList);
            sortedLottoList.add(new Lotto(sortedList));
        }
        return sortedLottoList;
    }
}
