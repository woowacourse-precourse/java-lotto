package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private final List<Lotto> userLottos = new ArrayList<>();
    private final int price;

    public LottoGame(int price) {
        this.price = price;
        issueLotto();
    }

    private int countLotto() throws IllegalArgumentException {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR]구매 금액은 1000원 단위여야 합니다.");
        }
        return price / 1000;
    }

    private void issueLotto() {
        int lottoNum;
        LottoGenerator lottoGenerator = new LottoGenerator();

        lottoNum = countLotto();
        for (int count = 0; count < lottoNum; count++) {
            List<Integer> lotto = lottoGenerator.createRandomLotto();
            userLottos.add(new Lotto(lotto));
        }
    }

    public int getPrice() {
        return price;
    }

    public List<Lotto> getUserLottos() {
        return userLottos;
    }
}