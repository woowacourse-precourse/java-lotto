package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoMachine {
    public void requestWantBuyAmountInputMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public int canBuyAmount(int wantBuyAmountInput) {
        return wantBuyAmountInput / 1000;
    }

    public List<Integer> makeUserRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
