package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private int money;
    private int lottoCount;
    private int rewardMoney;

    private List<Lotto> lottos = new ArrayList<>();
    private Map<Reward, Integer> result = new HashMap<>();

    private User(int money) {
        this.money = money;
        this.lottoCount = money / Lotto.PRICE;
    }

    public User() {}

    public static User initUserLotto(int money) {
        User user = new User(money);
        validate(money);

        for (int i = 0; i < user.getLottoCount(); i++) {
            user.addUserLotto();
        }

        return user;
    }

    public void addUserLotto() {
        lottos.add(Lotto.generateLottoNumber());
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

    public void setLottoCount(int lottoCount) {
        this.lottoCount = lottoCount;
    }

    public int getRewardMoney() {
        return rewardMoney;
    }

    public void setRewardMoney(int rewardMoney) {
        this.rewardMoney = rewardMoney;
    }

    public List<Lotto> getLotties() {
        return lottos;
    }

    public void addResult(Reward reward, int count) {
        result.put(reward, count);
    }
}
