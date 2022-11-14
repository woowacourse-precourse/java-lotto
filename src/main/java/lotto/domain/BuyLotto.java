package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.ErrorMessages;

import java.util.ArrayList;
import java.util.List;

public class BuyLotto {
    public static final int LOTTO_PRICE = 1000;
    int price;
    int count;
    List<Lotto> lottos;

    public BuyLotto(int price) {
        validatePrice(price);
        this.price = price;
        count = numberOfLotto();
        lottos = drawLottos(count);
    }

    private int numberOfLotto() {
        return price / LOTTO_PRICE;
    }

    private List<Integer> drawLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lottoNumbers;
    }

    private List<Lotto> drawLottos(int count) {
        List<Lotto> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(drawLotto());
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
        return lottos;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }
}
