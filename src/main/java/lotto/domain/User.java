package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int money;
    private int lottoCount;
    private int rewardMoney;

    private List<Lotto> lottos = new ArrayList<>();
    //TODO: 당첨 결과 리스트 추가, 로또금액 1000원 상수화
    private User(int money) {
        this.money = money;
        this.lottoCount = money / 1000;
    }

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
        checkMoneyMinimum(money);
        checkMoneyDivided(money);
    }
    public static void checkMoneyMinimum(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 이상이어야 합니다.");
        }
    }

    public static void checkMoneyDivided(int money) {
        if (money % 1000 != 0) {
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

    public List<Lotto> getLottos() {
        return lottos;
    }
}
