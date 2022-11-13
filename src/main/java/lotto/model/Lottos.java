package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final static int LOTTO_PRICE = 1000;

    private List<Lotto> lottos;

    // Todo : 1000원으로 나누어 떨어지지 않는 경우 예외 처리
    public Lottos(int money) {
        this.lottos = new ArrayList<>();
        generateLottos(money);
    }

    private void generateLottos(int money) {
        int amount = money / LOTTO_PRICE;
        for(int i = 0; i < amount; i++) {
            LottoNumberGenerator lottoNumber = new LottoNumberGenerator();
            lottos.add(new Lotto(lottoNumber.getNumber()));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
