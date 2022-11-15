package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {
    public Lotto pickNumber(){
        return new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6));
    }

    public List<Lotto> purchaseLottos(UserMoney money) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money.lottoTicketQuantity(); i++) {
            lottos.add(pickNumber());
        }
        return lottos;
    }
}
