package lotto.lotto;

import lotto.message.ExceptionMessage;
import lotto.setting.LottoSetting;
import java.util.ArrayList;
import java.util.List;

public class LottoShop {

    private int price;
    private LottoSetting setting;

    public LottoShop(int price, LottoSetting setting) {
        this.price = price;
        this.setting = setting;
    }

    public List<Lotto> buyLottoCreatedAuto(int totalPrice) {
        int countOfLotto = calculateCountOfLotto(totalPrice);
        return createAutoLotto(countOfLotto);
    }

    private int calculateCountOfLotto(int totalPrice) {
        if (totalPrice % price != 0) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_DIVIDED_PRISE.toString());
        }
        return totalPrice / price;
    }

    private List<Lotto> createAutoLotto(int countOfLotto) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 1; count <= countOfLotto; count++) {
            lottos.add(setting.createAutoLotto());
        }
        return lottos;
    }
}
