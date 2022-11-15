package lotto.domain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class LottoAccounting {
    private static final String _1st_reward = "2000000000";
    private static final String _2nd_reward = "30000000";
    private static final String _3rd_reward = "1500000";
    private static final String _4th_reward = "50000";
    private static final String _5th_reward = "5000";

    // 수익률 계산 함수
    public static BigDecimal getROR(int[] matchTable, int money) {
        validateMatchTable(matchTable);

        BigDecimal reward = new BigDecimal(sumReward(matchTable));
        reward = reward.divide(new BigDecimal(String.valueOf(money)), 3, RoundingMode.CEILING);
        reward = reward.multiply(new BigDecimal("100"));

        return reward.setScale(1, RoundingMode.HALF_UP);
    }

    private static void validateMatchTable(int[] matchTable) {
        if (matchTable == null || matchTable.length != 5) {
            throw new IllegalArgumentException("[ERROR] 매치 테이블 값에서 에러가 발생했습니다.");
        }
    }

    private static BigInteger sumReward(int[] matchTable) {
        BigInteger reward = new BigInteger("0");
        String[] rewardTable = {_1st_reward, _2nd_reward, _3rd_reward, _4th_reward, _5th_reward};

        for (int i = 0; i < matchTable.length; ++i) {
            BigInteger nowReward = new BigInteger(rewardTable[i]);
            BigInteger count = new BigInteger(String.valueOf(matchTable[i]));
            nowReward = nowReward.multiply(count);
            reward = reward.add(nowReward);
        }
        return reward;
    }
}
