package lotto.domain;

import lotto.check.WinningNumberCheck;

import java.util.*;

public class Result {

    /**
     * counts - 당첨 번호와 사용자 로또 번호를 비교하여 맞춘 개수를 담고 있는 리스트
     * counting - 맞춘 갯수별 횟수를 담고 있는 Enum 맵
     */
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


    /**
     * 사용자가 로또를 통해 번 돈을 구하는 기능
     */
    private Integer getMoney() {
        Integer totalMoney = 0;
        for (Map.Entry<Money, Integer> moneyEntry : counting.entrySet()) {
            totalMoney += moneyEntry.getKey().getDescription() * moneyEntry.getValue();
        }
        return totalMoney;
    }

    /**
     * 사용자가 맞춘 횟수가 담겨 있는 counts 리스트를 맞춘 횟수 별로 정리하는 기능
     */
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

    /**
     * 사용자의 로또와 당첨번호를 비교하여 맞춘 개수를 구하는 기능
     */
    public void compare(List<Lotto> userLottos, Lotto winningNumbers, Integer bonus) {
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
