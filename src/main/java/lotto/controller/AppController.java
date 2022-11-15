package lotto.controller;

import lotto.MyLottoList;
import lotto.MyPrize;
import lotto.PrizeLotto;
import lotto.view.AppView;
import lotto.view.LottoView;

import java.util.List;

public class AppController {
    private MyLottoList myLottoList;
    private PrizeLotto prizeLotto;
    private MyPrize myPrize;
    private int money;
    private List<Integer> prizeNum;
    private int bonusNum;

    private void purchaseLotto() {
        AppView.outputLine("구입금액을 입력해 주세요.");
        money = LottoView.inputMoney();
        AppView.outputLine("");
        myLottoList = LottoController.generateMyLottoListInstance();
        LottoController.setMyLottoListMoney(myLottoList, money);
        LottoController.setMyLottoListLotto(myLottoList);
        AppView.outputLine(myLottoList.getCount() + "개를 구매했습니다.");
        LottoView.outputLottoList(myLottoList);
        AppView.outputLine("");
    }

    private void drawPrizeLotto() {
        AppView.outputLine("당첨 번호를 입력해 주세요.");
        prizeNum = LottoView.inputPrizeLotto();
        prizeLotto = LottoController.generatePrizeLottoInstance();
        LottoController.setPrizeLotto(prizeLotto, prizeNum);
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
