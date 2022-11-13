package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoResult {

    private int[] lottoCount = new int[5];
    private float yield;
    private int[] winningMoney = {5000, 50000, 1500000, 30000000, 2000000000};

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

    private float calculateLottoYield(int money) {
        int earnMoney = 0;
        for(int i = 0; i < this.lottoCount.length; i ++){
            earnMoney += lottoCount[i] * winningMoney[i];
        }
        return (float) Math.round((float)earnMoney*1000/ money)/10;
    }

    public void calculateLottoCount(List<Integer> lotto){
        Set<Integer> lottoSet = new HashSet<>(lotto);
        lottoSet.addAll(numbers);

        int count = 12 - lottoSet.size();

        if(count == 3){ 
            this.lottoCount[0]++; 
        } else if (count == 4) {
            this.lottoCount[1]++;
        } else if (count == 5 && lotto.contains(this.bonusNumber)) {
            this.lottoCount[3]++;
        } else if (count == 5) {
            this.lottoCount[2]++;
        } else if (count == 6) {
            this.lottoCount[4]++;
        }
    }

    public int[] getLottoCount() {
        return lottoCount;
    }

    public float getYield() {
        return yield;
    }
}
