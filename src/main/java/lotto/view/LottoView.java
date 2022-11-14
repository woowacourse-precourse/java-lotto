package lotto.view;

import lotto.domain.LottoMachine;
import lotto.message.Message;

public class LottoView {

    private LottoMachine lottoMachine;

    public LottoView() {
        this.lottoMachine = new LottoMachine();
    }

//  구매 매세지 출력하는 기능
    public void displayInputMoney() {
        System.out.println(Message.INPUT_MONEY_MESSAGE);
    }

//    구매한 로또 보여주는 기능
//    public void displayMyLottos() {}

//    당첨 번호 입력하라는 메세지 출력 기능
//    public void displayInputWinningNumber() {}

//    보너스 번호 입력하라는 메세지 출력 기능
//    public void displayInputBonusNumber() {}

//    당첨 통계 보여주는 기능
//    public void displayYield() {}

}
