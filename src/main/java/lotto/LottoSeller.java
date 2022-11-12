package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import user.Money;
import user.User;

import java.util.ArrayList;
import java.util.List;

public class LottoSeller {
    private final int BASE_MONEY = 1000;
    private final boolean NOT_HAVE = false;

    private int lottoMount(Money money) {
        return money.getMoney() / BASE_MONEY;
    }

    private Lotto makeLotto() {
        List lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = new Lotto(lottoNumbers);
        return lotto;
    }

    public void giveLottos(User user) {
        List<Lotto> purchaseLottos = new ArrayList<>();
        List<String> duplicateCheckList = new ArrayList<>();
        Lotto lotto;
        while (purchaseLottos.size() < lottoMount(user.getSeedMoney())) {
            lotto = makeLotto();
            if (duplicateCheckList.contains(lotto.toString()) == NOT_HAVE) {
                purchaseLottos.add(lotto);
                duplicateCheckList.add(lotto.toString());
            }
        }
        user.setLottos(purchaseLottos);
    }
}
