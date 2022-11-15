package lotto.domain;

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

    //validate check
    public static void validate(int money) {
        validateMoneyMinimum(money);
        validateMoneyDivided(money);
    }

    public static void validateMoneyMinimum(int money) {
        if (money < Lotto.PRICE) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 이상이어야 합니다.");
        }
    }

    public static void validateMoneyDivided(int money) {
        if (money % Lotto.PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원으로 나누어 떨어져야 합니다.");
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

    // 테스트를 위한 메서드
    public void addLottoForTest(List<Integer> numbers) {
        lotties.add(new Lotto(numbers));
    }
}
