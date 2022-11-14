package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int money;
    private int lottoCount;
    private int rewardMoney;

    private List<Lotto> lottos = new ArrayList<>();
    //TODO: 당첨 결과 리스트


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
