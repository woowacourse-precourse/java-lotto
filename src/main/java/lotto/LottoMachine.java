package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoMachine {
    public void requestWantBuyAmountInputMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void canBuyAmountMessage(int canBuyAmount) {
        System.out.println();
        System.out.println(canBuyAmount+"개를 구매했습니다.");
    }

    public int canBuyAmount(int wantBuyAmountInput) {
        return wantBuyAmountInput / 1000;
    }

    public List<Integer> makeUserRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public Lotto makeLotto(List<Integer> makeUserRandomLottoNumbers) {
        return new Lotto(makeUserRandomLottoNumbers);
    }
}
