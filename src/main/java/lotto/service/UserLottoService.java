package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.IntConstant;
import lotto.domain.Lotto;

public class UserLottoService {

    private final String userInputMoney;

    private final int perLottoMoney;

    public UserLottoService(String userInputMoney) {
        this.userInputMoney = userInputMoney;
        this.perLottoMoney = IntConstant.LOTTO_MONEY_PER_ONE.getValue();
    }

    public List<Lotto> createLottoNumber() {
        int lottoCount = howManyLottoCanBuy();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

    private int howManyLottoCanBuy() {
        return Integer.parseInt(userInputMoney) / perLottoMoney;
    }
}
