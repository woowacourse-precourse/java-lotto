package lotto.domain;

import lotto.exception.ExceptionMessage;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class User {
    private int money;
    private int lottoCount;
    private int rewardMoney;

    private List<Lotto> lotties = new ArrayList<>();
    private Map<Reward, Integer> lottiesResult = new LinkedHashMap<>();

    private User(int money) {
        this.money = money;
        this.lottoCount = money / Lotto.PRICE;
    }

    public User() {
    }

    public static User initUserLotto(String inputMoney) {
        validateEmpty(inputMoney);

        int money = Integer.parseInt(inputMoney);
        validate(money);

        User user = new User(money);

        for (int i = 0; i < user.getLottoCount(); i++) {
            user.addUserLotto();
        }

        return user;
    }

    public void addUserLotto() {
        lotties.add(Lotto.generateLottoNumber());
    }

    public void initLottiesResult() {
        for (Reward reward : Reward.values()) {
            lottiesResult.put(reward, 0);
        }
    }

    public void saveResult(Reward reward) {
        lottiesResult.put(reward, lottiesResult.get(reward) + 1);
    }

    public Map<Reward, Integer> getLottiesResult() {
        return lottiesResult;
    }

    public void saveTotalReward() {
        for (Map.Entry<Reward, Integer> eachReward : lottiesResult.entrySet()) {
            Reward reward = eachReward.getKey();
            rewardMoney += reward.getReward() * eachReward.getValue();
        }
    }

    //validate check
    public static void validate(int money) {
        validateMoneyMinimum(money);
        validateMoneyDivided(money);
    }

    public static void validateEmpty(String inputMoney) {
        if (inputMoney == null || inputMoney.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_INPUT.getMessage());
        }
    }

    public static void validateMoneyMinimum(int money) {
        if (money < Lotto.PRICE) {
            throw new IllegalArgumentException(ExceptionMessage.MONEY_LOWER_BOUND_ERROR.getMessage());
        }
    }

    public static void validateMoneyDivided(int money) {
        if (money % Lotto.PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.MONEY_DIVIDE_ERROR.getMessage());
        }
    }

    //getter and setter
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public int getRewardMoney() {
        return rewardMoney;
    }

    public List<Lotto> getLotties() {
        return lotties;
    }


    // 테스트를 위한 메서드
    public void addLottoForTest(List<Integer> numbers) {
        lotties.add(new Lotto(numbers));
    }
}
