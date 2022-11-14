package lotto.domain;

import lotto.setting.Setting;
import lotto.util.Input;

public class LottoMachine {

    private Money money;

//  돈 입력 기능
    public void inputMoney() throws IllegalArgumentException {
        money = new Money(Input.input());
    }

//  구매 개수 반환 기능
    public int getNumberOfLottoPurchases() {
        return (int)(money.getMoney() / Setting.PURCHASE_AMOUNT_UNIT);
    }

//    구매한 로또 반환 기능
//    public List<List<Integer>> getLottos() {}

//    당첨 결과 반환 기능
//    public List<Integer> getLottoResult() {}

//    당첨 수익률 반환 기능
//    public double getYield() {}
}
