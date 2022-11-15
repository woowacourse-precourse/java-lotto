package lotto.Model;

import java.math.BigInteger;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum PrizeMoney {
    PRIZE_FOR_THREE_MATCHING(3, 5000, "3개 일치 (5,000원) - "),
    PRIZE_FOR_FOUR_MATCHING(4, 50000, "4개 일치 (50,000원) - "),
    PRIZE_FOR_FIVE_MATCHING(5, 1500000, "5개 일치 (1,500,000원) - "),
    PRIZE_FOR_FIVE_MATCHING_WITH_BONUS(6, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    PRIZE_FOR_SIX_MATCHING(7, 2000000000, "6개 일치 (2,000,000,000원) - ");

    private final int index;
    private final int money;
    private final String outputValue;


    PrizeMoney(int index, int money, String outputValue) {
        this.index = index;
        this.money = money;
        this.outputValue = outputValue;
    }

    int getMoney(){
        return this.money;
    }
}
