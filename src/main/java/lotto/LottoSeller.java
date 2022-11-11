package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoSeller {

    private static final int LOTTO_PRICE = 1000;

    private static LottoSeller instance;

    private LottoSeller() {
    }

    public static LottoSeller getInstance() {
        if (instance == null) {
            instance = new LottoSeller();
        }
        return LottoSeller.instance;
    }

    public List<Lotto> sellLotto(long amount) {
        validateAmount(amount);

        long sellableLotto = amount / LOTTO_PRICE;

        List<Lotto> lottos = new ArrayList<>();
        LottoNumberCreator lottoNumberCreator = LottoNumberCreator.getInstance();

        for (int i = 0; i < sellableLotto; i++) {
            List<Integer> numbers = lottoNumberCreator.getNumbers();
            Lotto lotto = new Lotto(numbers);

            lottos.add(lotto);
        }
        return lottos;
    }

    private void validateAmount(long amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("로또 구매 금액은 1,000 단위로만 입력 가능합니다.");
        }
    }
}
