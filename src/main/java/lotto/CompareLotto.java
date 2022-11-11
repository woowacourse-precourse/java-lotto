package lotto;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompareLotto {
    private final Map<Rank, Integer> rankMap;
    private final int originalMoney;

    public CompareLotto(LottoList lottoList, Lotto lotto_1st, int bonusNumbers) {
        this.rankMap = createRankMap();
        this.originalMoney = 1000 * lottoList.getLottoList().size();

        lottoList.getLottoList()
                .forEach(lotto -> addRankMap(lotto.getNumbers(), lotto_1st, bonusNumbers));
    }

    @Override
    public String toString() {
        return "당첨 통계"
                + "\n" + "---"
                + "\n" + Rank.fifth.getComment() + " - " + rankMap.get(Rank.fifth) + "개"
                + "\n" + Rank.fourth.getComment() + " - " + rankMap.get(Rank.fourth) + "개"
                + "\n" + Rank.third.getComment() + " - " + rankMap.get(Rank.third) + "개"
                + "\n" + Rank.second.getComment() + " - " + rankMap.get(Rank.second) + "개"
                + "\n" + Rank.first.getComment() + " - " + rankMap.get(Rank.first) + "개"
                + "\n" + calculateYield();
    }
    
    private Map<Rank, Integer> createRankMap() {
        HashMap<Rank, Integer> rankMap = new HashMap<>();

        rankMap.put(Rank.etc, 0);
        rankMap.put(Rank.fifth, 0);
        rankMap.put(Rank.fourth, 0);
        rankMap.put(Rank.third, 0);
        rankMap.put(Rank.second, 0);
        rankMap.put(Rank.first, 0);

        return rankMap;
    }

    private void addRankMap(List<Integer> numbers, Lotto lotto_1st, int bonusNumbers) {
        Rank rank = Rank.etc;

        rank = rank.setRank(countEqualNumbers(numbers, lotto_1st), numbers.contains(bonusNumbers));

        rankMap.put(rank, rankMap.get(rank) + 1);
    }

    private int countEqualNumbers(List<Integer> numbers, Lotto lotto_1st) {
        int count = 0;

        for (Integer number : numbers) {
            if (lotto_1st.getNumbers().contains(number)) {
                count++;
            }
        }

        return count;
    }

    private String calculateYield() {
        double receiveMoney = 0;

        for (Rank rank : rankMap.keySet()) {
            receiveMoney += rank.getPrice() * rankMap.get(rank);
        }

        double totalYield = (receiveMoney / originalMoney) * 100;

        return "총 수익률은 " + totalYield + "%입니다.";
    }
}
