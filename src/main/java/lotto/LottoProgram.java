package lotto;

import view.InputView;
import view.OutputView;

import static view.InputView.*;
import static view.OutputView.*;

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
        // 구매한 모든 로또의 번호 내역 출력
        printLottoCollection(lottoCollection);
        // 당첨 로또 만들기
        WinningNumber winningNumber = makeWinningNumber();
        // 등수 만들기
        LottoRank lottoRank = makeRank(lottoCollection, winningNumber);
        // 출력하기
        printWinningResult(lottoRank);
        //수익률 계산
        printRewardRatio(lottoMoney,lottoRank);
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
        return new WinningNumber(new Lotto(inputWinningNumberView()),inputBonusNumberView());
    }
    private LottoRank makeRank(LottoCollection lottoCollection, WinningNumber winningNumber){
        //유저가 뽑은 로또들과 당첨 번호로 등수 Info 만들기
        //로또 등수를 모아놓은 class 만들기
        return new LottoRank(lottoCollection,winningNumber);
    }
}
