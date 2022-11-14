package lotto.model;

import lotto.Constant;
import lotto.enums.Rank;

import java.util.HashMap;
import java.util.Map;

public class Rate {

    private Map<Rank,Integer> rankPrice;    // <Rank, 상금(price)> Map
    private double earningRate; // 수익률

    public Rate(Map<Rank,Integer> winningStats, int price){
        setRankPrice();
        setEarningRate(winningStats, price);
    }

    public double getEarningRate() {
        return this.earningRate;
    }

    // rankPrice 초기화
    private void setRankPrice(){
        Map<Rank,Integer> rankPrice = new HashMap<>();
        rankPrice.put(Rank.first, Constant.firstRankPrice);
        rankPrice.put(Rank.second,Constant.secondRankPrice);
        rankPrice.put(Rank.third,Constant.thirdRankPrice);
        rankPrice.put(Rank.fourth,Constant.fourthRankPrice);
        rankPrice.put(Rank.fifth,Constant.fifthRankPrice);
        this.rankPrice = rankPrice;
    }

    // 수익률 계산
    private void setEarningRate(Map<Rank,Integer> winningStats, int price) {
        int earningPrice = calcEarning(winningStats);
        this.earningRate = Math.round((earningPrice / (double)price) * 100 * 10) / 10.0;
    }

    // 전체 수익 금액 계산
    private int calcEarning(Map<Rank,Integer> winningStats) {
        int earningPrice = 0;

        for (Map.Entry<Rank, Integer> elem : winningStats.entrySet()) {
            earningPrice += rankPrice.get(elem.getKey()) * elem.getValue();
        }
        return earningPrice;
    }

}
