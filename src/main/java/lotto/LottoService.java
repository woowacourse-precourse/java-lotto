package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    private static final int PRICE = 1000;

    public List<Lotto> buyLottos(int money) {
        validateMoney(money);
        int amount = calculateAmount(money);
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            lottos.add(makeLotto());
        }

        return lottos;
    }

    private int calculateAmount(int money) {
        return money / PRICE;
    }

    private Lotto makeLotto() {
        List<Integer> lottoNumbers = LottoNumbersGenerator.generate();
        return new Lotto(lottoNumbers);
    }

    private void validateMoney(int money) {
        if (money % PRICE != 0) {
            throw new IllegalArgumentException(String.format("[ERROR] %d원 단위의 금액을 입력해주세요.", PRICE));
        }
    }
}
