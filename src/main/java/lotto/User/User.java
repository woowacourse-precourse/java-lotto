package lotto.User;

import lotto.BoughtLotto;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class User {
    List<BoughtLotto> lottos;

    public User() {
        this.lottos = new ArrayList<>();
    }

    public void buyLottos(int money) {
        if (!validateMoney(money)) {
           throw new IllegalArgumentException("금액을 잘못 입력하셨습니다.");
        }
        int countOfBuyLotto = money / 1000;
        for (int i = 0; i < countOfBuyLotto; i++) {
            lottos.add(new BoughtLotto());
        }
    }

    private boolean validateMoney(int money) {
        return money % 1000 == 0;
    }

    public void printLottos() {

    }

    public void printOneLotto(BoughtLotto lotto) {
        lotto.printLottoNumber();
    }

    public List<BoughtLotto> getLottos() {
        return lottos;
    }
}
