package lotto.controller;

import lotto.MyLottoList;
import lotto.MyPrize;
import lotto.PrizeLotto;
import lotto.view.AppView;
import lotto.view.LottoView;

public class AppController {
    private MyLottoList myLottoList;
    private PrizeLotto prizeLotto;
    private MyPrize myPrize;
    private int money;
    private int bonusNum;

    private void purchaseLotto() {
        AppView.outputLine("구입금액을 입력해 주세요.");
        money = LottoView.inputMoney();
        AppView.outputLine("");
        myLottoList = LottoController.generateMyLottoListInstance(money);
        AppView.outputLine(myLottoList.getCount() + "개를 구매했습니다.");
        LottoController.setMyLottoListLotto(myLottoList);
        LottoView.outputLottoList(myLottoList);
        AppView.outputLine("");
    }

    private void drawPrizeLotto() {
        AppView.outputLine("당첨 번호를 입력해 주세요.");
        prizeLotto = LottoController.generatePrizeLottoInstance();
        AppView.outputLine("");
        AppView.outputLine("보너스 번호를 입력해 주세요.");
        bonusNum = LottoView.inputBonusNum();
        LottoController.setBonusNum(prizeLotto, bonusNum);
        AppView.outputLine("");
    }

    private void showResult() {
        AppView.outputLine("당첨 통계");
        AppView.outputLine("---");
        myPrize = LottoController.generateMyPrizeInstance(myLottoList, prizeLotto);
        LottoView.outputSynthesisEachRank(myPrize);
        LottoView.outputProfitRate(myPrize.getProfitAmount(), money);
    }

    public void run() {
        purchaseLotto();
        drawPrizeLotto();
        showResult();
    }
}
