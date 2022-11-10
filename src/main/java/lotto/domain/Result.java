package lotto.domain;

import lotto.check.WinningNumberCheck;

import java.util.*;

public class Result {

    private List<Integer> counts;

    private Map<Money, Integer> counting;

    private float profit;


    public List<Integer> getCounts() {
        return counts;
    }


    public Result() {
        init();
    }

    public Map<Money, Integer> getCounting() {
        return counting;
    }

    public float getProfit() {
        return profit;
    }

    public void calc(User user) {
        organize();
        Integer money = getMoney();
        profit = ((float) money / (float) user.getMoney()) * 100;
    }


    private Integer getMoney() {
        Integer totalMoney = 0;
        for (Map.Entry<Money, Integer> moneyEntry : counting.entrySet()) {
            totalMoney += moneyEntry.getKey().getDescription() * moneyEntry.getValue();
        }
        return totalMoney;
    }

    private void organize() {
        for (Integer count : counts) {
            if (count < 3) continue;
            Money enumString = toEnumString(count);
            Integer c = counting.get(enumString);
            counting.put(enumString, c + 1);
        }
    }

    private Money toEnumString(Integer count) {
        if (count == 3) return Money.FIFTH;
        if (count == 4) return Money.FOURTH;
        if (count == 5) return Money.THIRD;
        if (count == 6) return Money.FIRST;
        if (count == 7) return Money.SECOND;
        return null;
    }

    public void getCount(List<Lotto> userLottos, Lotto winningNumbers, Integer bonus) {
        List<Integer> numbers = winningNumbers.getNumbers();
        for (Lotto userLotto : userLottos) {
            List<Integer> userNumbers = userLotto.getNumbers();
            Integer countRes = hasNumber(userNumbers, numbers);
            countRes = getBonusRes(bonus, userNumbers, countRes);
            counts.add(countRes);
        }
    }

    private Integer getBonusRes(Integer bonus, List<Integer> userNumbers, Integer countRes) {
        if (countRes == 5 && hasBonus(userNumbers, bonus)) {
            countRes = 7;
        }
        return countRes;
    }

    private void init() {
        counts = new ArrayList<>();
        counting = new EnumMap<>(Money.class);
        for (Money value : Money.values()) {
            counting.put(value, 0);
        }
    }

    private Integer hasNumber(List<Integer> userNumbers, List<Integer> numbers) {
        Integer count = 0;
        for (Integer userNumber : userNumbers) {
            if (numbers.contains(userNumber)) count++;
        }
        return count;
    }

    private boolean hasBonus(List<Integer> userNumbers, Integer bonus) {
        if (userNumbers.contains(bonus)) {
            return true;
        }
        return false;
    }
}
