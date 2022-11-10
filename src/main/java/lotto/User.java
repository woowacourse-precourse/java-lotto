package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class User {
    private List<Lotto> lottos;
    private int lottoNum;
    private int money;
    private double earn;


    public User(int money) {
        validateMoney(money);

        this.money = money;
        this.lottoNum = money / 1000;
        generateLottos();
        this.earn = 0.0;
    }


    private void validateMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    private void generateLottos() {
        for(int i = 0; i < this.lottoNum; i++) {
            Lotto lotto = Lotto.generateLotto();

            lottos.add(lotto);
        }
    }
}
