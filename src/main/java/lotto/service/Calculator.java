package lotto.service;

import lotto.PrizeDetails;

import java.util.List;

public class Calculator {
    static Double calcStatistics(Integer lottoCount, List<Integer> priceList) {
        int purchasePrice = (lottoCount) * 1000;
        int income = priceList.stream().mapToInt(i -> i).sum();
        return ((double) income / (double) purchasePrice) * 100;
    }

    public static long prizeDetailCount(List<PrizeDetails> prizeDetails, PrizeDetails threePrize) {
        return prizeDetails.stream().filter(p -> p == threePrize).count();
    }
}