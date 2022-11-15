package lotto.model;

import java.util.*;

public class LottoResult {
    private Map<Prize, Integer> lottoCount = new HashMap<>();
    private double yield;

    private List<Integer> numbers;
    private int bonusNumber;

    public LottoResult(int money, List<List<Integer>> lottos, List<Integer> numbers, int bonusNumber) {

        this.numbers = numbers;
        this.bonusNumber = bonusNumber;

        for(int i = 0; i < lottos.size(); i++){
            calculateLottoCount(lottos.get(i));
        }

        this.yield = calculateLottoYield(money);
    }

    private double calculateLottoYield(int money) {
        int earnMoney = 0;

        for (Map.Entry<Prize, Integer> entry : lottoCount.entrySet()) {
            earnMoney += entry.getValue() * entry.getKey().getWinningMoney();
        }

        return (double) Math.round((double)earnMoney*1000/ money)/10;
    }

    public void calculateLottoCount(List<Integer> lotto){
        Set<Integer> lottoSet = new HashSet<>(lotto);
        lottoSet.addAll(numbers);

        int count = 12 - lottoSet.size();

        Prize prize = Prize.get(count, lotto.contains(this.bonusNumber));
        lottoCount.put(prize, lottoCount.getOrDefault(prize, 0) + 1);
    }

    public Map<Prize, Integer> getLottoCount() {
        return lottoCount;
    }

    public double getYield() {
        return yield;
    }
}
