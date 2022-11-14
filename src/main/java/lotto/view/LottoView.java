package lotto.view;

import lotto.domain.LottoMachine;
import lotto.message.Message;

import java.util.List;

public class LottoView {

    private LottoMachine lottoMachine;

    public LottoView() {
        this.lottoMachine = new LottoMachine();
    }

//  구매 매세지 출력하는 기능
    public void displayInputMoney() {
        System.out.println(Message.INPUT_MONEY_MESSAGE);
    }

//  구매한 로또 개수를 보여주는 기능
    public void displayLottoAmount(int number) {
        System.out.println(String.format(Message.PURCHASE_LOTTO_AMOUNT_MESSAGE, number));
    }

//  구매한 로또 보여주는 기능
    public void displayMyLottos(List<List<Integer>> lottos) {
        for (List<Integer> lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

//    당첨 번호 입력하라는 메세지 출력 기능
//    public void displayInputWinningNumber() {}

//    보너스 번호 입력하라는 메세지 출력 기능
//    public void displayInputBonusNumber() {}

//    당첨 통계 보여주는 기능
//    public void displayYield() {}

}
