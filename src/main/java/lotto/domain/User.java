package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final Integer MONEY;

    private List<Lotto> lottos = new ArrayList<>();

    private Integer benefit;

    public User(Integer money) {
        validate(money);
        this.MONEY = money;
        this.benefit = 0;
    }

    private void validate(Integer money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("예수금은 1000원 단위여야 합니다.");
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Integer getLottoCount() {
        return MONEY / 1000;
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public void increasePrize(Integer prize){
        this.benefit += prize;
    }

    public double getYield() {
        return benefit / MONEY * 100;
    }
}
