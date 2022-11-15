package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.Utils.Error;
import lotto.Utils.commonUtil;

import java.util.*;

public class LottoStore {
    private int purchase;

    private void validate(int money) {
        if (money < 1000) {
            Error.amountInput();
        }
        if (money % 1000 != 0) {
            Error.amountInput();
        }
    }
    public void inputPurchase() {
        String input = Console.readLine();

        purchase = commonUtil.stringToNumber(input);
        validate(purchase);
    }
    public List<Lotto> buyLotto() {
        List<Lotto> lottoList = new ArrayList<>();

        int count = purchase / 1000;
        for (int i = 0; i < count; i++) {
            lottoList.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottoList;
    }

    public int getPurchase() {
        return purchase;
    }
}
