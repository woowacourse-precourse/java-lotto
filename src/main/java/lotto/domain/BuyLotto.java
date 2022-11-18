package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.ErrorMessages;

import java.util.ArrayList;
import java.util.List;

public class BuyLotto {
    public static final int LOTTO_PRICE = 1000;
    private final int price;

    public BuyLotto(int price) {
        validatePrice(price);
        this.price = price;
    }

    private Lotto drawLotto(LottoNumberGenerator lottoNumberGenerator) {
        return new Lotto(lottoNumberGenerator.generate());
    }

    private List<Lotto> drawLottos(int count) {
        LottoNumberGenerator lottoNumberGenerator = new LottoRandomNumberGenerator();
        List<Lotto> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = drawLotto(lottoNumberGenerator);
            list.add(lotto);
        }
        return list;
    }

    private void validatePrice(int price) {
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessages.PRICE);
        }
    }

    public List<Lotto> getLottos() {
        return drawLottos(getCount());
    }

    public int getCount() {
        return price / LOTTO_PRICE;
    }
}
