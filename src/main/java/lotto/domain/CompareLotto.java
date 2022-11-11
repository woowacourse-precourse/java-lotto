package lotto.domain;


import java.util.*;

public class CompareLotto {
    private final Map<Rank, Integer> rankByCount;
    private final int originalMoney;

    public CompareLotto(LottoDto lottoDto, Lotto lotto_1st, int bonusNumbers) {
        this.rankByCount = createRankMap();
        this.originalMoney = 1000 * lottoDto.getLottoList().size();

        lottoDto.getLottoList()
                .forEach(lotto -> addRankMap(lotto.getNumbers(), lotto_1st, bonusNumbers));
    }

    @Override
    public String toString() {
        return "당첨 통계"
                + "\n" + "---"
                + "\n" + Rank.fifth.getComment() + " - " + rankByCount.get(Rank.fifth) + "개"
                + "\n" + Rank.fourth.getComment() + " - " + rankByCount.get(Rank.fourth) + "개"
                + "\n" + Rank.third.getComment() + " - " + rankByCount.get(Rank.third) + "개"
                + "\n" + Rank.second.getComment() + " - " + rankByCount.get(Rank.second) + "개"
                + "\n" + Rank.first.getComment() + " - " + rankByCount.get(Rank.first) + "개"
                + "\n" + calculateYield();
    }
    
    private Map<Rank, Integer> createRankMap() {
        HashMap<Rank, Integer> rankByCount = new HashMap<>();

        rankByCount.put(Rank.etc, 0);
        rankByCount.put(Rank.fifth, 0);
        rankByCount.put(Rank.fourth, 0);
        rankByCount.put(Rank.third, 0);
        rankByCount.put(Rank.second, 0);
        rankByCount.put(Rank.first, 0);

        return rankByCount;
    }

    private void addRankMap(List<Integer> numbers, Lotto lotto_1st, int bonusNumbers) {
        Rank rank = Rank.etc;

        rank = rank.setRank(countEqualNumbers(numbers, lotto_1st), numbers.contains(bonusNumbers));

        rankByCount.put(rank, rankByCount.get(rank) + 1);
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

        for (Rank rank : rankByCount.keySet()) {
            receiveMoney += rank.getPrice() * rankByCount.get(rank);
        }

        double totalYield = (receiveMoney / originalMoney) * 100;

        return "총 수익률은 " + totalYield + "%입니다.";
    }
}
