package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.Utils.Error;
import lotto.Utils.CommonUtil;
import lotto.Utils.Message;

import java.util.*;

public class LottoStore {
    private int purchase;

    private void validate(int money) {
        if (money < 1000) {
            Error.generate(Message.AMOUNT);
        }
        if (money % 1000 != 0) {
            Error.generate(Message.AMOUNT);
        }
    }
    public void inputPurchase() {
        String input = Console.readLine();

        purchase = CommonUtil.stringToNumber(input);
        validate(purchase);
    }
    public List<Lotto> buyLotto() {
        List<Lotto> lottos = new ArrayList<>();

        int count = purchase / 1000;
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
    }

    public int getPurchase() {
        return purchase;
    }
}
