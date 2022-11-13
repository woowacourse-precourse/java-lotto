package lotto.service;

import lotto.domain.Prize;

import java.util.ArrayList;
import java.util.Arrays;

public class UserService {

    private final static ArrayList<Prize> PRIZE_TYPE = new ArrayList<>(Arrays.asList(
            Prize.FIRST_PLACE,
            Prize.SECOND_PLACE,
            Prize.THIRD_PLACE,
            Prize.FOURTH_PLACE,
            Prize.FIFTH_PLACE));

    public String calculateTheRateOfReturn(int prizeMoney, int purchaseMoney) {
        float rateOfReturn = ((float) prizeMoney / (float) purchaseMoney) * 100;
        return String.format("%.1f", rateOfReturn);
    }

    public int calculateUserPrize(ArrayList<Integer> numberOfWins) {
        int totalPrizeMoney = 0;
        for (int i = 0; i < 5; i++) {
            totalPrizeMoney += PRIZE_TYPE.get(i).getPrizeMoney() * numberOfWins.get(i);
        }
        return totalPrizeMoney;
    }
}
