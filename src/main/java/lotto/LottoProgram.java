package lotto;

import view.InputView;

public class LottoProgram {
    public void run(){
        //로또 구입, 지불 금액 입력
        LottoMoney lottoMoney = ReceiveMoney();
        // 로또 발급
        LottoCount lottoCount = calculateLottoCount(lottoMoney);
        // 로또 추첨 ( 로또 난수 생성 )

        // 당첨 로또 만들기

        // 등수 만들기

        // 출력하기
    }
    private LottoMoney ReceiveMoney(){
        return new LottoMoney(InputView.inputMoneyView());
    }
    private LottoCount calculateLottoCount(LottoMoney lottoMoney) {
        return new LottoCount(lottoMoney.changeToLottoCount());
    }
}
