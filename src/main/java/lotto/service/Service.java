package lotto.service;

import lotto.constant.LottoMoney;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.*;

import static lotto.constant.LottoMoney.*;
import static lotto.exception.ExceptionPhrase.EXCEPTION_INVALID_RESULT;

public class Service {

    public HashMap<Integer, Integer> rewards= new HashMap<>();
     {
        rewards.put(FIRST.getReward(),0);
        rewards.put(SECOND.getReward(),0);
        rewards.put(THIRD.getReward(),0);
        rewards.put(FOURTH.getReward(),0);
        rewards.put(FIFTH.getReward(),0);
        rewards.put(NO_MONEY.getReward(),0);
    }

    public Service() {
    }


    private BigDecimal multiplyPrize(Integer reward, Map<Integer ,Integer> rewards) {
        int count = rewards.get(reward);

        BigDecimal money = new BigDecimal(reward);
        BigDecimal win = toInteger(count);

        return money.multiply(win);
    }

    private BigDecimal toInteger(int count) {
        String winning = String.valueOf(count);
        return new BigDecimal(winning);
    }

    // 일치하는 로또 개수 구하는 로직
    public Map<Integer, Integer> matchLotteryNumber(List<List<Integer>> lottoNumbers, List<Integer> playerNumbers, int bonusNumber) {

        for(List<Integer> lottoNumber : lottoNumbers) {
            int count = countMatchedNumber(lottoNumber, playerNumbers);
            boolean bonus = lottoNumber.contains(bonusNumber);
            countRewards(count, bonus);
        }
        return rewards;
    }
    private int countMatchedNumber(List<Integer> lottoNumber, List<Integer> playerNumbers) {
        int count = 0;
        for (int playerNumber : playerNumbers) {
            if (lottoNumber.contains(playerNumber)) {
                count += 1;
            }
        }
        return count;
    }

    private void countRewards(int count, boolean bonus) {
        if(count <= 6) {
            int value;
            if(count != THIRD.getCount()) {
                bonus = false;
            }
            int prize = prizeCalculate(count, bonus);
            value = rewards.get(prize);
            value += 1;
            rewards.put(prize, value);
            return;
        }
        throw new IllegalArgumentException(EXCEPTION_INVALID_RESULT.getMessage());
    }

    private int prizeCalculate(int count, boolean bonus) {
        return LottoMoney.getRankReward(count, bonus);
    }

    //수익률 구하는 로직

    public String sumTotalReward(Map<Integer , Integer> rewards) {
        Set<Integer> reward =  rewards.keySet();

        BigDecimal totalPrize = new BigDecimal(BigInteger.ZERO);
        for (Integer money : reward) {
            BigDecimal price = multiplyPrize(money, rewards);

            totalPrize = totalPrize.add(price);
        }
        return totalPrize.toString();
    }

    public String profitRate(int lottoCount) {
        String sumReward = sumTotalReward(rewards);

        BigDecimal reward = new BigDecimal(sumReward);
        BigDecimal money = new BigDecimal(lottoCount);
        reward = reward.multiply(new BigDecimal("100"));

        BigDecimal result = reward.divide(money, 1,RoundingMode.HALF_UP);

        return result.toString();
    }
}
