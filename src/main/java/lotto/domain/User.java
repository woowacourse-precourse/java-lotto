package lotto.domain;

import static lotto.util.GenerateLottoNumbers.generateLottoNumbers;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final int buyingPrice;
    private final int winningPrice;
    private List<UserLotto> lottos;

    public User(int buyingPrice) {
        lottos = new ArrayList<>();
        this.buyingPrice = buyingPrice;
        this.winningPrice = 0;
    }


    public void setLottos(int buyingPrice) {
        this.lottos = generateLottoNumbers(buyingPrice);
    }

    public List<UserLotto> getLottos() {
        return lottos;
    }

    public int getBuyingPrice() {
        return buyingPrice;
    }

    public int getWinningPrice() {
        return winningPrice;
    }
}
