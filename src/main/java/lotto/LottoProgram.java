package lotto;

import view.InputView;
import view.OutputView;

import static view.InputView.*;

public class LottoProgram {
    public void run() {
        //로또 구입, 지불 금액 입력
        LottoMoney lottoMoney = ReceiveMoney();
        // 로또 발급
        LottoCount lottoCount = calculateLottoCount(lottoMoney);
        // 로또 개수 출력
        OutputView.printLottoCount(lottoCount);
        // 로또 추첨 ( 로또 난수 생성 )
        LottoCollection lottoCollection = makeLottoNumber(lottoCount);
        // 당첨 로또 만들기

        // 등수 만들기

        // 출력하기
    }
    private LottoMoney ReceiveMoney() {
        return new LottoMoney(inputMoneyView());
    }
    private LottoCount calculateLottoCount(LottoMoney lottoMoney) {
        return new LottoCount(lottoMoney.changeToLottoCount());
    }
    private LottoCollection makeLottoNumber(LottoCount lottoCount) {
        return LottoMachine.CreateWinningNumber(lottoCount);
    }

    private WinningNumber makeWinningNumber() {
        //로또 당첨번호 콘솔 입력, 그리고 보너스 번호 입력
        //뷰, 로또 번호는 List, 보너스는 int
//        inputWinningNumberView();
//        inputBonusNumberView();
        return null;
    }
}
