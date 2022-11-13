package lotto;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final int money;
    private final int LOTTO_PRICE = 1000;

    public List<Lotto> playerLotto = new ArrayList<>();

    public Player(int money) {
        this.money = money;
        getLotto(money);
    }

    private void getLotto(int money) {
        int count = 0;
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        while (count < money / LOTTO_PRICE) {
            List<Integer> randomNumber = lottoNumberGenerator.generateLottoNumbers();
            Lotto lotto = new Lotto(randomNumber);
            lotto.generateBonusNumber();
            this.playerLotto.add(lotto);
            count++;
        }
    }
}
